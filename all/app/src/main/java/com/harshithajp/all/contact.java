package com.harshithajp.all;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class contact extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button btnweb;
    Button btnmsg;
    Button btnemail;
    Button btncall;

    //feedback
    Button button;
    ConstraintLayout layout;
    RatingBar ratingbar;
    String[] experiencearr = {"  App is Time consuming to understand", "App is easy to understand", "Couldn't understand"};
    String experience = "";
    Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        btncall = findViewById(R.id.btncallid);
        btnemail = findViewById(R.id.btnemailid);
        btnmsg = findViewById(R.id.btnmsgid);
        btnweb = findViewById(R.id.btnlinkedid);

        btnweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String url = "https://www.linkedin.com/in/harshitha-jp-a03277239";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);

            }
        });

        //feedback
        button = findViewById(R.id.submitbuttonid);
        layout = findViewById(R.id.conslayoutid);
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
                    public void onClick(View v) {
                        String str1, str2;
                        if (sw.isChecked())
                            str1 = sw.getTextOn().toString();
                        else
                            str1 = sw.getTextOff().toString();

                        Toast.makeText(contact.this, "hello ratings", Toast.LENGTH_SHORT).show();
                        String exp = experience;
                        // write code to check the rating and display in the snackbar the ratings
                        String rating = String.valueOf(ratingbar.getRating());
                        // Create a snackbar
                        Snackbar snackbar = Snackbar.make(layout, "As per your choice," + str1 + "& Thankyou for rating us " + rating + " stars! and suggesting that the app was " + exp, Snackbar.LENGTH_SHORT);
                        snackbar.show();

                    }
                }
        );
    }

        @Override
        public void onItemSelected (AdapterView < ? > adapterView, View view,int i, long l){
            experience = experiencearr[i];
        }

        @Override
        public void onNothingSelected (AdapterView < ? > adapterView){
            Toast.makeText(this, "nothing selected", Toast.LENGTH_SHORT).show();
        }

    ///////////////////////////////////////////////////////////////////////
    final String emailaddress = "harshithajp633@gmail.com";
    final String subject = "Equipo Manager greetings";
    final String url = "https://www.linkedin.com/in/harshitha-jp-a03277239";
    final String mobileNumber = "9113582917";

    public void openWebFunc(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void openCallFunc(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + mobileNumber));
        startActivity(intent);
    }

    public void openMsgFunc(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("sms:" + mobileNumber));
        startActivity(intent);
    }

    public void openEmailFunc(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + emailaddress));
        startActivity(intent);
    }


}
