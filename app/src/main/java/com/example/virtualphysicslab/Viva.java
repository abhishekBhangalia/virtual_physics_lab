package com.example.virtualphysicslab;
 
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Viva extends AppCompatActivity {
    RadioGroup q1,q2,q3,q4,q5,q6,q7,q8,q9,q10;
    String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;
    RadioButton s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
    RadioButton op1a, op1b, op1c, op1d, op2a, op2b, op2c, op2d, op3a, op3b, op3c, op3d, op4a, op4b, op4c, op4d, op5a, op5b, op5c, op5d, op6a, op6b, op6c, op6d, op7a, op7b, op7c, op7d, op8a, op8b, op8c, op8d, op9a, op9b, op9c, op9d, op10a, op10b, op10c, op10d;

    TextView Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10;
    int n = VivaQuestions.getTotalQues();
    int total_ques=0, atmp=0, marks=0;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viva);
        SharedPreferences sp = getSharedPreferences("questions",MODE_PRIVATE);
        q1=findViewById(R.id.rq1);
        q2=findViewById(R.id.rq2);
        q3=findViewById(R.id.rq3);
        q4=findViewById(R.id.rq4);
        q5=findViewById(R.id.rq5);
        q6=findViewById(R.id.rq6);
        q7=findViewById(R.id.rq7);
        q8=findViewById(R.id.rq8);
        q9=findViewById(R.id.rq9);
        q10=findViewById(R.id.rq10);

        Q1=findViewById(R.id.l1);
        Q2=findViewById(R.id.l2);
        Q3=findViewById(R.id.l3);
        Q4=findViewById(R.id.l4);
        Q5=findViewById(R.id.l5);
        Q6=findViewById(R.id.l6);
        Q7=findViewById(R.id.l7);
        Q8=findViewById(R.id.l8);
        Q9=findViewById(R.id.l9);
        Q10=findViewById(R.id.l10);
        op1a = findViewById(R.id.radioButton1a);
        op1b = findViewById(R.id.radioButton1b);
        op1c = findViewById(R.id.radioButton1c);
        op1d = findViewById(R.id.radioButton1d);
        op2a = findViewById(R.id.radioButton2a);
        op2b = findViewById(R.id.radioButton2b);
        op2c = findViewById(R.id.radioButton2c);
        op2d = findViewById(R.id.radioButton2d);
        op3a = findViewById(R.id.radioButton3a);
        op3b = findViewById(R.id.radioButton3b);
        op3c = findViewById(R.id.radioButton3c);
        op3d = findViewById(R.id.radioButton3d);
        op4a = findViewById(R.id.radioButton4a);
        op4b = findViewById(R.id.radioButton4b);
        op4c = findViewById(R.id.radioButton4c);
        op4d = findViewById(R.id.radioButton4d);
        op5a = findViewById(R.id.radioButton5a);
        op5b = findViewById(R.id.radioButton5b);
        op5c = findViewById(R.id.radioButton5c);
        op5d = findViewById(R.id.radioButton5d);
        op6a = findViewById(R.id.radioButton6a);
        op6b = findViewById(R.id.radioButton6b);
        op6c = findViewById(R.id.radioButton6c);
        op6d = findViewById(R.id.radioButton6d);
        op7a = findViewById(R.id.radioButton7a);
        op7b = findViewById(R.id.radioButton7b);
        op7c = findViewById(R.id.radioButton7c);
        op7d = findViewById(R.id.radioButton7d);
        op8a = findViewById(R.id.radioButton8a);
        op8b = findViewById(R.id.radioButton8b);
        op8c = findViewById(R.id.radioButton8c);
        op8d = findViewById(R.id.radioButton8d);
        op9a = findViewById(R.id.radioButton9a);
        op9b = findViewById(R.id.radioButton9b);
        op9c = findViewById(R.id.radioButton9c);
        op9d = findViewById(R.id.radioButton9d);
        op10a = findViewById(R.id.radioButton10a);
        op10b= findViewById(R.id.radioButton10b);
        op10c= findViewById(R.id.radioButton10c);
        op10d= findViewById(R.id.radioButton10d);

        String ca1, ca2, ca3, ca4, ca5, ca6, ca7, ca8, ca9, ca10;
        ca1=sp.getString("a1","");
        ca2=sp.getString("a2","");
        ca3=sp.getString("a3","");
        ca4=sp.getString("a4","");
        ca5=sp.getString("a5","");
        ca6=sp.getString("a6","");
        ca7=sp.getString("a7","");
        ca8=sp.getString("a8","");
        ca9=sp.getString("a9","");
        ca10=sp.getString("a10","");


        String[] answers = new String[10];

        String x1,x2,x3,x4,x5,x6,x7,x8,x9,x10;
        x1 = sp.getString("1",getString(R.string.Q1));
        x2=sp.getString("2",getString(R.string.Q2));
        x3=sp.getString("3",getString(R.string.Q3));
        x4=sp.getString("4",getString(R.string.Q4));
        x5=sp.getString("5",getString(R.string.Q5));
        x6=sp.getString("6",getString(R.string.Q6));
        x7=sp.getString("7",getString(R.string.Q7));
        x8=sp.getString("8",getString(R.string.Q8));
        x9=sp.getString("9",getString(R.string.Q9));
        x10=sp.getString("10",getString(R.string.Q10));
        if(x1.equals(""))
        {
            Q1.setVisibility(View.GONE);
            op1a.setVisibility(View.GONE);
            op1b.setVisibility(View.GONE);
            op1c.setVisibility(View.GONE);
            op1d.setVisibility(View.GONE);
        }
        else
        {
            Q1.setText(x1);
            op1a.setText(sp.getString("1a",""));
            op1b.setText(sp.getString("1b",""));
            op1c.setText(sp.getString("1c",""));
            op1d.setText(sp.getString("1d",""));

        }

        if(x2.equals(""))
        {
            Q2.setVisibility(View.GONE);
            op2a.setVisibility(View.GONE);
            op2b.setVisibility(View.GONE);
            op2c.setVisibility(View.GONE);
            op2d.setVisibility(View.GONE);
        }
        else
        {
            op2a.setText(sp.getString("2a",getString(R.string.Q2a)));
            op2b.setText(sp.getString("2b",getString(R.string.Q2b)));
            op2c.setText(sp.getString("2c",getString(R.string.Q2c)));
            op2d.setText(sp.getString("2d",getString(R.string.Q2d)));
            Q2.setText(x2);


        }
        if(x3.equals(""))
        {
            Q3.setVisibility(View.GONE);
            op3a.setVisibility(View.GONE);
            op3b.setVisibility(View.GONE);
            op3c.setVisibility(View.GONE);
            op3d.setVisibility(View.GONE);
        }
        else
        {
            Q3.setText(x3);
            op3a.setText(sp.getString("3a",getString(R.string.Q3a)));
            op3b.setText(sp.getString("3b",getString(R.string.Q3b)));
            op3c.setText(sp.getString("3c",getString(R.string.Q3c)));
            op3d.setText(sp.getString("3d",getString(R.string.Q3d)));

        }
        if(x4.equals(""))
        {
            Q4.setVisibility(View.GONE);
            op4a.setVisibility(View.GONE);
            op4b.setVisibility(View.GONE);
            op4c.setVisibility(View.GONE);
            op4d.setVisibility(View.GONE);
        }
        else
        {
            Q4.setText(x4);
            op4a.setText(sp.getString("4a",getString(R.string.Q4a)));
            op4b.setText(sp.getString("4b",getString(R.string.Q4b)));
            op4c.setText(sp.getString("4c",getString(R.string.Q4c)));
            op4d.setText(sp.getString("4d",getString(R.string.Q4d)));

        }
        if(x5.equals(""))
        {
            Q5.setVisibility(View.GONE);
            op5a.setVisibility(View.GONE);
            op5b.setVisibility(View.GONE);
            op5c.setVisibility(View.GONE);
            op5d.setVisibility(View.GONE);
        }
        else
        {
            Q5.setText(x5);
            op5a.setText(sp.getString("5a",getString(R.string.Q5a)));
            op5b.setText(sp.getString("5b",getString(R.string.Q5b)));
            op5c.setText(sp.getString("5c",getString(R.string.Q5c)));
            op5d.setText(sp.getString("5d",getString(R.string.Q5d)));


        }
        if(x6.equals(""))
        {
            Q6.setVisibility(View.GONE);
            op6a.setVisibility(View.GONE);
            op6b.setVisibility(View.GONE);
            op6c.setVisibility(View.GONE);
            op6d.setVisibility(View.GONE);
        }
        else
        {
            Q6.setText(x6);
            op6a.setText(sp.getString("6a",getString(R.string.Q6a)));
            op6b.setText(sp.getString("6b",getString(R.string.Q6b)));
            op6c.setText(sp.getString("6c",getString(R.string.Q6c)));
            op6d.setText(sp.getString("6d",getString(R.string.Q6d)));

        }
        if(x7.equals(""))
        {
            Q7.setVisibility(View.GONE);
            op7a.setVisibility(View.GONE);
            op7b.setVisibility(View.GONE);
            op7c.setVisibility(View.GONE);
            op7d.setVisibility(View.GONE);
        }
        else
        {
            Q7.setText(x7);
            op7a.setText(sp.getString("7a",getString(R.string.Q7a)));
            op7b.setText(sp.getString("7b",getString(R.string.Q7b)));
            op7c.setText(sp.getString("7c",getString(R.string.Q7c)));
            op7d.setText(sp.getString("7d",getString(R.string.Q7d)));


        }
        if(x8.equals(""))
        {
            Q8.setVisibility(View.GONE);
            op8a.setVisibility(View.GONE);
            op8b.setVisibility(View.GONE);
            op8c.setVisibility(View.GONE);
            op8d.setVisibility(View.GONE);
        }
        else
        {
            Q8.setText(x8);
            op8a.setText(sp.getString("8a",getString(R.string.Q8a)));
            op8b.setText(sp.getString("8b",getString(R.string.Q8b)));
            op8c.setText(sp.getString("8c",getString(R.string.Q8c)));
            op8d.setText(sp.getString("8d",getString(R.string.Q8d)));

        }
        if(x9.equals(""))
        {
            Q9.setVisibility(View.GONE);
            op9a.setVisibility(View.GONE);
            op9b.setVisibility(View.GONE);
            op9c.setVisibility(View.GONE);
            op9d.setVisibility(View.GONE);
        }
        else
        {
            Q9.setText(x9);
            op9a.setText(sp.getString("9a",getString(R.string.Q9a)));
            op9b.setText(sp.getString("9b",getString(R.string.Q9b)));
            op9c.setText(sp.getString("9c",getString(R.string.Q9c)));
            op9d.setText(sp.getString("9d",getString(R.string.Q9d)));

        }
        if(x10.equals(""))
        {
            q10.setVisibility(View.GONE);
            op10a.setVisibility(View.GONE);
            op10b.setVisibility(View.GONE);
            op10c.setVisibility(View.GONE);
            op10d.setVisibility(View.GONE);
        }
        else
        {
            Q10.setText(x10);
            op10a.setText(sp.getString("10a",getString(R.string.Q10a)));
            op10b.setText(sp.getString("10b",getString(R.string.Q10b)));
            op10c.setText(sp.getString("10c",getString(R.string.Q10c)));
            op10d.setText(sp.getString("10d",getString(R.string.Q10d)));

        }
        if(ca1.equals("Option 1"))
            s1=findViewById(R.id.radioButton1a);
        else if(ca1.equals("Option 2"))
            s1=findViewById(R.id.radioButton1b);
        else if(ca1.equals("Option 3"))
            s1=findViewById(R.id.radioButton1c);
        else if(ca1.equals("Option 4"))
            s1=findViewById(R.id.radioButton1d);

        if(ca2.equals("Option 1"))
            s2=findViewById(R.id.radioButton2a);
        else if(ca2.equals("Option 2"))
            s2=findViewById(R.id.radioButton2b);
        else if(ca2.equals("Option 3"))
            s2=findViewById(R.id.radioButton2c);
        else if(ca2.equals("Option 4"))
            s2=findViewById(R.id.radioButton2d);

        if(ca3.equals("Option 1"))
            s3=findViewById(R.id.radioButton3a);
        else if(ca3.equals("Option 2"))
            s3=findViewById(R.id.radioButton3b);
        else if(ca3.equals("Option 3"))
            s3=findViewById(R.id.radioButton3c);
        else if(ca3.equals("Option 4"))
            s3=findViewById(R.id.radioButton3d);

        if(ca4.equals("Option 1"))
            s4=findViewById(R.id.radioButton4a);
        else if(ca4.equals("Option 2"))
            s4=findViewById(R.id.radioButton4b);
        else if(ca4.equals("Option 3"))
            s4=findViewById(R.id.radioButton4c);
        else if(ca4.equals("Option 4"))
            s4=findViewById(R.id.radioButton4d);

        if(ca5.equals("Option 1"))
            s5=findViewById(R.id.radioButton5a);
        else if(ca5.equals("Option 2"))
            s5=findViewById(R.id.radioButton5b);
        else if(ca5.equals("Option 3"))
            s5=findViewById(R.id.radioButton5c);
        else if(ca5.equals("Option 4"))
            s5=findViewById(R.id.radioButton5d);

        if(ca6.equals("Option 1"))
            s6=findViewById(R.id.radioButton6a);
        else if(ca6.equals("Option 2"))
            s6=findViewById(R.id.radioButton6b);
        else if(ca6.equals("Option 3"))
            s6=findViewById(R.id.radioButton6c);
        else if(ca6.equals("Option 4"))
            s6=findViewById(R.id.radioButton6d);

        if(ca7.equals("Option 1"))
            s7=findViewById(R.id.radioButton7a);
        else if(ca7.equals("Option 2"))
            s7=findViewById(R.id.radioButton7b);
        else if(ca7.equals("Option 3"))
            s7=findViewById(R.id.radioButton7c);
        else if(ca7.equals("Option 4"))
            s7=findViewById(R.id.radioButton7d);

        if(ca8.equals("Option 1"))
            s8=findViewById(R.id.radioButton8a);
        else if(ca8.equals("Option 2"))
            s8=findViewById(R.id.radioButton8b);
        else if(ca8.equals("Option 3"))
            s8=findViewById(R.id.radioButton8c);
        else if(ca8.equals("Option 4"))
            s8=findViewById(R.id.radioButton8d);

        if(ca9.equals("Option 1"))
            s9=findViewById(R.id.radioButton9a);
        else if(ca9.equals("Option 2"))
            s9=findViewById(R.id.radioButton9b);
        else if(ca9.equals("Option 3"))
            s9=findViewById(R.id.radioButton9c);
        else if(ca9.equals("Option 4"))
            s9=findViewById(R.id.radioButton9d);

        if(ca10.equals("Option 1"))
            s10=findViewById(R.id.radioButton10a);
        else if(ca10.equals("Option 2"))
            s10=findViewById(R.id.radioButton10b);
        else if(ca10.equals("Option 3"))
            s10=findViewById(R.id.radioButton10c);
        else if(ca10.equals("Option 4"))
            s10=findViewById(R.id.radioButton10d);

        s1.setBackgroundColor(getColor(R.color.Green));
        s2.setBackgroundColor(getColor(R.color.Green));
        s3.setBackgroundColor(getColor(R.color.Green));
        s4.setBackgroundColor(getColor(R.color.Green));
        s5.setBackgroundColor(getColor(R.color.Green));
        s6.setBackgroundColor(getColor(R.color.Green));
        s7.setBackgroundColor(getColor(R.color.Green));
        s8.setBackgroundColor(getColor(R.color.Green));
        s9.setBackgroundColor(getColor(R.color.Green));
        s10.setBackgroundColor(getColor(R.color.Green));

        String[] sol = VivaQuestions.getAnswers();
        a1=sol[0];
        a2=sol[1];
        a3=sol[2];
        a4=sol[3];
        a5=sol[4];
        a6=sol[5];
        a7=sol[6];
        a8=sol[7];
        a9=sol[8];
        a10=sol[9];

        if(a1.equals("Option 1"))
        {
            q1.check(R.id.radioButton1a);
        }
        else if(a1.equals("Option 2"))
        {
            q1.check(R.id.radioButton1b);

        }
        else if(a1.equals("Option 3"))
        {
            q1.check(R.id.radioButton1c);

        }
        else if(a1.equals("Option 4"))
        {
            q1.check(R.id.radioButton1d);

        }
        if(a2.equals("Option 1"))
        {
            q2.check(R.id.radioButton2a);
        }
        else if(a2.equals("Option 2"))
        {
            q2.check(R.id.radioButton2b);

        }
        else if(a2.equals("Option 3"))
        {
            q2.check(R.id.radioButton2c);

        }
        else if(a2.equals("Option 4"))
        {
            q2.check(R.id.radioButton2d);

        }
        if(a3.equals("Option 1"))
        {
            q3.check(R.id.radioButton3a);
        }
        else if(a3.equals("Option 2"))
        {
            q3.check(R.id.radioButton3b);

        }
        else if(a3.equals("Option 3"))
        {
            q3.check(R.id.radioButton3c);

        }
        else if(a3.equals("Option 4"))
        {
            q3.check(R.id.radioButton3d);

        }
        if(a4.equals("Option 1"))
        {
            q4.check(R.id.radioButton4a);
        }
        else if(a4.equals("Option 2"))
        {
            q4.check(R.id.radioButton4b);

        }
        else if(a4.equals("Option 3"))
        {
            q4.check(R.id.radioButton4c);

        }
        else if(a4.equals("Option 4"))
        {
            q4.check(R.id.radioButton4d);

        }
        if(a5.equals("Option 1"))
        {
            q5.check(R.id.radioButton5a);
        }
        else if(a5.equals("Option 2"))
        {
            q5.check(R.id.radioButton5b);

        }
        else if(a5.equals("Option 3"))
        {
            q5.check(R.id.radioButton5c);

        }
        else if(a5.equals("Option 4"))
        {
            q5.check(R.id.radioButton5d);

        }
        if(a6.equals("Option 1"))
        {
            q6.check(R.id.radioButton6a);
        }
        else if(a6.equals("Option 2"))
        {
            q6.check(R.id.radioButton6b);

        }
        else if(a6.equals("Option 3"))
        {
            q6.check(R.id.radioButton6c);

        }
        else if(a6.equals("Option 4"))
        {
            q6.check(R.id.radioButton6d);

        }
        if(a7.equals("Option 1"))
        {
            q7.check(R.id.radioButton7a);
        }
        else if(a7.equals("Option 2"))
        {
            q7.check(R.id.radioButton7b);

        }
        else if(a7.equals("Option 3"))
        {
            q7.check(R.id.radioButton7c);

        }
        else if(a7.equals("Option 4"))
        {
            q7.check(R.id.radioButton7d);

        }
        if(a8.equals("Option 1"))
        {
            q8.check(R.id.radioButton8a);
        }
        else if(a8.equals("Option 2"))
        {
            q8.check(R.id.radioButton8b);

        }
        else if(a8.equals("Option 3"))
        {
            q8.check(R.id.radioButton8c);

        }
        else if(a8.equals("Option 4"))
        {
            q8.check(R.id.radioButton8d);

        }
        if(a9.equals("Option 1"))
        {
            q9.check(R.id.radioButton9a);
        }
        else if(a9.equals("Option 2"))
        {
            q9.check(R.id.radioButton9b);

        }
        else if(a9.equals("Option 3"))
        {
            q9.check(R.id.radioButton9c);

        }
        else if(a9.equals("Option 4"))
        {
            q9.check(R.id.radioButton9d);

        }
        if(a10.equals("Option 1"))
        {
            q10.check(R.id.radioButton10a);
        }
        else if(a10.equals("Option 2"))
        {
            q10.check(R.id.radioButton10b);

        }
        else if(a10.equals("Option 3"))
        {
            q10.check(R.id.radioButton10c);

        }
        else if(a10.equals("Option 4"))
        {
            q10.check(R.id.radioButton10d);

        }





        if(q1.getCheckedRadioButtonId() != s1.getId())
        {
            findViewById(q1.getCheckedRadioButtonId()).setBackgroundColor(getColor(R.color.Red));
        }
        if(q2.getCheckedRadioButtonId() != s2.getId())
        {
            findViewById(q2.getCheckedRadioButtonId()).setBackgroundColor(getColor(R.color.Red));
        }
        if(q3.getCheckedRadioButtonId() != s3.getId())
        {
            findViewById(q3.getCheckedRadioButtonId()).setBackgroundColor(getColor(R.color.Red));
        }
        if(q4.getCheckedRadioButtonId() != s4.getId())
        {
            findViewById(q4.getCheckedRadioButtonId()).setBackgroundColor(getColor(R.color.Red));
        }
        if(q5.getCheckedRadioButtonId() != s5.getId())
        {
            findViewById(q5.getCheckedRadioButtonId()).setBackgroundColor(getColor(R.color.Red));
        }
        if(q6.getCheckedRadioButtonId() != s6.getId())
        {
            findViewById(q6.getCheckedRadioButtonId()).setBackgroundColor(getColor(R.color.Red));
        }
        if(q7.getCheckedRadioButtonId() != s7.getId())
        {
            findViewById(q7.getCheckedRadioButtonId()).setBackgroundColor(getColor(R.color.Red));
        }
        if(q8.getCheckedRadioButtonId() != s8.getId())
        {
            findViewById(q8.getCheckedRadioButtonId()).setBackgroundColor(getColor(R.color.Red));
        }
        if(q9.getCheckedRadioButtonId() != s9.getId())
        {
            findViewById(q9.getCheckedRadioButtonId()).setBackgroundColor(getColor(R.color.Red));
        }
        if(q10.getCheckedRadioButtonId() != s10.getId())
        {
            findViewById(q10.getCheckedRadioButtonId()).setBackgroundColor(getColor(R.color.Red));
        }
    }
}