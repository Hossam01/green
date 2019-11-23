package com.example.el3afreet.green;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DateBaseHistory extends SQLiteOpenHelper {
    public static final String name="history.db";
    public static final int version=1;
    Context context;
    public DateBaseHistory(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if NOT EXISTS history(id INTEGER primary key,value TEXT,date TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("Drop table if EXISTS history");
        onCreate(db);
    }
    public void insert(String value,String date)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("value", value);
        cv.put("date", date);
        db.insert("history", null, cv);
    }
    public ArrayList select()
    {
        ArrayList arrayList=new ArrayList();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from history",null);
        res.moveToFirst();
        while (res.isAfterLast()==false) {
            Listitem item = new Listitem();
            //Get the information form the cursor and initialize the item object
            item.setValue(res.getString(res.getColumnIndex("value")));
            item.setDate(res.getString(res.getColumnIndex("date")));

            arrayList.add(item);
            res.moveToNext();
        }
        return arrayList;
    }
}
