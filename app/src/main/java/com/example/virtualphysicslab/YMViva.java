package com.example.virtualphysicslab;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class YMViva extends Fragment {
    static EditText name,rollNo;
    static Button editViva;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    public static String sem,course_f;
    private boolean courseNull = false;
    private boolean semNull = false;
    public String sname, sroll;

    public YMViva() {
        // Required empty public constructor
    }

    public static YMViva newInstance(String param1, String param2) {
        YMViva fragment = new YMViva();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_y_m_viva, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            Button edit = view.findViewById(R.id.editViva);
         name = view.findViewById(R.id.name);
         rollNo = view.findViewById(R.id.roll_no);
         editViva = view.findViewById(R.id.editViva);
         TextView rname, rRollno;
         rname = view.findViewById(R.id.rName);
         rRollno = view.findViewById(R.id.rRollno);

         if(!LoginFragment.isTeacher)
             editViva.setVisibility(View.GONE);
         else
         {
             name.setVisibility(View.GONE);
             rollNo.setVisibility(View.GONE);
             rRollno.setVisibility(View.GONE);
             rname.setVisibility(View.GONE);
         }
             

        Spinner semester = (Spinner) view.findViewById(R.id.semester_s);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),R.array.semester,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semester.setAdapter(adapter);
        Spinner course = (Spinner) view.findViewById(R.id.course_s);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(),R.array.course,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        course.setAdapter(adapter2);
        semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0 :
                    {
                        sem = "1";
                        break;
                    }
                    case 1 :
                    {
                        sem = "2";
                        break;
                    }
                    case 2 :
                    {
                        sem = "3";
                        break;
                    }
                    case 3 :
                    {
                        sem = "4";
                        break;
                    }
                    case 4 :
                    {
                        sem = "5";
                        break;

                    }
                    case 5 :
                    {
                        sem = "6";
                        break;
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                semNull = true;
            }
        });

        course.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0 :
                    {
                        course_f = "BSc(Hons.) Computer Science";
                        break;
                    }
                    case 1 :
                    {
                        course_f = "BSc(Hons.) Mathematics";
                        break;
                    }
                    case 2 :
                    {
                        course_f = "BSc(Hons.) Zoology";
                        break;
                    }
                    case 3 :
                    {
                        course_f = "BSc(Hons.) Botany";
                        break;
                    }
                    case 4 :
                    {
                        course_f = "BSc(Hons.) Physics";
                        break;
                    }
                    case 5 :
                    {
                        course_f = "BSc(Hons.) Chemistry";
                        break;
                    }
                    case 6 :
                    {
                        course_f = "PME";
                        break;
                    }
                    case 7 :
                    {
                        course_f = "PMCS";
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                courseNull=true;
            }
        });



        TextWatcher myTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                checkForEmptyValues();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkForEmptyValues();
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkForEmptyValues();
            }
        };

        name.addTextChangedListener(myTextWatcher);
        rollNo.addTextChangedListener(myTextWatcher);

        Button b = (Button) view.findViewById(R.id.startViva);
        if(LoginFragment.isTeacher) {
            b.setText("Preview Viva");
            b.setEnabled(true);
        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sname = name.getText().toString().trim();
                sroll = rollNo.getText().toString().trim();
                Intent j = new Intent(getContext(),VivaQuestions.class);
                startActivity(j);
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),EditViva.class);
                startActivity(i);
            }
        });
    }

    public static String getName()
    {
        return name.getText().toString().trim();
    }
    public static String getRollno()
    {
        return rollNo.getText().toString().trim();
    }
    public static String getSemester(){
        return sem;
    }
    public static String getCourse(){
        return course_f;
    }

    private void checkForEmptyValues() {
        if(name.getText().toString().equals(""))
            name.setError("Please enter your Name !!!");
        if(rollNo.getText().toString().equals(""))
            rollNo.setError("Please enter your Roll No. !!!");

        Button b = (Button) getView().findViewById(R.id.startViva);
        EditText name = (EditText) getView().findViewById(R.id.name);
        EditText rollNo = (EditText)  getView().findViewById(R.id.roll_no);
        String s1 = name.getText().toString();
        String s2 = rollNo.getText().toString();

        if(s1.equals("") || s2.equals("") || semNull || courseNull)
            b.setEnabled(false);
        else
            b.setEnabled(true);
        if(LoginFragment.isTeacher)
            b.setEnabled(true);
    }
}