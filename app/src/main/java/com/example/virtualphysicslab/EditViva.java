package com.example.virtualphysicslab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditViva extends AppCompatActivity {
    EditText title, description, q1, q2, q3, q4 ,q5, q6, q7, q8, q9, q10, op1a, op1b, op1c, op1d, op2a, op2b, op2c, op2d, op3a, op3b, op3c, op3d, op4a, op4b, op4c, op4d, op5a, op5b, op5c, op5d, op6a, op6b, op6c, op6d, op7a, op7b, op7c, op7d, op8a, op8b, op8c, op8d, op9a, op9b, op9c, op9d, op10a, op10b, op10c, op10d;
    Spinner a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_viva);

        title = findViewById(R.id.vivaTitle);
        description = findViewById(R.id.description);
        q1 = findViewById(R.id.question1);
        q2 = findViewById(R.id.question2);
        q3 = findViewById(R.id.question3);
        q4 = findViewById(R.id.question4);
        q5 = findViewById(R.id.question5);
        q6 = findViewById(R.id.question6);
        q7 = findViewById(R.id.question7);
        q8 = findViewById(R.id.question8);
        q9 = findViewById(R.id.question9);
        q10 = findViewById(R.id.question10);
        op1a = findViewById(R.id.option11);
        op1b = findViewById(R.id.option12);
        op1c = findViewById(R.id.option13);
        op1d = findViewById(R.id.option14);
        op2a = findViewById(R.id.option21);
        op2b = findViewById(R.id.option22);
        op2c = findViewById(R.id.option23);
        op2d = findViewById(R.id.option24);
        op3a = findViewById(R.id.option31);
        op3b = findViewById(R.id.option32);
        op3c = findViewById(R.id.option33);
        op3d = findViewById(R.id.option34);
        op4a = findViewById(R.id.option41);
        op4b = findViewById(R.id.option42);
        op4c = findViewById(R.id.option43);
        op4d = findViewById(R.id.option44);
        op5a = findViewById(R.id.option51);
        op5b = findViewById(R.id.option52);
        op5c = findViewById(R.id.option53);
        op5d = findViewById(R.id.option54);
        op6a = findViewById(R.id.option61);
        op6b = findViewById(R.id.option62);
        op6c = findViewById(R.id.option63);
        op6d = findViewById(R.id.option64);
        op7a = findViewById(R.id.option71);
        op7b = findViewById(R.id.option72);
        op7c = findViewById(R.id.option73);
        op7d = findViewById(R.id.option74);
        op8a = findViewById(R.id.option81);
        op8b = findViewById(R.id.option82);
        op8c = findViewById(R.id.option83);
        op8d = findViewById(R.id.option84);
        op9a = findViewById(R.id.option91);
        op9b = findViewById(R.id.option92);
        op9c = findViewById(R.id.option93);
        op9d = findViewById(R.id.option94);
        op10a = findViewById(R.id.option101);
        op10b= findViewById(R.id.option102);
        op10c= findViewById(R.id.option103);
        op10d= findViewById(R.id.option104);
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        a5 = findViewById(R.id.a5);
        a6 = findViewById(R.id.a6);
        a7 = findViewById(R.id.a7);
        a8 = findViewById(R.id.a8);
        a9 = findViewById(R.id.a9);
        a10 = findViewById(R.id.a10);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.solutions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        a1.setAdapter(adapter);
        a2.setAdapter(adapter);
        a3.setAdapter(adapter);
        a4.setAdapter(adapter);
        a5.setAdapter(adapter);
        a6.setAdapter(adapter);
        a7.setAdapter(adapter);
        a8.setAdapter(adapter);
        a9.setAdapter(adapter);
        a10.setAdapter(adapter);
    }


    public void setViva(View view) {
        SharedPreferences mysp = getSharedPreferences("questions",MODE_PRIVATE);
        SharedPreferences.Editor editor = mysp.edit();
        editor.putString("title", title.getText().toString());
        editor.putString("desc",description.getText().toString());
        editor.putString("1",q1.getText().toString());
        editor.putString("2",q2.getText().toString());
        editor.putString("3",q3.getText().toString());
        editor.putString("4",q4.getText().toString());
        editor.putString("5",q5.getText().toString());
        editor.putString("6",q6.getText().toString());
        editor.putString("7",q7.getText().toString());
        editor.putString("8",q8.getText().toString());
        editor.putString("9",q9.getText().toString());
        editor.putString("10",q10.getText().toString());
        editor.putString("1a",op1a.getText().toString());
        editor.putString("1b",op1b.getText().toString());
        editor.putString("1c",op1c.getText().toString());
        editor.putString("1d",op1d.getText().toString());
        editor.putString("2a",op2a.getText().toString());
        editor.putString("2b",op2b.getText().toString());
        editor.putString("2c",op2c.getText().toString());
        editor.putString("2d",op2d.getText().toString());
        editor.putString("3a",op3a.getText().toString());
        editor.putString("3b",op3b.getText().toString());
        editor.putString("3c",op3c.getText().toString());
        editor.putString("3d",op3d.getText().toString());
        editor.putString("4a",op4a.getText().toString());
        editor.putString("4b",op4b.getText().toString());
        editor.putString("4c",op4c.getText().toString());
        editor.putString("4d",op4d.getText().toString());
        editor.putString("5a",op5a.getText().toString());
        editor.putString("5b",op5b.getText().toString());
        editor.putString("5c",op5c.getText().toString());
        editor.putString("5d",op5d.getText().toString());
        editor.putString("6a",op6a.getText().toString());
        editor.putString("6b",op6b.getText().toString());
        editor.putString("6c",op6c.getText().toString());
        editor.putString("6d",op6d.getText().toString());
        editor.putString("7a",op7a.getText().toString());
        editor.putString("7b",op7b.getText().toString());
        editor.putString("7c",op7c.getText().toString());
        editor.putString("7d",op7d.getText().toString());
        editor.putString("8a",op8a.getText().toString());
        editor.putString("8b",op8b.getText().toString());
        editor.putString("8c",op8c.getText().toString());
        editor.putString("8d",op8d.getText().toString());
        editor.putString("9a",op9a.getText().toString());
        editor.putString("9b",op9b.getText().toString());
        editor.putString("9c",op9c.getText().toString());
        editor.putString("9d",op9d.getText().toString());
        editor.putString("10a",op10a.getText().toString());
        editor.putString("10b",op10b.getText().toString());
        editor.putString("10c",op10c.getText().toString());
        editor.putString("10d",op10d.getText().toString());
        editor.putString("a1",a1.getSelectedItem().toString());
        editor.putString("a2",a2.getSelectedItem().toString());
        editor.putString("a3",a3.getSelectedItem().toString());
        editor.putString("a4",a4.getSelectedItem().toString());
        editor.putString("a5",a5.getSelectedItem().toString());
        editor.putString("a6",a6.getSelectedItem().toString());
        editor.putString("a7",a7.getSelectedItem().toString());
        editor.putString("a8",a8.getSelectedItem().toString());
        editor.putString("a9",a9.getSelectedItem().toString());
        editor.putString("a10",a10.getSelectedItem().toString());
        editor.apply();
        Toast.makeText(this,"Viva Questions have updated !!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this,YMViva.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //i.putExtra("exit",true);
        startActivity(i);
    }
}