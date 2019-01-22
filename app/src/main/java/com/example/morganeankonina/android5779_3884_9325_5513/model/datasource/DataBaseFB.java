package com.example.morganeankonina.android5779_3884_9325_5513.model.datasource;

import android.support.design.widget.Snackbar;
import android.widget.Toast;

import com.example.morganeankonina.android5779_3884_9325_5513.entities.Travel;
import com.example.morganeankonina.android5779_3884_9325_5513.model.backend.Backend;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Class DataBaseFB to add travel in a FB
 */
public class DataBaseFB implements Backend {
    /**
     * The function addTravel to add a travel to the DB
     * @param travel
     * @throws Exception
     */
    @Override
    public void addTravel(Travel travel) throws Exception {
        try {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Travel");
            String key = String.valueOf(travel.getId());
            //myRef.child(key).setValue(travel);
            ////String key= Integer.toString(travel.getId());
            myRef.child(key).setValue(travel.toString());
        }
        catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String toString() {
        return "DatabaseFB{}";
    }
}
