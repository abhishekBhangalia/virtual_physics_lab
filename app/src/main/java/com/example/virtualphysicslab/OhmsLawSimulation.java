package com.example.virtualphysicslab;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OhmsLawSimulation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OhmsLawSimulation extends Fragment implements View.OnTouchListener {
    TextView ammeter, voltmeter, resistor,bpos,bneg,rpos,rneg,apos,aneg,vpos,vneg;
    EditText volts,current,resistance;
    Button reset, showResult;
    Switch switch_ohms;
    public int x1, x2, y1, y2;
    Canvas canvas;
    Paint paint;
    Bitmap bitmap;
    ConstraintLayout layout;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OhmsLawSimulation() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OhmsLawSimulation.
     */
    // TODO: Rename and change types and number of parameters
    public static OhmsLawSimulation newInstance(String param1, String param2) {
        OhmsLawSimulation fragment = new OhmsLawSimulation();
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            View myView = getActivity().getWindow().getDecorView();
            myView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|
                            View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }

        View view = inflater.inflate(R.layout.ohms_law_sim2, container, false);
        ammeter = view.findViewById(R.id.ammeter);
        voltmeter = view.findViewById(R.id.voltmeter);
        resistor = view.findViewById(R.id.resistor);
        apos = view.findViewById(R.id.apos);
        aneg = view.findViewById(R.id.aneg);
        vpos = view.findViewById(R.id.vpos);
        vneg = view.findViewById(R.id.vneg);
        rpos = view.findViewById(R.id.rpos);
        rneg = view.findViewById(R.id.rneg);
        bpos = view.findViewById(R.id.bpos);
        bneg = view.findViewById(R.id.bneg);

        reset = view.findViewById(R.id.reset_ohms);
        showResult = view.findViewById(R.id.showResult_ohms);
        switch_ohms = view.findViewById(R.id.ohms_switch);
        layout = view.findViewById(R.id.ohms_layout);



        /*Display display = getActivity().getWindowManager().getDefaultDisplay();
        float dw = display.getWidth();
        float dh = display.getHeight();
        bitmap = Bitmap.createBitmap((int)dw, (int)dh, Bitmap.Config.ARGB_8888,false);
        canvas = new Canvas();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(4);
        //layout.setBackgroundColor(Color.WHITE);
        //layout.setOnTouchListener(this);*/


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       /* apos.setOnTouchListener(handleTouch);
        aneg.setOnTouchListener(handleTouch);
        vpos.setOnTouchListener(handleTouch);
        vneg.setOnTouchListener(handleTouch);
        rpos.setOnTouchListener(handleTouch);
        rneg.setOnTouchListener(handleTouch);
        bpos.setOnTouchListener(handleTouch);
        bneg.setOnTouchListener(handleTouch);
        switch_ohms.setOnTouchListener(handleTouch);*/
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
                voltmeter.setText("Voltmeter\n"+current.getText().toString()+" V");

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

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        current.addTextChangedListener(myTextWatcher1);
        volts.addTextChangedListener(myTextWatcher2);
        resistance.addTextChangedListener(myTextWatcher3);


    }
    private View.OnTouchListener handleTouch = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            int x = (int) event.getX();
            int y = (int) event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    Log.i("TAG", "touched down");
                     x1 = (int) event.getX();
                     y1 = (int) event.getY();
                    break;
                }
                case MotionEvent.ACTION_MOVE: {
                    Log.i("TAG", "moving: (" + x + ", " + y + ")");
                    x2 = (int) event.getX();
                    y2 = (int) event.getY();
                    drawCurvedArrow(x1, y1, x2, y2,2, Color.BLACK,3);
                    x1 = x2;
                    y1 = y2;
                    break;
                }
                case MotionEvent.ACTION_UP: {
                     x2 = (int) event.getX();
                     y2 = (int) event.getY();
                     drawCurvedArrow(x1, y1, x2, y2,2, Color.BLACK,3);
                    Log.i("TAG", "touched up");
                    break;
                }
            }

            return true;
        }
    };
    public void drawCurvedArrow(int x1, int y1, int x2, int y2, int curveRadius, int color, int lineWidth) {

        Paint paint  = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(lineWidth);
        paint.setColor(ContextCompat.getColor(getContext(), color));

        final Path path = new android.graphics.Path();
        int midX            = x1 + ((x2 - x1) / 2);
        int midY            = y1 + ((y2 - y1) / 2);
        float xDiff         = midX - x1;
        float yDiff         = midY - y1;
        double angle        = (Math.atan2(yDiff, xDiff) * (180 / Math.PI)) - 90;
        double angleRadians = Math.toRadians(angle);
        float pointX        = (float) (midX + curveRadius * Math.cos(angleRadians));
        float pointY        = (float) (midY + curveRadius * Math.sin(angleRadians));

        path.moveTo(x1, y1);
        path.cubicTo(x1,y1,pointX, pointY, x2, y2);
        Canvas canvas = new Canvas();
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                Toast.makeText(getContext(),"Touched",Toast.LENGTH_SHORT).show();
                Log.i("TAG", "touched down");
                x1 = (int) event.getX();
                y1 = (int) event.getY();
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                //Log.i("TAG", "moving: (" + x + ", " + y + ")");
                Toast.makeText(getContext(),"Dragging",Toast.LENGTH_SHORT).show();
                x2 = (int) event.getX();
                y2 = (int) event.getY();
                //drawCurvedArrow(x1, y1, x2, y2,2, Color.BLACK,3);
                canvas.drawLine(x1,y1,x2,y2,paint);
                x1 = x2;
                y1 = y2;
                break;
            }
            case MotionEvent.ACTION_UP: {
                /*x2 = (int) event.getX();
                y2 = (int) event.getY();
                drawCurvedArrow(x1, y1, x2, y2,2, Color.BLACK,3);
                Log.i("TAG", "touched up");*/
                break;
            }
        }
        return true;
    }
}