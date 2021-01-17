package com.bonniepeng.apollo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LogView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_view);

        TextView date = findViewById(R.id.logDate);
        TextView urgentSymptoms = findViewById(R.id.logUrgent);
        Button back = findViewById(R.id.logBack);

        String logDate = getIntent().getStringExtra("date");
        String logUrgent = getIntent().getStringExtra("keywords");

        date.setText(logDate);
        urgentSymptoms.setText(logUrgent);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}