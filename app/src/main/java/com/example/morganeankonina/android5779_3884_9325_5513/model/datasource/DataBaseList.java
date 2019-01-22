package com.example.morganeankonina.android5779_3884_9325_5513.model.datasource;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

import com.example.morganeankonina.android5779_3884_9325_5513.entities.Travel;
import com.example.morganeankonina.android5779_3884_9325_5513.model.backend.Backend;
import java.util.ArrayList;

/**
 * Class DataBaseList to add travel in a list
 */
//Check later if works!!!!!!!!!!!!!!!!!!!!!!!
public class DataBaseList implements Backend {
    ArrayList<Travel>travels=new ArrayList<>();
    Context context;

    /**
     * function addTravel to add travel to a list
     * @param travel
     * @throws Exception
     */
    @Override
    public void addTravel(Travel travel) throws Exception {
        try{
            for (Travel item: travels)
            {
                if(item.equals(travel))
                    throw new Exception ("Travel already exist");
            }
            travels.add(travel);
            for (Travel item: travels) {
                System.out.println(item.toString());
            }
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public String getTravel()
    {
        String travelsList="";
        if (travels.size()==0)
            return "No travels";
        for (Travel item:travels)
        {
            travelsList+=item.toString()+'\n';
        }
        return travelsList;
    }
}
