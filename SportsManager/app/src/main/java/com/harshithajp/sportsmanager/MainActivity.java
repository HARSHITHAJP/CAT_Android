package com.harshithajp.sportsmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(this, "hey there", Toast.LENGTH_LONG);
                Toast.makeText(MainActivity.this, "hey there", Toast.LENGTH_LONG).show();
                Intent ii = new Intent(getBaseContext(), About_sports_manager.class);
                startActivity(ii);
            }
        });

    }

    public void showToast(View view) {
//        Displaying the toast message
        Toast toast = Toast.makeText(this, R.string.toast_message ,Toast.LENGTH_SHORT);
        view = toast.getView();
        TextView text = view.findViewById(android.R.id.message);
        text.setTextSize(30);
        text.setTextColor(Color.RED);
        toast.setGravity(Gravity.TOP, 0, 0);
        view.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
        toast.show();

        setContentView(R.layout.activity_about_sports_manager);
//        Displaying the login page
//        setContentView(R.layout.login_page);
    }
}