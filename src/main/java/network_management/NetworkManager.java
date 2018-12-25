/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network_management;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.EventListener;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreException;
import com.google.cloud.firestore.ListenerRegistration;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.*;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.google.firebase.cloud.FirestoreClient;
import game_management.GameManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import menu_management.MainMenuController;

/**
 *
 * @author murattuver
 */
public class NetworkManager {
    
    private static Firestore db;
    private static String currentGameID;
    private static GameManager gameManager;
    private String playerNo;
    private boolean isGameStarted = false;
    private MainMenuController menuController;
    
    public NetworkManager(MainMenuController menuController){
     
        this.menuController = menuController;
        
        FileInputStream serviceAccount = null;
        
        try {
            serviceAccount = new FileInputStream("cerca-trova-6d31d-firebase-adminsdk-6f51n-f32dab6c3d.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://cerca-trova-6d31d.firebaseio.com/")
                    .build();
            FirebaseApp.initializeApp(options);
            db = FirestoreClient.getFirestore();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NetworkManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NetworkManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                serviceAccount.close();
            } catch (IOException ex) {
                Logger.getLogger(NetworkManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void createOnlineGame(String lobbyName, int columnNumber){

        // Add document data with auto-generated id.
        Map<String, Object> data = new HashMap<>();

        ArrayList<Boolean> p1Board = new ArrayList<>();
        ArrayList<Boolean> p2Board = new ArrayList<>();
        ArrayList<Long> colors = new ArrayList<>();
        
        for(int i = 0; i < columnNumber * 5; i++){
            p1Board.add(Boolean.FALSE);
            p2Board.add(Boolean.FALSE);
            colors.add(Long.parseLong("0"));
        }
        
        data.put("p1Board", p1Board);
        data.put("p2Board", p2Board);
        data.put("p1Colors", colors);
        data.put("p2Colors", colors);
        data.put("level", columnNumber - 4);
        data.put("lobbyName", lobbyName);
        data.put("isMatched", Boolean.FALSE);
        data.put("winner", 0);


        ApiFuture<DocumentReference> addedDocRef = db.collection("games").add(data);
        try {
            currentGameID = addedDocRef.get().getId();

            System.out.println("Added document with ID: " + currentGameID);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(NetworkManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(NetworkManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
    public boolean destroyOnlineGame(){
        
        try {
            ApiFuture<WriteResult> writeResult = db.collection("games").document(currentGameID).delete();
            System.out.println("Update time : " + writeResult.get().getUpdateTime());
            stopDatabaseListener();
            return true;
        } catch (InterruptedException ex) {
            Logger.getLogger(NetworkManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ExecutionException ex) {
            Logger.getLogger(NetworkManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void setGameID(String id){
        currentGameID = id;
    }
    
    public HashMap getLobbies(){
        
        HashMap availableLobbies = new HashMap<String,ArrayList<String>>();
        
        try {
            ApiFuture<QuerySnapshot> future = db.collection("games").get();
            
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                HashMap data = (HashMap)document.getData();
                
                ArrayList<String> lobbyInfo = new ArrayList<>();

                if(!(boolean)data.get("isMatched")){
                    
                    lobbyInfo.add("" + data.get("lobbyName"));
                    lobbyInfo.add("" + data.get("level"));
                    availableLobbies.put(document.getId(), lobbyInfo);
                }
            }       
        } catch (InterruptedException ex) {
            Logger.getLogger(NetworkManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(NetworkManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return availableLobbies;
    }
    
    public void setGameManager(GameManager gm){
        gameManager = gm;
    }
    
    public void setIsGameStarted(boolean b){
        isGameStarted = b;
    }
    
    public void setGameMatched(boolean isGameMatched){
        try {
            DocumentReference docRef = db.collection("games").document(currentGameID);
            
            ApiFuture<WriteResult> future = docRef.update("isMatched", true);
            
            WriteResult result = future.get();
            System.out.println("Write result: " + result);
        } catch (InterruptedException ex) {
            Logger.getLogger(NetworkManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(NetworkManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void startDatabaseListener(){
        DocumentReference docRef = db.collection("games").document(currentGameID);
        
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirestoreException e) {
                if (e != null) {
                    System.err.println("Listen failed: " + e);
                    return;
                }

                if (snapshot != null && snapshot.exists()) {
                    System.out.println("Current data: " + snapshot.getData());
                    
                    if(isGameStarted){
                        gameManager.setMultiData((HashMap)snapshot.getData());
                    } else{
                        HashMap newData = (HashMap) snapshot.getData();
                        
                        if(Boolean.TRUE.equals(newData.get("isMatched"))){
                            //menuController.setLevelNo(((Long)newData.get("level")).intValue());
                            menuController.startMultiGame();
                        }
                    }

                } else {
                    System.out.print("Current data: null");
                }
            }
        });
    }
    
  public void stopDatabaseListener() {
    
    Query query = db.collection("cities");
    ListenerRegistration registration = query.addSnapshotListener(
        new EventListener<QuerySnapshot>() {

          @Override
          public void onEvent(@Nullable QuerySnapshot snapshots,
                              @Nullable FirestoreException e) {}}
    );

    registration.remove();
  }
    
    public void sendBoardData(Map<String, Object> data){
      
        DocumentReference docRef = db.collection("games").document(currentGameID);
            
        ApiFuture<WriteResult> writeResult = docRef.update((HashMap)data);
            
        try {
            System.out.println("Update time : " + writeResult.get().getUpdateTime());
        } catch (InterruptedException ex) {
            Logger.getLogger(NetworkManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(NetworkManager.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    
    public boolean createAccount(String email, String password, String displayName){
        try {
            CreateRequest request = new CreateRequest()
                    .setEmail(email).setEmailVerified(false)
                    .setPassword(password)
                    .setDisplayName(displayName)
                    .setDisabled(false);
            
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            System.out.println("Successfully created new user: " + userRecord.getUid());
            
            return true;
            
        } catch (FirebaseAuthException ex) {
            Logger.getLogger(NetworkManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void setWinner(int winnerPlayer){
        try {

            DocumentReference docRef = db.collection("games").document(currentGameID);
            
            ApiFuture<WriteResult> future = docRef.update("winner", winnerPlayer);
            
            WriteResult result = future.get();
            System.out.println("Write result: " + result);
        } catch (InterruptedException ex) {
            Logger.getLogger(NetworkManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(NetworkManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean fetchUserData(String mail, String password){
        try {
            UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(mail);
            System.out.println("Successfully fetched user data: " + userRecord.getEmail());
            
            
            
            return true;
        } catch (FirebaseAuthException ex) {
            Logger.getLogger(NetworkManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
