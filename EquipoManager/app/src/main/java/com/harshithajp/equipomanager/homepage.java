package com.harshithajp.equipomanager;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class homepage extends AppCompatActivity{

    String loggedinName;
    TextView logName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        logName = findViewById(R.id.loggedinID);


        Intent intent = getIntent();
        loggedinName = intent.getStringExtra("Name");
        logName.setText("You are logged in as "+loggedinName);
    }

    public void OpenNextPageFunc(View view)
    {
       Intent nextintent = new Intent(homepage.this, actionpage.class);
        homepage.this.startActivity(nextintent);
    }
}