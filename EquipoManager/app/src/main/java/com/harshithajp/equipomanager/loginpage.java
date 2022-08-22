package com.harshithajp.equipomanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class loginpage extends AppCompatActivity {

    EditText name,password;
    Button loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

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
                Intent nextintent = new Intent(loginpage.this, homepage.class);
                nextintent.putExtra("Name", yourName);
                loginpage.this.startActivity(nextintent);
            }
            else
            Toast.makeText(this, "Password is empty", Toast.LENGTH_SHORT).show();
        }
        else
        Toast.makeText(this, "Username is empty", Toast.LENGTH_SHORT).show();
    }
}