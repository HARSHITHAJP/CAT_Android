package com.harshithajp.lab6_sports;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class QuestionActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    Button button;
    RadioButton typeradioButton;
    ToggleButton togglebtn;
    ConstraintLayout conslayout;
    CheckBox checkbox;
    AlertDialog.Builder builder;
    EditText qeqname, qsportsname, qquantity, qmaterial;
    String eq = "";
    String sports="", qty ="", material="";

    public QuestionActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        button = findViewById(R.id.button2);
        togglebtn = findViewById(R.id.toggleButton);
        checkbox = findViewById(R.id.checkBox);
        builder = new AlertDialog.Builder(this);
        qeqname = findViewById((R.id.eqname));
        qsportsname = findViewById((R.id.sportsname));
        qquantity = findViewById((R.id.qquantity));
        qmaterial = findViewById((R.id.qmaterial));



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

                        eq = qeqname.getText().toString();
                        sports = qsportsname.getText().toString();
                        qty = qquantity.getText().toString();
                        material = qmaterial.getText().toString();

                        if(eq=="" & sports=="" & qty=="" & material=="" )
                        {
                            builder.setMessage("Please enter the question and options before submitting");

                            //Creating dialog box
                            AlertDialog alert = builder.create();
                            //Setting the title manually
                            alert.setTitle("Warning - submitting without reading the question");
                            alert.show();
                        }


                        int selectedId = radioGroup.getCheckedRadioButtonId();
                        typeradioButton = (RadioButton) findViewById(selectedId);
                        if(selectedId==-1){
                            Toast.makeText(QuestionActivity.this,"Please select one option as answer!", Toast.LENGTH_SHORT).show();
//                    finish();
                        }
                        else{
                            builder.setMessage(eq+" \n"+sports+" \n"+qty+" \n"+material+" \n"+typeradioButton.getText());
                            AlertDialog alert = builder.create();
                            alert.setTitle("The entered question and options");
                            alert.show();

                        }
                    }
                });

    }
}