package com.bonniepeng.apollo;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class AddText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_text);

        TextView q1 = findViewById(R.id.q1);
        TextView q2 = findViewById(R.id.q2);
        TextView q3 = findViewById(R.id.q3);
        EditText ans1 = findViewById(R.id.ans1);
        EditText ans2 = findViewById(R.id.ans2);
        EditText ans3 = findViewById(R.id.ans3);
        Button cancel = findViewById(R.id.cancel);
        Button done = findViewById(R.id.done);

        ans2.setVisibility(View.INVISIBLE);
        ans3.setVisibility(View.INVISIBLE);
        q3.setVisibility(View.INVISIBLE);
        q2.setVisibility(View.INVISIBLE);

        ans1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ans2.setVisibility(View.VISIBLE);
                        q2.setVisibility(View.VISIBLE);
                    }
                }, 9000);


            }
        });

        ans2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ans3.setVisibility(View.VISIBLE);
                        q3.setVisibility(View.VISIBLE);
                    }
                }, 10000);

            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Added to Logs", BaseTransientBottomBar.LENGTH_SHORT).show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 1000);

            }
        });

    }
}