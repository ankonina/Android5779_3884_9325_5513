package com.example.morganeankonina.android5779_3884_9325_5513.control;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;

import com.example.morganeankonina.android5779_3884_9325_5513.R;
import com.example.morganeankonina.android5779_3884_9325_5513.entities.Travel;
import com.example.morganeankonina.android5779_3884_9325_5513.model.backend.Backend;
import com.example.morganeankonina.android5779_3884_9325_5513.model.backend.BackendFactory;
import com.example.morganeankonina.android5779_3884_9325_5513.model.datasource.DataBaseList;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Class GoTo adds travel
 */
public class GoTo extends AppCompatActivity {

    /**
     * The function emailValid checks if the email is valid
     * @param email
     * @return boolean
     */
    public static boolean emailValid(String email)
    {
        if( email!=null && email.trim().length()>0 )
            return email.matches("^[a-zA-Z0-9\\.\\-\\_]+@([a-zA-Z0-9\\-\\_\\.]+\\.)+([a-zA-Z]{2,4})$");
        return false;
    }

    /**
     * The function phoneValid checks if the phone is valid
     * @param phone
     * @return boolean
     */
    public static boolean phoneValid(String phone)
    {
        if(phone.length()!=10 || phone.charAt(0)!='0' || phone.charAt(1)!='5')
            return false;
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_to);
        Button ok = (Button) findViewById(R.id.okButton);

        /**
         * When user click on bouton ok the user enters all information and the function adds them to DB
         */
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    BackendFactory backendFactory = new BackendFactory();
                    final Backend backend = backendFactory.getInstance();
                    //final DataBaseList dataList=new DataBaseList();



                    /**
                     * Get all information from view
                     */
                    AutoCompleteTextView startText = (AutoCompleteTextView) findViewById(R.id.startAutoComplete);
                    final String start = startText.getText().toString();
                    AutoCompleteTextView destText = (AutoCompleteTextView) findViewById(R.id.destAutoComplete);
                    final String dest = destText.getText().toString();
                    AutoCompleteTextView nameText = (AutoCompleteTextView) findViewById(R.id.detailsNameAutoComplete);
                    final String name = nameText.getText().toString();
                    AutoCompleteTextView emailText = (AutoCompleteTextView) findViewById(R.id.detailsEmailAutoComplete);
                    final String email = emailText.getText().toString();
                    AutoCompleteTextView phoneText = (AutoCompleteTextView) findViewById(R.id.detailsPhoneAutoComplete);
                    final String phoneT = phoneText.getText().toString();
                    //inal int phone = Integer.valueOf(phoneT);

                    /**
                     * Conditions for a validation of the data
                     */
                    if (start.length() < 1)
                        throw new Exception("Please enter your start point!");

                    if (dest.length() < 1)
                        throw new Exception("Please enter your destination!");

                    if (name.length() < 1)
                        throw new Exception("Please enter your name!");

                    if (email.length() < 1)
                        throw new Exception("Please enter your email!");
                    if (emailValid(email)==false)
                        throw new Exception("Your email is not valid. Please enter again!");
                    if(phoneValid(phoneT)==false)
                        throw new Exception(("Your phone is not valid. Please enter again!"));

                    /**
                    Create the travel and add to DB
                     */
                    //Travel travel = new Travel(Travel.States.FREE, start, dest, new Time(0, 0, 0), new Time(0, 0, 0), name, phone, email);
                    //backend.addTravel(travel);

                    new AsyncTask<Context, Void, Void>(){
                        @Override
                        protected Void doInBackground (Context... contexts)
                        {
                            try
                            {
                                Travel travel = new Travel(Travel.States.FREE, start, dest, new Time(0, 0, 0), new Time(0, 0, 0), name, phoneT, email);
                                backend.addTravel(travel);

                                //String list=dataList.getTravel();
                                //Toast toast = Toast.makeText(getApplicationContext(),list, Toast.LENGTH_LONG);
                                //toast.show();

                                return null;
                            }
                            catch(Exception e)
                            {
                                Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
                                toast.show();
                            }
                            return null;
                        }
                    }.execute();

                    Toast toast = Toast.makeText(getApplicationContext(), "Your travel added successfully!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                catch (Exception e) {
                    Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
                    toast.show();
                    e.printStackTrace();
                }
            }
        });
    }
}
