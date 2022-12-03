package com.example.virtualphysicslab;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ApparatusSetup2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ApparatusSetup2 extends Fragment {
    public Button b1,b2,b3,b4,b5,b6;
    public ImageView iv1,iv2;
    public int i = 0;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ApparatusSetup2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ApparatusSetup2.
     */
    // TODO: Rename and change types and number of parameters
    public static ApparatusSetup2 newInstance(String param1, String param2) {
        ApparatusSetup2 fragment = new ApparatusSetup2();
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

        View view = inflater.inflate(R.layout.activity_main33, container, false);
        // Inflate the layout for this fragment



        return inflater.inflate(R.layout.activity_main33, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        b1 = (Button) view.findViewById(R.id.b1);
        b2 = (Button) view.findViewById(R.id.b2);
        b3 = (Button) view.findViewById(R.id.b3);
        b4 = (Button) view.findViewById(R.id.b4);
        b5 = (Button) view.findViewById(R.id.b5);
        b6 = (Button) view.findViewById(R.id.b6);
        iv1 = (ImageView) view.findViewById(R.id.iv1);
        iv2 = (ImageView) view.findViewById(R.id.iv2);
        iv1.setOnTouchListener(new ApparatusSetup2.ChoiceTouchListener());
        iv2.setOnDragListener(new ApparatusSetup2.ChoiceDragListener());

        b1.setTextColor(Color.parseColor("#ff0000"));
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