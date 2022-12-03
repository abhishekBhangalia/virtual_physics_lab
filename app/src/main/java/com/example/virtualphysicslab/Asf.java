package com.example.virtualphysicslab;

import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Asf#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Asf extends Fragment {

    ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8;
    TextView tv;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Asf() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Asf.
     */
    // TODO: Rename and change types and number of parameters
    public static Asf newInstance(String param1, String param2) {
        Asf fragment = new Asf();
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
        public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_asf, container, false);
        }

        @Override
        public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            iv1 = (ImageView) view.findViewById(R.id.imageView1);
            iv2 = (ImageView) view.findViewById(R.id.imageView2);
            iv3 = (ImageView) view.findViewById(R.id.imageView3);
            iv4 = (ImageView) view.findViewById(R.id.imageView4);
            iv5 = (ImageView) view.findViewById(R.id.imageView5);
            iv6 = (ImageView) view.findViewById(R.id.imageView6);
            iv7 = (ImageView) view.findViewById(R.id.imageView7);
            iv8 = (ImageView) view.findViewById(R.id.imageView);
            tv = (TextView) view.findViewById(R.id.tv);

             class ChoiceDragListener implements View.OnDragListener {

                @Override
                public boolean onDrag(View v, DragEvent event) {
                    switch (event.getAction()) {
                        case DragEvent.ACTION_DRAG_STARTED: {
                            break;
                        }
                        case DragEvent.ACTION_DRAG_ENTERED: {
                            break;
                        }
                        case DragEvent.ACTION_DRAG_EXITED: {
                            break;
                        }
                        case DragEvent.ACTION_DROP: {
                            ImageView view = (ImageView) event.getLocalState();
                            if (((ImageView) view) == iv1) {
                                ((ImageView) v).setImageDrawable(getResources().getDrawable(R.drawable.s1));
                            } else if (((ImageView) view) == iv2) {
                                ((ImageView) v).setImageDrawable(getResources().getDrawable(R.drawable.s8));
                            } else if (((ImageView) view) == iv3) {
                                ((ImageView) v).setImageDrawable(getResources().getDrawable(R.drawable.s3));
                            } else if (((ImageView) view) == iv4) {
                                ((ImageView) v).setImageDrawable(getResources().getDrawable(R.drawable.s5));
                            } else if (((ImageView) view) == iv5) {
                                ((ImageView) v).setImageDrawable(getResources().getDrawable(R.drawable.s6));
                            } else if (((ImageView) view) == iv6) {
                                ((ImageView) v).setImageDrawable(getResources().getDrawable(R.drawable.a1));
                            } else if (((ImageView) view) == iv7) {
                                ((ImageView) v).setImageDrawable(getResources().getDrawable(R.drawable.a2));
                                tv.setVisibility(View.INVISIBLE);
                            }


                            ((ImageView) view).setImageDrawable(null);
                            break;
                        }
                        case DragEvent.ACTION_DRAG_ENDED: {
                            break;
                        }

                    }

                    return true;
                }
            }



            iv1.setOnTouchListener(new ChoiceTouchListener());
            iv2.setOnTouchListener(new ChoiceTouchListener());
            iv3.setOnTouchListener(new ChoiceTouchListener());
            iv4.setOnTouchListener(new ChoiceTouchListener());
            iv5.setOnTouchListener(new ChoiceTouchListener());
            iv6.setOnTouchListener(new ChoiceTouchListener());
            iv7.setOnTouchListener(new ChoiceTouchListener());
            iv8.setOnDragListener(new ChoiceDragListener());





        }

}