package com.bonniepeng.apollo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeScreen extends AppCompatActivity {

    Button start_animation;
    TextView welcome;
    TextView subheading;
    ImageButton schedule;
    ImageButton symptoms;
    ImageButton logs;
    ImageButton profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        start_animation = findViewById(R.id.start_animation);
        welcome = findViewById(R.id.welcome);
        subheading = findViewById(R.id.subheading);
        schedule = findViewById(R.id.schedule_button);
        symptoms = findViewById(R.id.symptoms_button);
        logs = findViewById(R.id.logs_button);
        profile = findViewById(R.id.profile_button);
        startAnimation();


        schedule.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
        symptoms.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, RecordActivity.class);
                startActivity(intent);
            }
        });
        logs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    private void startAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        welcome.startAnimation(animation);

        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.anim2);
        subheading.startAnimation(animation2);
    }
}

