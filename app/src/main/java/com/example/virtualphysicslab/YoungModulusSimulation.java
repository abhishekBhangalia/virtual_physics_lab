package com.example.virtualphysicslab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.text.Editable;
import android.text.TextWatcher;
import android.view.DragEvent;

import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class YoungModulusSimulation extends AppCompatActivity {

    ImageView diagram,steelWire,copperWire,goldWire,tinWire,sapphireWire,ironWire,weight2 ;
    TextView display,result,extension,showMaterial;
    EditText weight,length,radius;
    Button b;
    Spinner material;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youngs_modulus_simulation);


        diagram = findViewById(R.id.diagram_sim);
        display = findViewById(R.id.showWeight);


        weight = findViewById(R.id.weight);
        length = findViewById(R.id.length);
        radius = findViewById(R.id.radius);
        result = findViewById(R.id.result);
        extension = findViewById(R.id.extension);
        showMaterial = findViewById(R.id.showMaterial);

        b = findViewById(R.id.button6);
        steelWire = findViewById(R.id.steelWire);
        copperWire = findViewById(R.id.copperWire);
        goldWire = findViewById(R.id.goldWire);
        tinWire = findViewById(R.id.tinWire);
        sapphireWire = findViewById(R.id.sapphireWire);
        ironWire = findViewById(R.id.ironWire);
        weight2 = findViewById(R.id.dweight);
        material = findViewById(R.id.material);

        class ChoiceDragListener implements View.OnDragListener {

            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()) {
                    case DragEvent.ACTION_DROP: {
                        ImageView view = (ImageView) event.getLocalState();
                        if (((ImageView) view) == steelWire) {
                            showMaterial.setText("Steel Wire");
                            material.setSelection(0);
                        } else if (((ImageView) view) == copperWire) {
                            showMaterial.setText("Copper Wire");
                            material.setSelection(1);
                        } else if (((ImageView) view) == tinWire) {
                            showMaterial.setText("Tin Wire");
                            material.setSelection(11);
                        } else if (((ImageView) view) == goldWire) {
                            showMaterial.setText("Gold Wire");
                            material.setSelection(3);
                        } else if (((ImageView) view) == sapphireWire) {
                            showMaterial.setText("Sapphire Wire");
                            material.setSelection(10);
                        } else if (((ImageView) view) == ironWire) {
                            showMaterial.setText("Iron Wire");
                            material.setSelection(4);
                        } else if (((ImageView) view) == weight2) {
                            if (weight.getText().toString().equals(""))
                                weight.setText("0");
                            String s = String.valueOf((Integer.parseInt(weight.getText().toString())) + 1);
                            weight.setText(s);
                        }
                        break;
                    }
                }
                return true;
            }
        }

        steelWire.setOnTouchListener(new ChoiceTouchListener());
        copperWire.setOnTouchListener(new ChoiceTouchListener());
        sapphireWire.setOnTouchListener(new ChoiceTouchListener());
        ironWire.setOnTouchListener(new ChoiceTouchListener());
        tinWire.setOnTouchListener(new ChoiceTouchListener());
        goldWire.setOnTouchListener(new ChoiceTouchListener());
        weight2.setOnTouchListener(new ChoiceTouchListener());

        diagram.setOnDragListener(new ChoiceDragListener());

        TextWatcher myTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                checkForEmptyValues();
                if (weight.getText().toString().equals(""))
                    diagram.setImageResource(R.drawable.s5);
                else if (0 < Integer.parseInt(weight.getText().toString()) && Integer.parseInt(weight.getText().toString()) <= 1)
                    diagram.setImageResource(R.drawable.s6);
                else if (1 < Integer.parseInt(weight.getText().toString()) && Integer.parseInt(weight.getText().toString()) <= 2)
                    diagram.setImageResource(R.drawable.a1);
                else if (2 < Integer.parseInt(weight.getText().toString()))
                    diagram.setImageResource(R.drawable.a2);

                String kg = weight.getText().toString() + "Kg";
                display.setText(kg);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkForEmptyValues();
                if (weight.getText().toString().equals(""))
                    diagram.setImageResource(R.drawable.s5);
                else if (0 < Integer.parseInt(weight.getText().toString()) && Integer.parseInt(weight.getText().toString()) <= 1)
                    diagram.setImageResource(R.drawable.s6);
                else if (1 < Integer.parseInt(weight.getText().toString()) && Integer.parseInt(weight.getText().toString()) <= 2)
                    diagram.setImageResource(R.drawable.a1);
                else if (2 < Integer.parseInt(weight.getText().toString()))
                    diagram.setImageResource(R.drawable.a2);
                String kg = weight.getText().toString() + "Kg";
                display.setText(kg);
            }

            @Override
            public void afterTextChanged(Editable s) {

                checkForEmptyValues();
                if (weight.getText().toString().equals(""))
                    diagram.setImageResource(R.drawable.s5);
                else if (0 < Integer.parseInt(weight.getText().toString()) && Integer.parseInt(weight.getText().toString()) <= 1)
                    diagram.setImageResource(R.drawable.s6);
                else if (1 < Integer.parseInt(weight.getText().toString()) && Integer.parseInt(weight.getText().toString()) <= 2)
                    diagram.setImageResource(R.drawable.a1);
                else if (2 < Integer.parseInt(weight.getText().toString()))
                    diagram.setImageResource(R.drawable.a2);
                String kg = weight.getText().toString() + "Kg";
                display.setText(kg);
            }
        };


        weight.addTextChangedListener(myTextWatcher);
        length.addTextChangedListener(myTextWatcher);
        radius.addTextChangedListener(myTextWatcher);

        final double[] Y = new double[1];
        final String[] res = new String[1];

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.materials, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        material.setAdapter(adapter);
        material.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Y[0] = 1.9 * (10 ^ 11);
                    res[0] = "1.9 X 10¹¹ N/m²";
                    showMaterial.setText("Steel Wire");
                } else if (position == 1) {
                    Y[0] = 1.17 * (10 ^ 11);
                    res[0] = "1.17 X 10¹¹ N/m²";
                    showMaterial.setText("Copper Wire");

                } else if (position == 2) {
                    Y[0] = 0.69 * (10 ^ 11);
                    res[0] = "0.69 X 10¹¹ N/m²";
                    showMaterial.setText("Aluminium Wire");
                } else if (position == 3) {
                    Y[0] = 0.74 * (10 ^ 11);
                    res[0] = "0.74 X 10¹¹ N/m²";
                    showMaterial.setText("Gold Wire");
                } else if (position == 4) {
                    Y[0] = 2.1 * (10 ^ 11);
                    res[0] = "2.1 X 10¹¹ N/m²";
                    showMaterial.setText("Iron Wire");
                } else if (position == 5) {
                    Y[0] = 0.45 * (10 ^ 11);
                    res[0] = "0.45 X 10¹¹ N/m²";
                    showMaterial.setText("Magnesium Wire");
                } else if (position == 6) {
                    Y[0] = 4 * (10 ^ 11);
                    res[0] = "4 X 10¹¹ N/m²";
                    showMaterial.setText("Tungsten Wire");
                } else if (position == 7) {
                    Y[0] = 1.7 * (10 ^ 11);
                    res[0] = "1.7 X 10¹¹ N/m²";
                    showMaterial.setText("Uranium Wire");
                } else if (position == 8) {
                    Y[0] = 2.87 * (10 ^ 11);
                    res[0] = "2.87 X 10¹¹ N/m²";
                    showMaterial.setText("Beryllium Wire");
                } else if (position == 9) {
                    Y[0] = 1.7 * (10 ^ 11);
                    res[0] = "1.7 X 10¹¹ N/m²";
                    showMaterial.setText("Nickel Wire");
                } else if (position == 10) {
                    Y[0] = 4.35 * (10 ^ 11);
                    res[0] = "4.35 X 10¹¹ N/m²";
                    showMaterial.setText("Sapphire Wire");
                } else if (position == 11) {
                    Y[0] = 0.47 * (10 ^ 11);
                    res[0] = "0.47 X 10¹¹ N/m²";
                    showMaterial.setText("Tin Wire");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int w = Integer.parseInt(weight.getText().toString());
                double l = Double.parseDouble(length.getText().toString());
                double r = Double.parseDouble(radius.getText().toString());
                double ext = (w * 9.8 * l) / (3.14 * (r * r) * Y[0]);
                extension.setText(Double.toString(ext) + " m");
                result.setText(res[0]);
            }
        });
    }
    private void checkForEmptyValues () {

        String s1 = weight.getText().toString();
        String s2 = length.getText().toString();
        String s3 = radius.getText().toString();

        if (s1.equals("") || s2.equals("") || s3.equals(""))
            b.setEnabled(false);
        else
            b.setEnabled(true);
        }
}