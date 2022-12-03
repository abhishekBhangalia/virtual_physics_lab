package com.example.virtualphysicslab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class VivaQuestions extends AppCompatActivity {
    MyDatabase db;
    TextView title, description, q1, q2, q3, q4 ,q5, q6, q7, q8, q9, q10;
    RadioButton op1a, op1b, op1c, op1d, op2a, op2b, op2c, op2d, op3a, op3b, op3c, op3d, op4a, op4b, op4c, op4d, op5a, op5b, op5c, op5d, op6a, op6b, op6c, op6d, op7a, op7b, op7c, op7d, op8a, op8b, op8c, op8d, op9a, op9b, op9c, op9d, op10a, op10b, op10c, op10d;
    RadioGroup a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;
    int marks = 0, atmp = 0;
    static int total_ques=0;
    Button submit;
   SharedPreferences sp;
    static String [] answers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viva_questions);

        db = new MyDatabase(this);
        answers = new String[10];

        submit = findViewById(R.id.submitViva);
        submit.setEnabled(false);
        sp = getSharedPreferences("questions",MODE_PRIVATE);

        title = findViewById(R.id.svivaTitle);
        description = findViewById(R.id.sdescription);
        q1 = findViewById(R.id.squestion1);
        q2 = findViewById(R.id.squestion2);
        q3 = findViewById(R.id.squestion3);
        q4 = findViewById(R.id.squestion4);
        q5 = findViewById(R.id.squestion5);
        q6 = findViewById(R.id.squestion6);
        q7 = findViewById(R.id.squestion7);
        q8 = findViewById(R.id.squestion8);
        q9 = findViewById(R.id.squestion9);
        q10 = findViewById(R.id.squestion10);
        op1a = findViewById(R.id.soption11);
        op1b = findViewById(R.id.soption12);
        op1c = findViewById(R.id.soption13);
        op1d = findViewById(R.id.soption14);
        op2a = findViewById(R.id.soption21);
        op2b = findViewById(R.id.soption22);
        op2c = findViewById(R.id.soption23);
        op2d = findViewById(R.id.soption24);
        op3a = findViewById(R.id.soption31);
        op3b = findViewById(R.id.soption32);
        op3c = findViewById(R.id.soption33);
        op3d = findViewById(R.id.soption34);
        op4a = findViewById(R.id.soption41);
        op4b = findViewById(R.id.soption42);
        op4c = findViewById(R.id.soption43);
        op4d = findViewById(R.id.soption44);
        op5a = findViewById(R.id.soption51);
        op5b = findViewById(R.id.soption52);
        op5c = findViewById(R.id.soption53);
        op5d = findViewById(R.id.soption54);
        op6a = findViewById(R.id.soption61);
        op6b = findViewById(R.id.soption62);
        op6c = findViewById(R.id.soption63);
        op6d = findViewById(R.id.soption64);
        op7a = findViewById(R.id.soption71);
        op7b = findViewById(R.id.soption72);
        op7c = findViewById(R.id.soption73);
        op7d = findViewById(R.id.soption74);
        op8a = findViewById(R.id.soption81);
        op8b = findViewById(R.id.soption82);
        op8c = findViewById(R.id.soption83);
        op8d = findViewById(R.id.soption84);
        op9a = findViewById(R.id.soption91);
        op9b = findViewById(R.id.soption92);
        op9c = findViewById(R.id.soption93);
        op9d = findViewById(R.id.soption94);
        op10a = findViewById(R.id.soption101);
        op10b= findViewById(R.id.soption102);
        op10c= findViewById(R.id.soption103);
        op10d= findViewById(R.id.soption104);
        a1 = findViewById(R.id.ar1);
        a2 = findViewById(R.id.ar2);
        a3 = findViewById(R.id.ar3);
        a4 = findViewById(R.id.ar4);
        a5 = findViewById(R.id.ar5);
        a6 = findViewById(R.id.ar6);
        a7 = findViewById(R.id.ar7);
        a8 = findViewById(R.id.ar8);
        a9 = findViewById(R.id.ar9);
        a10 = findViewById(R.id.ar10);


    }

    @Override
    protected void onResume() {
        super.onResume();

        if(LoginFragment.isTeacher)
            submit.setVisibility(View.GONE);
        title.setText(sp.getString("title","Viva"));
        description.setText(sp.getString("desc", ""));
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
            q1.setVisibility(View.GONE);
            op1a.setVisibility(View.GONE);
            op1b.setVisibility(View.GONE);
            op1c.setVisibility(View.GONE);
            op1d.setVisibility(View.GONE);
        }
        else
        {
            total_ques++;
            q1.setText(x1);
            op1a.setText(sp.getString("1a",getString(R.string.Q1a)));
            op1b.setText(sp.getString("1b",getString(R.string.Q1b)));
            op1c.setText(sp.getString("1c",getString(R.string.Q1c)));
            op1d.setText(sp.getString("1d",getString(R.string.Q1d)));
            a1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    atmp++;
                    isAllAttempted();
                    if(checkedId == op1a.getId())
                        answers[0] = "Option 1";
                    else if(checkedId == op1b.getId())
                        answers[0] = "Option 2";
                    else if(checkedId == op1c.getId())
                        answers[0] = "Option 3";
                    else if(checkedId == op1d.getId())
                        answers[0] = "Option 4";
                    if(answers[0].equals(sp.getString("a1","")))
                        marks++;
                }
            });
        }

        if(x2.equals(""))
        {
            q2.setVisibility(View.GONE);
            op2a.setVisibility(View.GONE);
            op2b.setVisibility(View.GONE);
            op2c.setVisibility(View.GONE);
            op2d.setVisibility(View.GONE);
        }
        else
        {
            total_ques++;
            op2a.setText(sp.getString("2a",getString(R.string.Q2a)));
            op2b.setText(sp.getString("2b",getString(R.string.Q2b)));
            op2c.setText(sp.getString("2c",getString(R.string.Q2c)));
            op2d.setText(sp.getString("2d",getString(R.string.Q2d)));
            q2.setText(x2);
            a2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    atmp++;
                    isAllAttempted();
                    if(checkedId == op2a.getId())
                        answers[1] = "Option 1";
                    else if(checkedId == op2b.getId())
                        answers[1] = "Option 2";
                    else if(checkedId == op2c.getId())
                        answers[1] = "Option 3";
                    else if(checkedId == op2d.getId())
                        answers[1] = "Option 4";
                    if(answers[1].equals(sp.getString("a2","")))
                        marks++;
                }
            });

        }
        if(x3.equals(""))
        {
            q3.setVisibility(View.GONE);
            op3a.setVisibility(View.GONE);
            op3b.setVisibility(View.GONE);
            op3c.setVisibility(View.GONE);
            op3d.setVisibility(View.GONE);
        }
        else
        {
            total_ques++;
            q3.setText(x3);
            op3a.setText(sp.getString("3a",getString(R.string.Q3a)));
            op3b.setText(sp.getString("3b",getString(R.string.Q3b)));
            op3c.setText(sp.getString("3c",getString(R.string.Q3c)));
            op3d.setText(sp.getString("3d",getString(R.string.Q3d)));
            a3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    atmp++;
                    isAllAttempted();
                    if(checkedId == op3a.getId())
                        answers[2] = "Option 1";
                    else if(checkedId == op3b.getId())
                        answers[2] = "Option 2";
                    else if(checkedId == op3c.getId())
                        answers[2] = "Option 3";
                    else if(checkedId == op3d.getId())
                        answers[2] = "Option 4";
                    if(answers[2].equals(sp.getString("a3","")))
                        marks++;
                }
            });
        }
        if(x4.equals(""))
        {
            q4.setVisibility(View.GONE);
            op4a.setVisibility(View.GONE);
            op4b.setVisibility(View.GONE);
            op4c.setVisibility(View.GONE);
            op4d.setVisibility(View.GONE);
        }
        else
        {
            total_ques++;
            q4.setText(x4);
            op4a.setText(sp.getString("4a",getString(R.string.Q4a)));
            op4b.setText(sp.getString("4b",getString(R.string.Q4b)));
            op4c.setText(sp.getString("4c",getString(R.string.Q4c)));
            op4d.setText(sp.getString("4d",getString(R.string.Q4d)));
            a4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    atmp++;
                    isAllAttempted();
                    if(checkedId == op4a.getId())
                        answers[3] = "Option 1";
                    else if(checkedId == op4b.getId())
                        answers[3] = "Option 2";
                    else if(checkedId == op4c.getId())
                        answers[3] = "Option 3";
                    else if(checkedId == op4d.getId())
                        answers[3] = "Option 4";
                    if(answers[3].equals(sp.getString("a4","")))
                        marks++;
                }
            });
        }
        if(x5.equals(""))
        {
            q5.setVisibility(View.GONE);
            op5a.setVisibility(View.GONE);
            op5b.setVisibility(View.GONE);
            op5c.setVisibility(View.GONE);
            op5d.setVisibility(View.GONE);
        }
        else
        {
            total_ques++;
            q5.setText(x5);
            op5a.setText(sp.getString("5a",getString(R.string.Q5a)));
            op5b.setText(sp.getString("5b",getString(R.string.Q5b)));
            op5c.setText(sp.getString("5c",getString(R.string.Q5c)));
            op5d.setText(sp.getString("5d",getString(R.string.Q5d)));
            a5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    atmp++;
                    isAllAttempted();
                    if(checkedId == op5a.getId())
                        answers[4] = "Option 1";
                    else if(checkedId == op5b.getId())
                        answers[4] = "Option 2";
                    else if(checkedId == op5c.getId())
                        answers[4] = "Option 3";
                    else if(checkedId == op5d.getId())
                        answers[4] = "Option 4";
                    if(answers[4].equals(sp.getString("a5","")))
                        marks++;
                }
            });

        }
        if(x6.equals(""))
        {
            q6.setVisibility(View.GONE);
            op6a.setVisibility(View.GONE);
            op6b.setVisibility(View.GONE);
            op6c.setVisibility(View.GONE);
            op6d.setVisibility(View.GONE);
        }
        else
        {
            total_ques++;
            q6.setText(x6);
            op6a.setText(sp.getString("6a",getString(R.string.Q6a)));
            op6b.setText(sp.getString("6b",getString(R.string.Q6b)));
            op6c.setText(sp.getString("6c",getString(R.string.Q6c)));
            op6d.setText(sp.getString("6d",getString(R.string.Q6d)));
            a6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    atmp++;
                    isAllAttempted();
                    if(checkedId == op6a.getId())
                        answers[5] = "Option 1";
                    else if(checkedId == op6b.getId())
                        answers[5] = "Option 2";
                    else if(checkedId == op6c.getId())
                        answers[5] = "Option 3";
                    else if(checkedId == op6d.getId())
                        answers[5] = "Option 4";
                    if(answers[5].equals(sp.getString("a6","")))
                        marks++;
                }
            });
        }
        if(x7.equals(""))
        {
            q7.setVisibility(View.GONE);
            op7a.setVisibility(View.GONE);
            op7b.setVisibility(View.GONE);
            op7c.setVisibility(View.GONE);
            op7d.setVisibility(View.GONE);
        }
        else
        {
            total_ques++;
            q7.setText(x7);
            op7a.setText(sp.getString("7a",getString(R.string.Q7a)));
            op7b.setText(sp.getString("7b",getString(R.string.Q7b)));
            op7c.setText(sp.getString("7c",getString(R.string.Q7c)));
            op7d.setText(sp.getString("7d",getString(R.string.Q7d)));

            a7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    atmp++;
                    isAllAttempted();
                    if(checkedId == op7a.getId())
                        answers[6] = "Option 1";
                    else if(checkedId == op7b.getId())
                        answers[6] = "Option 2";
                    else if(checkedId == op7c.getId())
                        answers[6] = "Option 3";
                    else if(checkedId == op7d.getId())
                        answers[6] = "Option 4";
                    if(answers[6].equals(sp.getString("a7","")))
                        marks++;
                }
            });
        }
        if(x8.equals(""))
        {
            q8.setVisibility(View.GONE);
            op8a.setVisibility(View.GONE);
            op8b.setVisibility(View.GONE);
            op8c.setVisibility(View.GONE);
            op8d.setVisibility(View.GONE);
        }
        else
        {
            total_ques++;
            q8.setText(x8);
            op8a.setText(sp.getString("8a",getString(R.string.Q8a)));
            op8b.setText(sp.getString("8b",getString(R.string.Q8b)));
            op8c.setText(sp.getString("8c",getString(R.string.Q8c)));
            op8d.setText(sp.getString("8d",getString(R.string.Q8d)));
            a8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    atmp++;
                    isAllAttempted();
                    if(checkedId == op8a.getId())
                        answers[7] = "Option 1";
                    else if(checkedId == op8b.getId())
                        answers[7] = "Option 2";
                    else if(checkedId == op8c.getId())
                        answers[7] = "Option 3";
                    else if(checkedId == op8d.getId())
                        answers[7] = "Option 4";
                    if(answers[7].equals(sp.getString("a8","")))
                        marks++;
                }
            });
        }
        if(x9.equals(""))
        {
            q9.setVisibility(View.GONE);
            op9a.setVisibility(View.GONE);
            op9b.setVisibility(View.GONE);
            op9c.setVisibility(View.GONE);
            op9d.setVisibility(View.GONE);
        }
        else
        {
            total_ques++;
            q9.setText(x9);
            op9a.setText(sp.getString("9a",getString(R.string.Q9a)));
            op9b.setText(sp.getString("9b",getString(R.string.Q9b)));
            op9c.setText(sp.getString("9c",getString(R.string.Q9c)));
            op9d.setText(sp.getString("9d",getString(R.string.Q9d)));
            a9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    atmp++;
                    isAllAttempted();
                    if(checkedId == op9a.getId())
                        answers[8] = "Option 1";
                    else if(checkedId == op9b.getId())
                        answers[8] = "Option 2";
                    else if(checkedId == op9c.getId())
                        answers[8] = "Option 3";
                    else if(checkedId == op9d.getId())
                        answers[8] = "Option 4";
                    if(answers[8].equals(sp.getString("a9","")))
                        marks++;
                }
            });
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
            total_ques++;
            q10.setText(x10);
            op10a.setText(sp.getString("10a",getString(R.string.Q10a)));
            op10b.setText(sp.getString("10b",getString(R.string.Q10b)));
            op10c.setText(sp.getString("10c",getString(R.string.Q10c)));
            op10d.setText(sp.getString("10d",getString(R.string.Q10d)));
            a10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    atmp++;
                    isAllAttempted();
                    if(checkedId == op10a.getId())
                        answers[9] = "Option 1";
                    else if(checkedId == op10b.getId())
                        answers[9] = "Option 2";
                    else if(checkedId == op10c.getId())
                        answers[9] = "Option 3";
                    else if(checkedId == op10d.getId())
                        answers[9] = "Option 4";
                    if(answers[9].equals(sp.getString("a10","")))
                        marks++;
                }
            });
        }
    }

    public void viewResult(View view) {
        try
        {
            db.insert(YMViva.getRollno(),YMViva.getName(),YMViva.getSemester(), YMViva.getCourse(),marks);
        }
        catch (Exception e)
        {
            Log.e("insert Data",e.getMessage());
            Toast.makeText(this,"Error in inserting data !!!", Toast.LENGTH_SHORT).show();
        }
        Intent i = new Intent(this, VivaResult.class);
        i.putExtra("marks",marks);
        startActivity(i);
    }

    public void isAllAttempted()
    {
        if(atmp == total_ques )
            submit.setEnabled(true);
    }

    public static String[] getAnswers(){
        return answers;
    }

    public static int getTotalQues()
    {
        return total_ques;
    }


}