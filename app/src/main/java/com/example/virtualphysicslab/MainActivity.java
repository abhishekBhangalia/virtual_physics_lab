package com.example.virtualphysicslab;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openElasticity(View view) {
        Intent i = new Intent(this, Elasticity.class);
        startActivity(i);
    }

    public void openOptics(View view){
        Intent i = new Intent(this, Optics.class);
        startActivity(i);
    }

    public void openElectronics(View view){
        Intent i = new Intent(this, Electronics.class);
        startActivity(i);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(getIntent().getBooleanExtra("exit",false))
            finish();
    }
}