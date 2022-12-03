package com.example.virtualphysicslab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class OhmsLawSimulation2 extends AppCompatActivity {
    TextView ammeter, voltmeter, resistor,bpos,bneg,rpos,rneg,apos,aneg,vpos,vneg;
    EditText volts,resistance;
    Button reset, showResult;
    Switch switch_ohms;
    boolean f=false;
    TextView current;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ohms_law_sim2);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            View myView = getWindow().getDecorView();
            myView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|
                            View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }

        ammeter = findViewById(R.id.ammeter);
        voltmeter = findViewById(R.id.voltmeter);
        resistor = findViewById(R.id.resistor);
        apos = findViewById(R.id.apos);
        aneg = findViewById(R.id.aneg);
        vpos = findViewById(R.id.vpos);
        vneg = findViewById(R.id.vneg);
        rpos = findViewById(R.id.rpos);
        rneg = findViewById(R.id.rneg);
        bpos = findViewById(R.id.bpos);
        bneg = findViewById(R.id.bneg);

        reset = findViewById(R.id.reset_ohms);
        showResult = findViewById(R.id.showResult_ohms);
        switch_ohms = findViewById(R.id.ohms_switch);
        volts = findViewById(R.id.volts_ohms);
        resistance = findViewById(R.id.resistance_ohms);
        current = findViewById(R.id.current_ohms);
        showResult.setEnabled(false);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volts.setText("");
                current.setText("");
                resistance.setText("");
            }
        });

        showResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int vol = Integer.parseInt(volts.getText().toString());
                int res = Integer.parseInt(resistance.getText().toString());
                double i = vol/res;
                current.setText(""+i+" A");
            }
        });
        TextWatcher myTextWatcher1 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ammeter.setText("Ammeter\n"+current.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        TextWatcher myTextWatcher2 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                voltmeter.setText("Voltmeter\n"+volts.getText().toString()+" V");
                check();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        TextWatcher myTextWatcher3 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                resistor.setText("Resistor\n"+resistance.getText().toString()+" Ω");
                check();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        current.addTextChangedListener(myTextWatcher1);
        volts.addTextChangedListener(myTextWatcher2);
        resistance.addTextChangedListener(myTextWatcher3);

        switch_ohms.setOnCheckedChangeListener(myListener);
    }

    private void check() {
        if(!(resistance.getText().toString().equals("")) && !(volts.getText().toString().equals("")) )
            f=true;
        else f = false;
    }

    CompoundButton.OnCheckedChangeListener myListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(f && isChecked)
                showResult.setEnabled(true);
            else showResult.setEnabled(false);
        }
    };
}