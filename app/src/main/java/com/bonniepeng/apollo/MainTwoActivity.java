package com.bonniepeng.apollo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainTwoActivity extends AppCompatActivity {

    pl.droidsonroids.gif.GifImageButton btn;
    TextView welcome;
    TextView subheading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_main_two);


        btn = findViewById(R.id.gifImageView);
        welcome = findViewById(R.id.welcome);
        subheading = findViewById(R.id.subheading);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainTwoActivity.this, HomeScreen.class);
                startActivity(intent);
                //startAnimation();
            }
        });
    }
}