 package com.example.virtualphysicslab;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Menu;

import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class InBuiltSim extends AppCompatActivity {
static ImageView d1;
    ImageView d2;
Button button7;
int n;
//String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_built_sim);
        d1=findViewById(R.id.h1);
       d2=findViewById(R.id.d2);
       button7=findViewById(R.id.button7);
       button7.setVisibility(View.INVISIBLE);
       button7.setEnabled(false);
       button7.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //Intent intent = new Intent(InBuiltSim.this,spherometer.class);

               // startActivity(intent);
                button7.setVisibility(View.INVISIBLE);
                button7.setEnabled(false);
                 if (d1.getDrawable().getConstantState().equals(d1.getContext().getDrawable(R.drawable.w1steel).getConstantState()))
               {n=2;

               Intent intent = new Intent(InBuiltSim.this,spherometer.class);
              intent.putExtra("num2",n);
               startActivity(intent);
                   }
               if (d1.getDrawable().getConstantState().equals(d1.getContext().getDrawable(R.drawable.w1iron).getConstantState()))
               {n=1;

                   Intent intent = new Intent(InBuiltSim.this,spherometer.class);
                   intent.putExtra("num2",n);
                   startActivity(intent);
               }
               if (d1.getDrawable().getConstantState().equals(d1.getContext().getDrawable(R.drawable.w1gold).getConstantState()))
               {n=3;

                   Intent intent = new Intent(InBuiltSim.this,spherometer.class);
                   intent.putExtra("num2",n);
                   startActivity(intent);

           }
               if (d1.getDrawable().getConstantState().equals(d1.getContext().getDrawable(R.drawable.w1sapphire).getConstantState()))
               {n=21;

                   Intent intent = new Intent(InBuiltSim.this,spherometer.class);
                   intent.putExtra("num2",n);
                   startActivity(intent);

               }

               if (d1.getDrawable().getConstantState().equals(d1.getContext().getDrawable(R.drawable.w1copper).getConstantState()))
               {n=31;

                   Intent intent = new Intent(InBuiltSim.this,spherometer.class);
                   intent.putExtra("num2",n);
                   startActivity(intent);

               }
}

       });

        d2.setOnTouchListener(new ChoiceTouchListener());

        d1.setOnDragListener(new ChoiceDragListener());
        Bundle bn2=getIntent().getExtras();
        int ig2 = 0;
        if(bn2!=null)
        {

            ig2 = bn2.getInt("img2");

        }
      if(ig2!=0)
          d1.setImageResource(ig2);


    }

   //public void openDialog(String s){
