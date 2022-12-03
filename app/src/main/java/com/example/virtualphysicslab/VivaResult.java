package com.example.virtualphysicslab;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class VivaResult extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viva_result);
        TextView name,roll,semester,course;
        name = findViewById(R.id.rName);
        roll = findViewById(R.id.rRollno);
        semester = findViewById(R.id.rSemester);
        course = findViewById(R.id.rCourse);

        name.append(YMViva.getName());  
        roll.append(YMViva.getRollno());
        semester.append(YMViva.getSemester());
        course.append(YMViva.getCourse());
         int marks = getIntent().getIntExtra("marks",0);
        TextView res = findViewById(R.id.viva_result);
        res.setText(Integer.toString(marks));
    }

    public void startSolution(View view)
    {
        Intent i = new Intent(this, Viva.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        Intent i = new Intent(this,MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.putExtra("exit",true);
        startActivity(i);
    }
}