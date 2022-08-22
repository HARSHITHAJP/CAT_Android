package com.harshithajp.a2147250_lab2_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view) {
// Displaying the toast message
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        view = toast.getView();
        TextView text = view.findViewById(android.R.id.message);
        text.setTextSize(30);
        text.setTextColor(Color.GREEN);
        toast.setGravity(Gravity.TOP, 0, 0);
        view.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        toast.show();

    }
}
