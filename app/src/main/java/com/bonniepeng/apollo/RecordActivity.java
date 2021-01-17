package com.bonniepeng.apollo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import pl.droidsonroids.gif.GifImageView;


public class RecordActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);


        Button startRecord = findViewById(R.id.btnRecord);
        Button cantTalk = findViewById(R.id.btnCantTalk);
        GifImageView logo = findViewById(R.id.logo);
        GifImageView microphone = findViewById(R.id.microphone);
        startRecord.setText("start recording");
        final boolean[] isRecording = {false};


        cantTalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecordActivity.this, AddText.class);
                startActivity(intent);
            }
        });

        startRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRecording[0]) {
                    startRecord.setText("stop recording");
                    logo.setVisibility(View.INVISIBLE);
                    microphone.setVisibility(View.VISIBLE);

                    isRecording[0] = true;
                } else {
                    // stop recording
                    startRecord.setText("start recording");
                    isRecording[0] = false;
                    logo.setVisibility(View.VISIBLE);
                    microphone.setVisibility(View.INVISIBLE);
                    Snackbar.make(v, "Recording Success", BaseTransientBottomBar.LENGTH_SHORT)
                            .setAction("Go to Logs", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(RecordActivity.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            })
                            .show();
                }
            }
        });
    }


}