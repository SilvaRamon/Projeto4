package com.example.ramon.tabapp;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by Pichau on 27/12/2016.
 */

public class FirebaseHelper {
    DatabaseReference db;
    Boolean saved;

    ArrayList<Denuncia> denuncias = new ArrayList<>();

    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }

    public Boolean Save(Denuncia denuncia){
        if(denuncia == null){
            saved = false;
        }else{
            try{
                db.child("Denuncia").push().setValue(denuncia);
                saved = true;
            }catch (DatabaseException e){
                e.printStackTrace();
                saved = false;
            }
        }
        return saved;
    }

    private void fetchData(DataSnapshot dataSnapshot){
        denuncias.clear();

        for(DataSnapshot ds : dataSnapshot.getChildren()){
            Denuncia denuncia = ds.getValue(Denuncia.class);
            denuncias.add(denuncia);
        }
    }

    public ArrayList<Denuncia> retrieve(){
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return denuncias;
    }
}
