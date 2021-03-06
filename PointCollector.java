package com.danielschmidt.myapplication;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import java.util.ArrayList;
import java.util.List;


public class PointCollector implements OnTouchListener {

    private PointCollectorListener listener;
    private List<Point> points = new ArrayList<Point>();
    private static final int NUM_POINTS = 4;


    public boolean onTouch(View v, MotionEvent event) {

        int x = Math.round(event.getX());

        int y = Math.round(event.getY());

        points.add(new Point(x, y));

        if (points.size() == NUM_POINTS){
            if(listener != null){
                    listener.pointsCollected(points);
            }
        }

        return false;
    }


    public void setListener(PointCollectorListener listener) {
        this.listener = listener;
    }
}

