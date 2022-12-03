package com.example.virtualphysicslab;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Elasticity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elasticity);
    }

    public void openYMExp(View view) {
        Intent i = new Intent(this,YoungsModulus.class);
        startActivity(i);
    }
}