package com.harshithajp.lab6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class QuestionActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    Button button;
    RadioButton answerradioButton;
    ToggleButton togglebtn;
    ConstraintLayout conslayout;
    CheckBox checkbox;
    AlertDialog.Builder builder;
    EditText question, op1, op2, op3;
    String ques = "";
    String opt1="", opt2 ="", opt3 ="";

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
        question = findViewById((R.id.textQuestionID));
        op1 = findViewById((R.id.option1ID));
        op2 = findViewById((R.id.option1ID2));
        op3 = findViewById((R.id.option1ID3));



        togglebtn.setOnClickListener(
            new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    conslayout = findViewById(R.id.qnalayoutID);
                    if(togglebtn.isChecked())
                    {
                        conslayout.setBackgroundResource(R.color.purple_200);
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
                    builder.setMessage("Please agree that the question is right!");

                    //Creating dialog box
                    AlertDialog alert = builder.create();
                    //Setting the title manually
                    alert.setTitle("Warning - submitting without reading the question");
                    alert.show();
                    return;
                }

                ques = question.getText().toString();
                opt1 = op1.getText().toString();
                opt2 = op2.getText().toString();
                opt3 = op3.getText().toString();

                if(ques=="" & opt1=="" & opt2=="" & opt3=="" )
                {
                    builder.setMessage("Please enter the question and options before submitting");

                    //Creating dialog box
                    AlertDialog alert = builder.create();
                    //Setting the title manually
                    alert.setTitle("Warning - submitting without reading the question");
                    alert.show();
                }


                int selectedId = radioGroup.getCheckedRadioButtonId();
                answerradioButton = (RadioButton) findViewById(selectedId);
                if(selectedId==-1){
                    Toast.makeText(QuestionActivity.this,"Please select one option as answer!", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    builder.setMessage(ques+" \n"+opt1+" \n"+opt2+" \n"+opt3+" \n"+answerradioButton.getText());
                    AlertDialog alert = builder.create();
                    alert.setTitle("The entered question and options");
                    alert.show();
                }


            }
        });

    }
}