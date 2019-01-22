package com.example.morganeankonina.android5779_3884_9325_5513.control;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.morganeankonina.android5779_3884_9325_5513.R;

/**
 * Class MainActivity starts the application
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);//no title for main_activity
        setContentView(R.layout.activity_main);

        /**
         * Operations on button that transfer to add travel
         */
        FloatingActionButton fabGoTo = (FloatingActionButton) findViewById(R.id.GoTofab);
        fabGoTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goTo = new Intent(MainActivity.this,GoTo.class);
                startActivity(goTo);
                Snackbar.make(view, "Your navigation", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /**
         * Operations on button that ask to activate the GPS
         */
        FloatingActionButton fabGPS = (FloatingActionButton) findViewById(R.id.GPSfab);
        fabGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Please, activate your location", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}

