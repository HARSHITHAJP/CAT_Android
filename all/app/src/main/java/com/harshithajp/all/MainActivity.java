package com.harshithajp.all;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText name,password;
    Button loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.useredittxt);
        password = findViewById(R.id.pwdedittxt);
        loginbutton = findViewById(R.id.loginbutton);
    }

    public void OpenHomePageFunc(View view)
    {
        String yourName = name.getText().toString();
        String yourPwd = password.getText().toString();
        if (!yourName.isEmpty()) {
            if (!yourPwd.isEmpty()) {
                Intent nextintent = new Intent(MainActivity.this, homepage.class);
                nextintent.putExtra("Name", yourName);
                MainActivity.this.startActivity(nextintent);
            }
            else
                Toast.makeText(this, "Password is empty", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Username is empty", Toast.LENGTH_SHORT).show();
    }
}