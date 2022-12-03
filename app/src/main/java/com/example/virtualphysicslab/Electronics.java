package com.example.virtualphysicslab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Electronics extends AppCompatActivity {
    Button ohms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics);

        ohms = findViewById(R.id.ohmsButton);
        ohms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Electronics.this, OhmsLawSimulation2.class);
                startActivity(i);
            }
        });
    }
}