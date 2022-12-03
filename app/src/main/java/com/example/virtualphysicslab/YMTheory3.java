package com.example.virtualphysicslab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class YMTheory3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_y_m_theory3);
        TextView display = findViewById(R.id.YmThDisplay);
        ImageView diagram = findViewById(R.id.YmDiagram);
        TextView heading = findViewById(R.id.heading);
        String[] arr = getResources().getStringArray(R.array.YMTheory2);
        String[] data = getResources().getStringArray(R.array.YM_Theory);
        String item = getIntent().getStringExtra("item");
        for(int i=0;i<arr.length;i++)
        {
            if(item.equals(arr[i]))
            {
                diagram.setVisibility(ImageView.INVISIBLE);
                heading.setText(arr[i]);
                display.setText(data[i]);
                if(i == 0 || i==4)
                    diagram.setVisibility(ImageView.VISIBLE);
                break;
            }
        }
    }
}