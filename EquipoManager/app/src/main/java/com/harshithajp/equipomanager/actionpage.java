package com.harshithajp.equipomanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

    public class actionpage extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.actionpage);

            Button btnweb;
            Button btnmsg;
            Button btnemail;
            Button btncall;


            btncall = findViewById(R.id.btncall);
            btnemail = findViewById(R.id.btnemail);
            btnmsg = findViewById(R.id.btnmsg);
            btnweb = findViewById(R.id.btnweb);

            btnweb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String url = "https://www.linkedin.com/in/harshitha-jp-a03277239";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }
            });
        }

        ///////////////////////////////////////////////////////////////////////
        final String emailaddress = "harshithajp633@gmail.com";
        final String subject = "Equipo Manager greetings";
        final String url = "https://www.linkedin.com/in/harshitha-jp-a03277239";
        final String mobileNumber = "9113582917";

        public void openWebFunc(View view) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }

        public void openCallFunc(View view) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + mobileNumber));
            startActivity(intent);
        }

        public void openMsgFunc(View view) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("sms:" + mobileNumber));
            startActivity(intent);
        }

        public void openEmailFunc(View view) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + emailaddress));
            startActivity(intent);
        }
    }
