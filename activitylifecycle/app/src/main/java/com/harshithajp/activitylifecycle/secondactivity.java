package com.harshithajp.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

public class secondactivity extends AppCompatActivity {

    Button button;
    private static final String SA = "secondactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);

        //---------------------------toast message for onCreate()--------------------------------
        Toast.makeText(this, "onCreate secondactivity", Toast.LENGTH_SHORT).show();
        Log.d(SA, "onCreate secondactivity");


        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(secondactivity.this, thirdactivity.class);
                startActivity(ii);
            }
        });
    }

    //---------------------------toast message for onStart()--------------------------------
    @Override
    protected void onStart() {

        Toast.makeText(this, "onStart secondactivity", Toast.LENGTH_SHORT).show();
        Log.d(SA, "onStart secondactivity");

        super.onStart();
    }


    //---------------------------toast message for onPause()--------------------------------
    @Override
    protected void onPause() {

        Toast.makeText(this, "onPause secondactivity", Toast.LENGTH_SHORT).show();
        Log.d(SA, "onPause secondactivity");

        super.onPause();
    }

    //---------------------------toast message for onResume()--------------------------------
    @Override
    protected void onResume() {


        Toast.makeText(this, "onResume secondactivity", Toast.LENGTH_SHORT).show();
        Log.d(SA, "onResume secondactivity");

        super.onResume();
    }


    //---------------------------toast message for onStop()--------------------------------
    @Override
    protected void onStop() {

        Toast.makeText(this, "onStop secondactivity", Toast.LENGTH_SHORT).show();
        Log.d(SA, "onStop secondactivity");

        super.onStop();
    }






    //---------------------------toast message for onRestart()--------------------------------
    @Override
    protected void onRestart() {

        Toast.makeText(this, "onRestart secondactivity", Toast.LENGTH_SHORT).show();
        Log.d(SA, "onRestart secondactivity");

        super.onRestart();
    }


    //---------------------------toast message for onDestroy()--------------------------------
    @Override
    protected void onDestroy() {

        Toast.makeText(this, "onDestroy secondactivity", Toast.LENGTH_SHORT).show();
        Log.d(SA, "onDestroy secondactivity");

        super.onDestroy();
    }
}