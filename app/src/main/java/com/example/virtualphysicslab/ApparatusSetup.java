package com.example.virtualphysicslab;



import androidx.appcompat.app.AppCompatActivity;


import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class ApparatusSetup extends AppCompatActivity {
    ImageView iv1,iv2,iv3;
    SeekBar sb;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apparatus_setup);

        iv1=(ImageView) findViewById(R.id.iv1);
        iv2=(ImageView) findViewById(R.id.iv2);
        iv3=(ImageView) findViewById(R.id.iv3);
         sb=(SeekBar) findViewById(R.id.sb);
         bt=(Button) findViewById(R.id.bt);
         sb.setVisibility(View.INVISIBLE);
         bt.setVisibility(View.INVISIBLE);

         bt.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 iv3.setImageResource(R.drawable.m10);
             }
         });
        

        iv1.setOnTouchListener(new ChoiceTouchListener());
        iv2.setOnTouchListener(new ChoiceTouchListener());
        iv3.setOnDragListener(new ChoiceDragListener());



        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch(progress)
                {
                    case 3:
                    {

                        iv3.setImageResource(R.drawable.m1);
                        break;
                    }
                    case 6: {

                        iv3.setImageResource(R.drawable.m2);
                        break;
                    }
                    case 9:{

                        iv3.setImageResource(R.drawable.m3);
                        break;
                    }

                    case 12:
                    {
                        iv3.setImageResource(R.drawable.m4);
                        break;
                    }
                    case 15: {

                        iv3.setImageResource(R.drawable.m5);
                        break;
                    }
                    case 18: {

                        iv3.setImageResource(R.drawable.m6);
                        break;
                    }
                    case 21: {

                        iv3.setImageResource(R.drawable.m7);
                        break;
                    }
                    case 24: {

                        iv3.setImageResource(R.drawable.m8);
                        break;
                    }
                    case 27:{


                        iv3.setImageResource(R.drawable.m9);
                        Toast.makeText(getApplicationContext(),"Diameter of the wire is: 0.2 mm",Toast.LENGTH_SHORT).show();
                        bt.setVisibility(View.VISIBLE);
                        sb.setEnabled(false);

                        break;
                    }


                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




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
                    ImageView view=(ImageView) event.getLocalState();
                    if (((ImageView)view)==iv1) {
                        ((ImageView) v).setImageDrawable(getResources().getDrawable(R.drawable.m1));
                        sb.setVisibility(View.VISIBLE);
                    } else if (((ImageView)view)==iv2){
                        ((ImageView) v).setImageDrawable(getResources().getDrawable(R.drawable.ss2));
                        Toast.makeText(getApplicationContext(), "Length of the wire is : 1 m",Toast.LENGTH_SHORT).show();

                    }



                    ((ImageView)view).setImageDrawable(null);
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