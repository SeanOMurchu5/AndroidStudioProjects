package com.example.gradetracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "dataTable";
    private static final String COL1= "Assignment_Name";
    private static final String COL2= "Weight";
    private static final String COL3= "Target_Grade";
    private static final String COL4= "Subject";
    private static final String COL5 = "Grade";
    public DatabaseHelper(@Nullable Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      String createTable = "CREATE TABLE "+ TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
              COL1 +" TEXT,"+ COL2 + " DOUBLE,"+ COL3 + " DOUBLE,"+ COL4+ " TEXT, "+ COL5+" DOUBLE)";
      db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
       onCreate(db);
    }

    public boolean addData( String item, double secondItem, double lastItem, String subject, double grade){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, item);
        contentValues.put(COL2, secondItem);
        contentValues.put(COL3, lastItem);
        contentValues.put(COL4, subject);
        contentValues.put(COL5, grade);


        Log.d(TAG, "addData: adding "+item+" to "+TABLE_NAME);
        long result = db.insert(TABLE_NAME, null,contentValues);
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;
        Cursor data = db.rawQuery(query,null);
        String table = TABLE_NAME;
        long result=0;
        String whereClause = "ID="+id;
        String[] whereArgs = new String[] { String.valueOf(id) };
        if(data != null && data.moveToFirst()) {
            do{
                int currentId = data.getInt(0);
                if(currentId == id) {

                    Log.d(TAG, "delData: deleting row id : "+id+" from "+TABLE_NAME);
                     result = db.delete(table, whereClause, null);

                }

            }while (data.moveToNext());
        }
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean addGrade(int id, double grade){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;
        double weight = 1;
        Cursor data = db.rawQuery(query,null);
        long result=0;
        if(data != null && data.moveToFirst()) {
            do{
                int currentId = data.getInt(0);
                if(currentId == id) {

                    ContentValues cv = new ContentValues();
                    cv.put(COL5, grade);
                    db.update(TABLE_NAME, cv, "ID=" + id, null);
                    Log.d(TAG, "addData: adding grade " + grade + " to row"+id+ " in " + TABLE_NAME);


                }

            }while (data.moveToNext());
        }

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }



    //returns database data
    public Cursor getData(){
      SQLiteDatabase db = this.getWritableDatabase();
      String query = "SELECT * FROM "+TABLE_NAME;
      Cursor data = db.rawQuery(query,null);
      return data;
    }

    //returns database data
    public Cursor getFirstSubjectData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String subject = "First Subject";
        String query = "SELECT * FROM "+TABLE_NAME+" WHERE Subject = '"+subject+"'";
        Cursor data = db.rawQuery(query,null);
        return data;
    }

    public Cursor getSecondSubjectData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String subject = "Second Subject";
        String query = "SELECT * FROM "+TABLE_NAME+" WHERE Subject = '"+subject+"'";
        Cursor data = db.rawQuery(query,null);
        return data;
    }

    public Cursor getThirdSubjectData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String subject = "Third Subject";
        String query = "SELECT * FROM "+TABLE_NAME+" WHERE Subject = '"+subject+"'";
        Cursor data = db.rawQuery(query,null);
        return data;
    }

    public Cursor getFourthSubjectData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String subject = "Fourth Subject";
        String query = "SELECT * FROM "+TABLE_NAME+" WHERE Subject = '"+subject+"'";
        Cursor data = db.rawQuery(query,null);
        return data;
    }

    public Cursor getFifthSubjectData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String subject = "Fifth Subject";
        String query = "SELECT * FROM "+TABLE_NAME+" WHERE Subject = '"+subject+"'";
        Cursor data = db.rawQuery(query,null);
        return data;
    }

    public Cursor getSixthSubjectData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String subject = "Sixth Subject";
        String query = "SELECT * FROM "+TABLE_NAME+" WHERE Subject = '"+subject+"'";
        Cursor data = db.rawQuery(query,null);
        return data;
    }
}
