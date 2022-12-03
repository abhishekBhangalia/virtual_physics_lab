package com.example.virtualphysicslab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context ctx;
    ArrayList<String> roll, name, sem, course;
    ArrayList<Integer> marks;

    public RecyclerViewAdapter(Context context, ArrayList<String> roll, ArrayList<String> name, ArrayList<String> sem, ArrayList<String> course, ArrayList<Integer> marks)
    {
        ctx = context;
        this.roll = roll;
        this.name = name;
        this.sem = sem;
        this.course = course;
        this.marks = marks;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctx);
        View view = layoutInflater.inflate(R.layout.marks_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.Roll.setText(roll.get(position));
        holder.Name.setText(name.get(position));
        holder.Sem.setText(sem.get(position));
        holder.Course.setText(course.get(position));
        holder.Marks.setText(String.valueOf(marks.get(position)));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Roll, Name, Sem, Course;
        EditText Marks;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Roll = itemView.findViewById(R.id.textView_roll);
            Name = itemView.findViewById(R.id.textView_name);
            Sem = itemView.findViewById(R.id.textView_sem);
            Course = itemView.findViewById(R.id.textView_course);
            Marks = itemView.findViewById(R.id.textView_marks);
        }
    }

}
