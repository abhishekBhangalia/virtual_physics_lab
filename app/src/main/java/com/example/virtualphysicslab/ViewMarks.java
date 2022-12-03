package com.example.virtualphysicslab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewMarks extends AppCompatActivity {
    MyDatabase db;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView recyclerView;
    ArrayList<String> roll, name, sem, course;
    ArrayList<Integer> marks;
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_marks);
        //recyclerView = findViewById(R.id.myRecyclerView);
        tableLayout = findViewById(R.id.tableLayout);

        db = new MyDatabase(this);
        roll = db.getRoll();
        name = db.getStudentName();
        sem = db.getSem();
        course = db.getCourse();
        marks = db.getMarks();
       /* name = db.getStudentName();
        sem = db.getSem();
        course = db.getCourse();
        marks = db.getMarks();*/ 

       /* recyclerViewAdapter = new RecyclerViewAdapter(this,roll, name, sem, course, marks);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));*/

        TableRow tbrow0 = new TableRow(this);
        tbrow0.setBackgroundColor(Color.WHITE);
        TextView tv0 = new TextView(this);
        tv0.setText(" Roll No. ");
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(this);
        tv1.setText(" Name ");
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(this);
        tv2.setText(" Course ");
        tbrow0.addView(tv2);
        TextView tv3 = new TextView(this);
        tv3.setText(" Semester ");
        tbrow0.addView(tv3);
        TextView tv4 = new TextView(this);
        tv4.setText(" Marks ");
        tbrow0.addView(tv4);
        tableLayout.addView(tbrow0);
        for (int i = 0; i < roll.size(); i++) {
            TableRow tbrow = new TableRow(this);
            tbrow.setBackgroundColor(Color.WHITE);
            TextView t1v = new TextView(this);
            t1v.setText("" + roll.get(i));
            t1v.setGravity(Gravity.CENTER);
            tbrow.addView(t1v);
            TextView t2v = new TextView(this);
            t2v.setText("" + name.get(i));
            t2v.setGravity(Gravity.CENTER);
            tbrow.addView(t2v);
            TextView t3v = new TextView(this);
            t3v.setText("" + course.get(i));
            t3v.setGravity(Gravity.CENTER);
            tbrow.addView(t3v);
            TextView t4v = new TextView(this);
            t4v.setText("" + sem.get(i));
            t4v.setGravity(Gravity.CENTER);
            tbrow.addView(t4v);
            TextView t5v = new TextView(this);
            t5v.setText("" + marks.get(i));
            t5v.setGravity(Gravity.CENTER);
            tbrow.addView(t5v);
            tableLayout.addView(tbrow);
        }
    }
}