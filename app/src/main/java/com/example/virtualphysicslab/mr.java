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
import android.widget.Toast;

public class mr extends AppCompatActivity {

    ImageView iv;
    SeekBar sb;
    Button bt;
    int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mr);

        iv=(ImageView) findViewById(R.id.iv);

        sb=(SeekBar) findViewById(R.id.sb);
        bt=(Button) findViewById(R.id.bt);
        Bundle bn=getIntent().getExtras();

        int ig = 0;
        if(bn!=null)
        {

            ig = bn.getInt("img");

        }
        iv.setImageResource(ig);
        if(iv.getDrawable().getConstantState().equals (iv.getContext().getDrawable(R.drawable.goldascrew1).getConstantState()))
            flag=1;
        else  if(iv.getDrawable().getConstantState().equals (iv.getContext().getDrawable(R.drawable.coppersg1).getConstantState()))
flag=2;
        else  if(iv.getDrawable().getConstantState().equals (iv.getContext().getDrawable(R.drawable.ironms1).getConstantState()))
            flag=3;
        else  if(iv.getDrawable().getConstantState().equals (iv.getContext().getDrawable(R.drawable.steelms1).getConstantState()))
            flag=4;
        else  if(iv.getDrawable().getConstantState().equals (iv.getContext().getDrawable(R.drawable.saphirems1).getConstantState()))
            flag=5;
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mr.this,InBuiltSim.class);
                if(flag==1)
                intent.putExtra("img2",R.drawable.golda);
                else if(flag==2)
                    intent.putExtra("img2",R.drawable.coppera);
                else if(flag==3)
                    intent.putExtra("img2",R.drawable.irona);
                else if(flag==4)
                    intent.putExtra("img2",R.drawable.steela);
                else if(flag==5)
                    intent.putExtra("img2",R.drawable.sapphirea);
                startActivity(intent);
                //finish();
               // Intent i = new Intent(v.getContext(),InBuiltSim.class);
                //startActivity(i);
            }
        });





if(iv.getDrawable().getConstantState().equals (iv.getContext().getDrawable(R.drawable.goldascrew1).getConstantState())) {
    sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            switch (progress) {
                case 3: {

                    iv.setImageResource(R.drawable.goldascrew2);
                    break;
                }
                case 6: {

                    iv.setImageResource(R.drawable.goldascrew3);
                    break;
                }
                case 9: {

                    iv.setImageResource(R.drawable.goldascrew4);
                    break;
                }

                case 12: {
                    iv.setImageResource(R.drawable.goldascrew5);
                    break;
                }
                case 15: {

                    iv.setImageResource(R.drawable.goldascrew6);
                    break;
                }
                case 18: {

                    iv.setImageResource(R.drawable.goldascrew7);
                    break;
                }
                case 21: {

                    iv.setImageResource(R.drawable.goldascrew8);
                    break;
                }
                case 24: {

                    iv.setImageResource(R.drawable.goldascrew9);


                    //Toast.makeText(getApplicationContext(), "Diameter of the wire is: 0.6 mm", Toast.LENGTH_SHORT).show();
                    d11 d11= new d11();
                    d11.show(getSupportFragmentManager(), "missing");
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
else if(iv.getDrawable().getConstantState().equals(iv.getContext().getDrawable(R.drawable.coppersg1).getConstantState()))
{
    sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            switch (progress) {
                case 5: {

                    iv.setImageResource(R.drawable.coppersg2);
                    break;
                }
                case 10: {

                    iv.setImageResource(R.drawable.coppersg3);
                    break;
                }
                case 15: {

                    iv.setImageResource(R.drawable.coppersg4);
                    break;
                }

                case 20: {
                    iv.setImageResource(R.drawable.coppersg5);
                    break;
                }
                case 25: {

                    iv.setImageResource(R.drawable.coppersg6);




                    //Toast.makeText(getApplicationContext(), "Diameter of the wire is: 0.8 mm", Toast.LENGTH_SHORT).show();
                    d12 d12= new d12();
                    d12.show(getSupportFragmentManager(), "missing");
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
        if(iv.getDrawable().getConstantState().equals (iv.getContext().getDrawable(R.drawable.ironms1).getConstantState())) {
            sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    switch (progress) {
                        case 8: {

                            iv.setImageResource(R.drawable.ironms2);
                            break;
                        }
                        case 16: {

                            iv.setImageResource(R.drawable.ironms3);
                            break;
                        }
                        case 24: {

                            iv.setImageResource(R.drawable.ironms4);
                           // Toast.makeText(getApplicationContext(), "Diameter of the wire is: 0.6 mm", Toast.LENGTH_SHORT).show();
                            sb.setEnabled(false);
                            d13 d13= new d13();
                            d13.show(getSupportFragmentManager(), "missing");
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
        if(iv.getDrawable().getConstantState().equals (iv.getContext().getDrawable(R.drawable.steelms1).getConstantState())) {
            sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    switch (progress) {
                        case 8: {

                            iv.setImageResource(R.drawable.steelms2);
                            break;
                        }
                        case 16: {

                            iv.setImageResource(R.drawable.steelms3);
                            break;
                        }
                        case 24: {

                            iv.setImageResource(R.drawable.steelms4);
                           // Toast.makeText(getApplicationContext(), "Diameter of the wire is: 0.6 mm", Toast.LENGTH_SHORT).show();
                            sb.setEnabled(false);
                            d15 d15= new d15();
                            d15.show(getSupportFragmentManager(), "missing");
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
        if(iv.getDrawable().getConstantState().equals (iv.getContext().getDrawable(R.drawable.saphirems1).getConstantState())) {
            sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    switch (progress) {
                        case 8: {

                            iv.setImageResource(R.drawable.saphirems2);
                            break;
                        }
                        case 16: {

                            iv.setImageResource(R.drawable.saphirems25);
                            break;
                        }
                        case 24: {

                            iv.setImageResource(R.drawable.saphirems3);
                            //Toast.makeText(getApplicationContext(), "Diameter of the wire is: 0.6 mm", Toast.LENGTH_SHORT).show();
                            sb.setEnabled(false);
                            d14 d14= new d14();
                            d14.show(getSupportFragmentManager(), "missing");
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



    }



}





