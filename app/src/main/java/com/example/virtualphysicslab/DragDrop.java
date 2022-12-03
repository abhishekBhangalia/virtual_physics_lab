package com.example.virtualphysicslab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DragDrop extends AppCompatActivity {
    ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_drop);
        iv1 = (ImageView) findViewById(R.id.imageView1);
        iv2 = (ImageView) findViewById(R.id.imageView2);
        iv3 = (ImageView) findViewById(R.id.imageView3);
        iv4 = (ImageView) findViewById(R.id.imageView4);
        iv5 = (ImageView) findViewById(R.id.imageView5);
        iv6 = (ImageView) findViewById(R.id.imageView6);
        iv7 = (ImageView) findViewById(R.id.imageView7);
        iv8 = (ImageView) findViewById(R.id.imageView);
        tv = (TextView) findViewById(R.id.tv);

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
