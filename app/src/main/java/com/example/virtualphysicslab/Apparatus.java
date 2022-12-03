package com.example.virtualphysicslab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import androidx.core.content.res.ResourcesCompat;

import android.content.ClipData;


import android.graphics.Color;

import android.view.DragEvent;
import android.view.MotionEvent;

import android.widget.Button;
import android.widget.ImageView;



public class Apparatus extends Fragment {

    Button b1,b2,b3,b4,b5,b6;
    ImageView iv1,iv2;
    int i = 0;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public Apparatus() {

    }


    public static Apparatus newInstance(String param1, String param2) {
        Apparatus fragment = new Apparatus();
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

        View v= inflater.inflate(R.layout.fragment_apparatus, container, false);
        b1 = v.findViewById(R.id.b1);
        b2 = v.findViewById(R.id.b2);
        b3 = v.findViewById(R.id.b3);
        b4 = v.findViewById(R.id.b4);
        b5 = v.findViewById(R.id.b5);
        b6 = v.findViewById(R.id.b6);
        iv1 = v.findViewById(R.id.iv1);
        iv2 = v.findViewById(R.id.iv2);
        iv1.setOnTouchListener(new ChoiceTouchListener());
        iv2.setOnDragListener(new ChoiceDragListener());

        b1.setTextColor(Color.parseColor("#ff0000"));
return v;
    }

    private final class  ChoiceTouchListener implements View.OnTouchListener{



        @Override
        public boolean onTouch(View v, MotionEvent event) {

            if((event.getAction()==MotionEvent.ACTION_DOWN) && ((ImageView)v).getDrawable()!=null){
                ClipData data= ClipData.newPlainText(" "," ");
                View.DragShadowBuilder shadowBuilder= new View.DragShadowBuilder(v);
                v.startDrag(data,shadowBuilder,v,0);

                return true;
            }
            else
            {
                return false;
            }
        }
    }

    private  class ChoiceDragListener implements View.OnDragListener{

        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()){

                case DragEvent.ACTION_DROP: {
                    //ImageView view=(ImageView) event.getLocalState();

                    i++;
                    if ( i == 1) {
                        ((ImageView) v).setImageDrawable(getResources().getDrawable(R.drawable.one));
                        b2.setTextColor(Color.parseColor("#ff0000"));
                        b1.setTextColor(Color.parseColor("#000000"));
                        iv1.setImageResource(R.drawable.wire);
                    } else if ( i==2) {
                        ((ImageView) v).setImageDrawable(getResources().getDrawable(R.drawable.two));
                        b3.setTextColor(Color.parseColor("#ff0000"));
                        b2.setTextColor(Color.parseColor("#000000"));
                        iv1.setImageResource(R.drawable.s_3);
                    } else if ( i==3) {
                        ((ImageView) v).setImageDrawable(getResources().getDrawable(R.drawable.three));
                        b4.setTextColor(Color.parseColor("#ff0000"));
                        b3.setTextColor(Color.parseColor("#000000"));
                        iv1.setImageResource(R.drawable.s_4);
                    } else if ( i==4) {
                        ((ImageView) v).setImageDrawable(getResources().getDrawable(R.drawable.four));
                        b5.setTextColor(Color.parseColor("#ff0000"));
                        b4.setTextColor(Color.parseColor("#000000"));
                        iv1.setImageResource(R.drawable.s_5);
                    } else if ( i==5) {
                        ((ImageView) v).setImageDrawable(getResources().getDrawable(R.drawable.five));
                        b6.setTextColor(Color.parseColor("#ff0000"));
                        b5.setTextColor(Color.parseColor("#000000"));
                        iv1.setImageResource(R.drawable.weight);
                    } else if ( i==6) {
                        i=0;
                        ((ImageView) v).setImageDrawable(getResources().getDrawable(R.drawable.six));
                        b1.setTextColor(Color.parseColor("#ff0000"));
                        b6.setTextColor(Color.parseColor("#000000"));
                        iv1.setImageResource(R.drawable.one);
                    }
                    break;
                }
                case DragEvent.ACTION_DRAG_ENDED: {
                    break;
                }

            }

            return true;
        }
    }
}