//dialog dialog=new dialog();
//dialog.tv.append(s);
//dialog.show(getSupportFragmentManager(),"dialog");

   // }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

       getMenuInflater().inflate(R.menu.menu,menu);
       return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId()){
            case R.id.i11:
                d2.setImageResource(R.drawable.steel);
                return true;

            case R.id.i12:
                d2.setImageResource(R.drawable.iron);
                return true;

            case R.id.i13:
               d2.setImageResource(R.drawable.gold);
                return true;

            case R.id.i14:
               d2.setImageResource(R.drawable.sapphire);
                return true;

            case R.id.i15:
               d2.setImageResource(R.drawable.copper);
                return true;
            case R.id.i2:
                d2.setImageResource(R.drawable.sg);
                return true;
            case R.id.i3:
                d2.setImageResource(R.drawable.ms);
                return true;
            case R.id.i4:
                d2.setImageResource(R.drawable.weight);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    private final class  ChoiceTouchListener implements View.OnTouchListener{



        @Override
        public boolean onTouch(View v, MotionEvent event) {

            if((event.getAction()==MotionEvent.ACTION_DOWN) && ((ImageView)v).getDrawable()!=null){
                ClipData data= ClipData.newPlainText(" "," ");
                View.DragShadowBuilder shadowBuilder= new View.DragShadowBuilder(v);
                v.startDrag(data,shadowBuilder,v,0);

                if (((ImageView)v).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.ms).getConstantState())&&d1.getDrawable().getConstantState().equals(d1.getContext().getDrawable(R.drawable.golda).getConstantState()))
                {
                   d1.setImageResource(R.drawable.goldascale);
                }
                if (((ImageView)v).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.ms).getConstantState())&&d1.getDrawable().getConstantState().equals(d1.getContext().getDrawable(R.drawable.coppera).getConstantState()))
                {
                    d1.setImageResource(R.drawable.meterscalecopper);
                }
                if (((ImageView)v).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.ms).getConstantState())&&d1.getDrawable().getConstantState().equals(d1.getContext().getDrawable(R.drawable.sapphirea).getConstantState()))
                {
                    d1.setImageResource(R.drawable.metercalesapphire1);
                }
                if (((ImageView)v).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.ms).getConstantState())&&d1.getDrawable().getConstantState().equals(d1.getContext().getDrawable(R.drawable.irona).getConstantState()))
                {
                    d1.setImageResource(R.drawable.meterscaleirona1);
                }
                if (((ImageView)v).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.ms).getConstantState())&&d1.getDrawable().getConstantState().equals(d1.getContext().getDrawable(R.drawable.steela).getConstantState()))
                {
                    d1.setImageResource(R.drawable.meterscalesteela1);
                }
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
            ImageView view=(ImageView) event.getLocalState();
            switch (event.getAction()){

                case DragEvent.ACTION_DROP: {

                    if (((ImageView)view).getDrawable().getConstantState().equals(((ImageView)view).getContext().getDrawable(R.drawable.steel).getConstantState()))
                    {
                        ((ImageView) v).setImageResource(R.drawable.steela);
                        Toast.makeText(getApplicationContext(),"Wire is changed to steel",Toast.LENGTH_SHORT).show();
                    }
                     else if (((ImageView)view).getDrawable().getConstantState().equals(((ImageView)view).getContext().getDrawable(R.drawable.iron).getConstantState()))
                {
                    ((ImageView) v).setImageResource(R.drawable.irona);
                    Toast.makeText(getApplicationContext(),"Wire is changed to iron",Toast.LENGTH_SHORT).show();

                }
                    else if (((ImageView)view).getDrawable().getConstantState().equals(((ImageView)view).getContext().getDrawable(R.drawable.gold).getConstantState()))
                    {
                        ((ImageView) v).setImageResource(R.drawable.golda);
                        Toast.makeText(getApplicationContext(),"Wire is changed to gold",Toast.LENGTH_SHORT).show();

                    }
                    else if (((ImageView)view).getDrawable().getConstantState().equals(((ImageView)view).getContext().getDrawable(R.drawable.sapphire).getConstantState()))
                    {
                        ((ImageView) v).setImageResource(R.drawable.sapphirea);
                        Toast.makeText(getApplicationContext(),"Wire is changed to sapphire",Toast.LENGTH_SHORT).show();

                    }

                    else if (((ImageView)view).getDrawable().getConstantState().equals(((ImageView)view).getContext().getDrawable(R.drawable.copper).getConstantState()))
                    {
                        ((ImageView) v).setImageResource(R.drawable.coppera);
                        Toast.makeText(getApplicationContext(),"Wire is changed to copper",Toast.LENGTH_SHORT).show();

                    }
                    else if (((ImageView)view).getDrawable().getConstantState().equals(((ImageView)view).getContext().getDrawable(R.drawable.sg).getConstantState()))
                    {


                        if(((ImageView)v).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.coppera).getConstantState()))
                        {
                            Intent intent = new Intent(InBuiltSim.this,mr.class);
                            intent.putExtra("img",R.drawable.coppersg1);
                            startActivity(intent);
                        }

                        else if(((ImageView)v).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.golda).getConstantState()))
                        {
                            Intent intent = new Intent(InBuiltSim.this,mr.class);
                            intent.putExtra("img",R.drawable.goldascrew1);
                            startActivity(intent);
                        }
                        else if(((ImageView)v).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.sapphirea).getConstantState()))
                        {
                            Intent intent = new Intent(InBuiltSim.this,mr.class);
                            intent.putExtra("img",R.drawable.saphirems1);
                            startActivity(intent);
                        }
                        else if(((ImageView)v).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.irona).getConstantState()))
                        {
                            Intent intent = new Intent(InBuiltSim.this,mr.class);
                            intent.putExtra("img",R.drawable.ironms1);
                            startActivity(intent);
                        }
                        else if(((ImageView)v).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.steela).getConstantState()))
                        {
                            Intent intent = new Intent(InBuiltSim.this,mr.class);
                            intent.putExtra("img",R.drawable.steelms1);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Error: wire not selected or wieghts applied",Toast.LENGTH_SHORT).show();
                        }

                    }
                    else if (((ImageView)view).getDrawable().getConstantState().equals(((ImageView)view).getContext().getDrawable(R.drawable.ms).getConstantState()))
                    {
                        if(((ImageView)v).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.meterscalecopper).getConstantState())) {
                            ((ImageView) v).setImageResource(R.drawable.copperms);
                            d5 d5= new d5();
                            d5.show(getSupportFragmentManager(), "missing");
                        }

                    else if(((ImageView)v).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.goldascale).getConstantState()))
                    {
                        ((ImageView) v).setImageResource(R.drawable.goldascale1);
                                                d1 d1= new d1();
                        d1.show(getSupportFragmentManager(), "missing");

                    }
                        else if(((ImageView)v).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.metercalesapphire1).getConstantState()))
                        {
                            ((ImageView) v).setImageResource(R.drawable.sapphirems);
                            d4 d4= new d4();
                            d4.show(getSupportFragmentManager(), "missing");
                        }
                        else if(((ImageView)v).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.meterscaleirona1).getConstantState()))
                        {
                            ((ImageView) v).setImageResource(R.drawable.ironms);
                            d3 d3= new d3();
                            d3.show(getSupportFragmentManager(), "missing");

                        }
                        else if(((ImageView)v).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.meterscalesteela1).getConstantState()))
                        {
                            ((ImageView) v).setImageResource(R.drawable.steelms);
                           // Toast.makeText(getApplicationContext(),"Length of the wire is: 0.6 metre",Toast.LENGTH_SHORT).show();
                            d2 d2= new d2();
                            d2.show(getSupportFragmentManager(), "missing");
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Error: wire not selected or wieghts applied",Toast.LENGTH_SHORT).show();
                        }

                    }
                    else if (((ImageView)view).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.weight).getConstantState()))
                    {

                         if (((ImageView)v).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.irona).getConstantState()))
                    {
                        ((ImageView) v).setImageResource(R.drawable.w1iron);
                        Toast.makeText(getApplicationContext(),"0.5 kg weight added",Toast.LENGTH_SHORT).show();
                        button7.setVisibility(View.VISIBLE);
                        button7.setEnabled(true);

                    }
                        else if (((ImageView)v).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.steela).getConstantState()))
                        {
                            ((ImageView) v).setImageResource(R.drawable.w1steel);
                            Toast.makeText(getApplicationContext(),"0.5 kg weight added",Toast.LENGTH_SHORT).show();
                            button7.setVisibility(View.VISIBLE);
                            button7.setEnabled(true);

                        }
                         else if (((ImageView)v).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.golda).getConstantState()))
                         {
                             ((ImageView) v).setImageResource(R.drawable.w1gold);
                             Toast.makeText(getApplicationContext(),"0.5 kg weight added",Toast.LENGTH_SHORT).show();
                             button7.setVisibility(View.VISIBLE);
                             button7.setEnabled(true);

                         }
                         else if (((ImageView)v).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.coppera).getConstantState()))
                         {
                             ((ImageView) v).setImageResource(R.drawable.w1copper);
                             Toast.makeText(getApplicationContext(),"0.5 kg weight added",Toast.LENGTH_SHORT).show();
                             button7.setVisibility(View.VISIBLE);
                             button7.setEnabled(true);

                         }
                         else if (((ImageView)v).getDrawable().getConstantState().equals(((ImageView)v).getContext().getDrawable(R.drawable.sapphirea).getConstantState()))
                         {
                             ((ImageView) v).setImageResource(R.drawable.w1sapphire);
                             Toast.makeText(getApplicationContext(),"0.5 kg weight added",Toast.LENGTH_SHORT).show();
                             button7.setVisibility(View.VISIBLE);
                             button7.setEnabled(true);

                         }

                        //Intent intent = new Intent(InBuiltSim.this,spherometer.class);

                       // startActivity(intent);

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

