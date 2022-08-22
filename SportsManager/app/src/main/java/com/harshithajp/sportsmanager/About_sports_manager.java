package com.harshithajp.sportsmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class About_sports_manager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_sports_manager);
    }

    public void showSportsInfo(View view) {
        setContentView(R.layout.activity_sports_info);
        Toast.makeText(this, "Check out all the sports equipments!", Toast.LENGTH_SHORT).show();

    }
}