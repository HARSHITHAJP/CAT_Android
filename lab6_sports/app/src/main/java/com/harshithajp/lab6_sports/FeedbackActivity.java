package com.harshithajp.lab6_sports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;

import com.google.android.material.snackbar.Snackbar;

public class FeedbackActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

        Button button;
        ConstraintLayout layout;
        RatingBar ratingbar;
        String[] experiencearr = { "  App is Time consuming to understand", "App is easy to understand", "Couldn't understand"};
        String experience = "";
        Switch sw ;


        @Override
        protected void onCreate(Bundle savedInstanceState){
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_feedback);

                button = findViewById(R.id.button);
                layout = findViewById(R.id.layout1);
                ratingbar = findViewById(R.id.ratingBar);
                sw = (Switch) findViewById(R.id.switch1);


                Spinner spino = findViewById(R.id.spinner);
                spino.setOnItemSelectedListener(this);
                ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, experiencearr);
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spino.setAdapter(ad);

                button.setOnClickListener(
                        new View.OnClickListener() {
                                @Override
                                public void onClick(View v)
                                {
                                        String str1, str2;
                                        if (sw.isChecked())
                                                str1 = sw.getTextOn().toString();
                                        else
                                                str1 = sw.getTextOff().toString();

                                        String exp = experience;
                                        // write code to check the rating and display in the snackbar the ratings
                                        String rating=String.valueOf(ratingbar.getRating());
                                        // Create a snackbar
                                        Snackbar snackbar2 = Snackbar.make(layout, "As per your choice,"+str1, Snackbar.LENGTH_LONG);
                                        Snackbar snackbar = Snackbar.make(layout, "As per your choice,"+str1+"& Thankyou for rating us "+rating+" stars! and suggesting that the app was "+exp, Snackbar.LENGTH_SHORT);

                                        snackbar.show();

                                }
                        });
        }

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                experience = experiencearr[i];
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
}