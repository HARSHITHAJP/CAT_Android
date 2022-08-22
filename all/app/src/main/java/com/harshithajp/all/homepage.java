package com.harshithajp.all;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class homepage extends AppCompatActivity{

    String loggedinName;
    TextView logName;

    EditText name,email,phone;
    RadioGroup radioGroup;
    RadioButton genderradioButton;
    ToggleButton togglebtn;
    ConstraintLayout conslayout;
    CheckBox checkbox;
    AlertDialog.Builder builder;
    Button button;
    String namestr,emailstr,phonestr;

    Button lcbutton;
    private static final String SA = "contact";

    //fab
    FloatingActionButton mAddFab,  mcontactFab;
    TextView addcontactActionText, addFeedbackActionText;
    Boolean isAllFabsVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //---------------------------toast message for onCreate()--------------------------------
        Toast.makeText(this, "onCreate secondactivity", Toast.LENGTH_SHORT).show();
        Log.d(SA, "onCreate secondactivity");



        //this for displaying the name passed
        setContentView(R.layout.activity_homepage);
        logName = findViewById(R.id.logName);
        Intent intent = getIntent();
        loggedinName = intent.getStringExtra("Name");
        logName.setText("You are logged in as "+loggedinName);
        Toast.makeText(this, "hi"+loggedinName, Toast.LENGTH_SHORT).show();


        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        button = findViewById(R.id.submitbtnid);
        togglebtn = findViewById(R.id.togglebtnid);
        checkbox = findViewById(R.id.checkid);
        builder = new AlertDialog.Builder(this);
        name = findViewById((R.id.nameid));
        email = findViewById((R.id.emailid));
        phone = findViewById((R.id.phoneid));


        //fab
        mAddFab = findViewById(R.id.add_fab);
        mcontactFab = findViewById(R.id.contact_fab);


        mcontactFab.setVisibility(View.GONE);
        addcontactActionText.setVisibility(View.GONE);

        isAllFabsVisible = false;

        mAddFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!isAllFabsVisible) {
                            mcontactFab.show();
                            addcontactActionText.setVisibility(View.VISIBLE);
                            isAllFabsVisible = true;

                        } else {

                            mcontactFab.hide();
                            addcontactActionText.setVisibility(View.GONE);
                            isAllFabsVisible = false;
                        }
                    }
                });

        mcontactFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(MainActivity.this, "Person Added", Toast.LENGTH_SHORT).show();
                        // new page go to feedback activity
                        Intent nextintent = new Intent(homepage.this,contact.class);
                        homepage.this.startActivity(nextintent);
                    }
                });



        togglebtn.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        conslayout = findViewById(R.id.qnalayoutID);
                        if(togglebtn.isChecked())
                        {
                            conslayout.setBackgroundResource(R.color.teal_200);
                        }
                        else{
                            conslayout.setBackgroundResource(R.color.white);
                        }

                    }
                }
        );

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        if(!checkbox.isChecked())
                        {
                            builder.setMessage("Please agree that the information is right!");

                            //Creating dialog box
                            AlertDialog alert = builder.create();
                            //Setting the title manually
                            alert.setTitle("Warning - submitting without reading the informaiton");
                            alert.show();
                            return;
                        }

                        namestr = name.getText().toString();
                        emailstr = email.getText().toString();
                        phonestr = phone.getText().toString();

                        if(namestr=="" & emailstr=="" & phonestr=="")
                        {
                            builder.setMessage("Please enter the question and options before submitting");

                            //Creating dialog box
                            AlertDialog alert = builder.create();
                            //Setting the title manually
                            alert.setTitle("Warning - submitting without reading the question");
                            alert.show();
                        }


                        int selectedId = radioGroup.getCheckedRadioButtonId();
                        genderradioButton = (RadioButton) findViewById(selectedId);
                        if(selectedId==-1){
                            Toast.makeText(homepage.this,"Please select one option as answer!", Toast.LENGTH_SHORT).show();
//                    finish();
                        }
                        else{
                            builder.setMessage(namestr+ "\n" +emailstr+ "\n"+phonestr+ "\n"+genderradioButton.getText());
                            AlertDialog alert = builder.create();
                            alert.setTitle("The entered question and options");
                            alert.show();
                            Intent inxtpg = new Intent(homepage.this, contact.class);
                            homepage.this.startActivity(inxtpg);
                        }

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




