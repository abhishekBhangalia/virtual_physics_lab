package com.example.virtualphysicslab;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.wajahatkarim3.easyflipview.EasyFlipView;

import static com.example.virtualphysicslab.R.drawable.z16;

public class spherometer extends AppCompatActivity {
    Button button,button2;
    ImageView iv,iv2,iv3;
    int y=-30;
    int z=30;
    //int pos,pos2;
    int ig = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spherometer);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        iv=findViewById(R.id.imageView);
        iv2=findViewById(R.id.imageView2);
        iv3=findViewById(R.id.imageView13);
        EasyFlipView mYourFlipView = (EasyFlipView) findViewById(R.id.easyFlipView);
        Bundle bn=getIntent().getExtras();
        if(bn!=null)
        {

            ig= bn.getInt("num2");

        }
        if(ig==2)
            iv3.setImageResource(R.drawable.z12);
        if(ig==3)
            iv3.setImageResource(R.drawable.z10);
        if(ig==31)
            iv3.setImageResource(R.drawable.z10);
if(ig==1)

    iv3.setImageResource(R.drawable.z14);
        if(ig==21)

            iv3.setImageResource(R.drawable.z12);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mYourFlipView.setToHorizontalType();
                mYourFlipView.setFlipTypeFromLeft();
                mYourFlipView.flipTheView();
                mYourFlipView.setFlipDuration(2000);


                ObjectAnimator animatorY=ObjectAnimator.ofFloat(iv,"translationY",y);



                animatorY.setDuration(2000);



                animatorY.start();
                ObjectAnimator animatorY2=ObjectAnimator.ofFloat(iv2,"translationY",y);


                animatorY2.setDuration(2000);



                animatorY2.start();
              y=y-30;
                if(y==-60&&ig==2)

                    iv3.setImageResource(R.drawable.z14);
                if(y==-60&&ig==21)

                    iv3.setImageResource(R.drawable.z14);
                if(y==-60&&ig==3) {
                    iv3.setImageResource(R.drawable.z12);
                }
                if(y==-90&&ig==3) {
                    iv3.setImageResource(R.drawable.z14);
                }

                if(y==-60&&ig==31) {
                    iv3.setImageResource(R.drawable.z12);
                }
                if(y==-90&&ig==31) {
                    iv3.setImageResource(R.drawable.z14);
                }


                    iv3.setImageResource(R.drawable.z14);
                if(y==-60&&ig==1)
                {
                    iv3.setImageResource(R.drawable.z16);
                button2.setEnabled(false);
                button.setEnabled(false);
                d9 d9=new d9();
                d9.show(getSupportFragmentManager(),"missing");
                }


if(ig==2&&y==-90){
    iv3.setImageResource(R.drawable.z16);
    button.setEnabled(false);
    button2.setEnabled(false);
    d6 d6= new d6();
    d6.show(getSupportFragmentManager(), "missing");
}
                if(ig==21&&y==-90){
                    iv3.setImageResource(R.drawable.z16);
                    button.setEnabled(false);
                    button2.setEnabled(false);
                    d10 d10= new d10();
                    d10.show(getSupportFragmentManager(), "missing");
                }
                if(y==-120&&ig==3){
                    iv3.setImageResource(R.drawable.z16);
                    button.setEnabled(false);
                    button2.setEnabled(false);
                    d8 d8= new d8();
                    d8.show(getSupportFragmentManager(), "missing");
                }
                if(ig==31&&y==-120){
                    iv3.setImageResource(R.drawable.z16);
                    button.setEnabled(false);
                    button2.setEnabled(false);
                    d7 d7= new d7();
                    d7.show(getSupportFragmentManager(), "missing");
                }

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mYourFlipView.setToHorizontalType();
                mYourFlipView.setFlipTypeFromRight();
                mYourFlipView.flipTheView();
                mYourFlipView.setFlipDuration(2000);
               z=y+30;
               // pos2=iv.getTop();
              //  z=pos+100;

                ObjectAnimator animatorY=ObjectAnimator.ofFloat(iv,"translationY",z);



                animatorY.setDuration(2000);



                animatorY.start();
                ObjectAnimator animatorY2=ObjectAnimator.ofFloat(iv2,"translationY",z);



                animatorY2.setDuration(2000);



                animatorY2.start();
                y=y+30;

                if(y==-30&&ig==2)

                    iv3.setImageResource(R.drawable.z12);
                if(y==60&&ig==2)

                    iv3.setImageResource(R.drawable.z8);
                if(y==30&&ig==2)
                    iv3.setImageResource(R.drawable.z10);

                    if(y==-30&&ig==21)

                        iv3.setImageResource(R.drawable.z12);
                if(y==60&&ig==21)

                    iv3.setImageResource(R.drawable.z8);
                if(y==30&&ig==21)

                    iv3.setImageResource(R.drawable.z10);
                if(y==0&&ig==1)

                    iv3.setImageResource(R.drawable.z12);
                if(y==0&&ig==3)

                    iv3.setImageResource(R.drawable.z8);

                if(y==-30&&ig==3)

                    iv3.setImageResource(R.drawable.z10);
                if(y==-60&&ig==3)

                    iv3.setImageResource(R.drawable.z12);
                if(y==0&&ig==31)

                    iv3.setImageResource(R.drawable.z8);

                if(y==-30&&ig==31)

                    iv3.setImageResource(R.drawable.z10);
                if(y==-60&&ig==31)

                    iv3.setImageResource(R.drawable.z12);
            }

        });


    }
}