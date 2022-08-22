package com.harshithajp.lab6_sports;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton mAddFab, mEquipmentFab, mFeedbackFab;

    TextView addEquipmentActionText, addFeedbackActionText;

    Boolean isAllFabsVisible;

    private WebView wv1;
    Button b1;
    EditText ed1;

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAddFab = findViewById(R.id.add_fab);
        mEquipmentFab = findViewById(R.id.equipment_fab);
        mFeedbackFab = findViewById(R.id.add_feedback_fab);

        addEquipmentActionText = findViewById(R.id.add_equipment_action_textview);
        addFeedbackActionText = findViewById(R.id.add_feedback_action_textview);

        mEquipmentFab.setVisibility(View.GONE);
        mFeedbackFab.setVisibility(View.GONE);
        addEquipmentActionText.setVisibility(View.GONE);
        addFeedbackActionText.setVisibility(View.GONE);


        isAllFabsVisible = false;

        mAddFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!isAllFabsVisible) {
                            mEquipmentFab.show();
                            mFeedbackFab.show();
                            addEquipmentActionText.setVisibility(View.VISIBLE);
                            addFeedbackActionText.setVisibility(View.VISIBLE);
                            isAllFabsVisible = true;

                        } else {

                            mEquipmentFab.hide();
                            mFeedbackFab.hide();
                            addEquipmentActionText.setVisibility(View.GONE);
                            addFeedbackActionText.setVisibility(View.GONE);
                            isAllFabsVisible = false;
                        }
                    }
                });

        mFeedbackFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(MainActivity.this, "Person Added", Toast.LENGTH_SHORT).show();
                        // new page go to feedback activity
                        Intent nextintent = new Intent(MainActivity.this, FeedbackActivity.class);
                        MainActivity.this.startActivity(nextintent);
                    }
                });

        mEquipmentFab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(MainActivity.this, "Alarm Added", Toast.LENGTH_SHORT).show();
                        // new page go to question activity
                        Intent nextintent = new Intent(MainActivity.this, QuestionActivity.class);
                        MainActivity.this.startActivity(nextintent);
                    }
                });

        /// -------------------- Web View code ------------------------------
        b1=(Button)findViewById(R.id.searchBtnID);
        ed1=(EditText)findViewById(R.id.searchtextID);

        wv1=(WebView)findViewById(R.id.webView);
        wv1.setWebViewClient(new MyBrowser());


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = ed1.getText().toString();

                wv1.getSettings().setLoadsImagesAutomatically(true);
                wv1.getSettings().setJavaScriptEnabled(true);
                wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                wv1.loadUrl("https://"+url);
            }
        });
    }
}