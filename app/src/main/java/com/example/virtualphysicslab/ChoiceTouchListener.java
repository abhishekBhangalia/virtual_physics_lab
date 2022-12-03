package com.example.virtualphysicslab;

import android.content.ClipData;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class ChoiceTouchListener implements View.OnTouchListener {

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if ((event.getAction() == MotionEvent.ACTION_DOWN) && ((ImageView) v).getDrawable() != null) {
            ClipData data = ClipData.newPlainText(" ", " ");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, shadowBuilder, v, 0);

            return true;
        } else {
            return false;
        }
    }
    }

