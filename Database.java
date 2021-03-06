package com.danielschmidt.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Point;

import java.util.List;

public class Database extends SQLiteOpenHelper{

    private static final String POINTS_TABLE = "POINTS";
    private static final String COL_ID = "ID";
    private static final String COL_X = "X";
    private static final String COL_Y = "Y";

    public Database(Context context) {
        super(context, "message.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = String.format("create table %s (I%s INTEGER PRIMARY KEY, %s INTEGER NOT NULL, %s INTEGER NOT NULL)",
                POINTS_TABLE, COL_ID,COL_X,COL_Y);

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void storePoints(List<Point> points){
        SQLiteDatabase db = getWritableDatabase();

        db.delete(POINTS_TABLE, null, null);

        int i = 0;

        for(Point point: points){
            ContentValues values = new ContentValues();


            values.put(COL_ID, i);
            values.put(COL_X, point.x);
            values.put(COL_Y, point.y);

            db.insert(POINTS_TABLE, null, values);

            i++;

        }

        db.close();
    }

}
