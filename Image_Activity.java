package com.danielschmidt.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import java.util.List;


public class Image_Activity extends AppCompatActivity implements PointCollectorListener{

    private PointCollector pointCollector = new PointCollector();
    private Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_);

        addTouchListener();

        pointCollector.setListener(this);

        showPrompt();



    }

    private void showPrompt(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setPositiveButton("Ok", new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setTitle("Create Your Password Sequence");
        builder.setMessage("Touch four points on the image to set the passpoint sequence. You must click the same four points in the future to gain access to your notes again.");

        AlertDialog dlg = builder.create();

        dlg.show();

    }

    private void addTouchListener() {
        ImageView image = (ImageView) findViewById(R.id.mainImage);

        image.setOnTouchListener(pointCollector);
    }

    public void pointsCollected(List<Point> points) {
       Log.d(MainActivity.DEBUGTAG,"Collected Points: " + points.size());

        db.storePoints(points);
    }
}
