package com.harshithajp.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.net.Uri;

import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    ImageView footballimg;
    Button button = (Button)findViewById(R.id.button1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        footballimg = (ImageView) findViewById(R.id.footballimg);

        footballimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(this, "hey there", Toast.LENGTH_LONG);
                Toast.makeText(MainActivity.this, "hey there", Toast.LENGTH_LONG).show();
                Intent i1 = new Intent(getBaseContext(), Football.class);
                startActivity(i1);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(this, "hey there", Toast.LENGTH_LONG);
                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_LONG).show();
                Intent i2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Lionel_Messi"));
                startActivity(i2);
            }
        });
    }
}

