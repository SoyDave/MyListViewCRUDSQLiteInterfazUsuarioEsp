package com.example.mylistviewcrudsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class SQLiteHelper extends SQLiteOpenHelper {

    //constructor
    SQLiteHelper(Context context,
                 String title,
                 SQLiteDatabase.CursorFactory factory,
                 int version){
        super(context, title, factory, version);
    }

    public void queryData (String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    //insertData
    public void insertData(String title, String console, String year, byte[] image){
        SQLiteDatabase database = getWritableDatabase();
        //query to insert record in database table
        String sql = "INSERT INTO RECORD VALUES (NULL, ?, ?, ?, ?)"; //where "RECORD" is table name in data base we will create in mainActivity

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,title);
        statement.bindString(2,console);
        statement.bindString(3,year);
        statement.bindBlob(4,image);

        statement.executeInsert();

    }

    //updateData
    public void  updateData (String title, String console, String year, byte[] image, int id){
        SQLiteDatabase database = getWritableDatabase();
        //query to update record
        String sql = "UPDATE RECORD SET title=?, console=?, year=?, image=? WHERE id=?";

        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(1,title);
        statement.bindString(2,console);
        statement.bindString(3,year);
        statement.bindBlob(4,image);
        statement.bindDouble(5,(double)id);

        statement.execute();
        database.close();

    }

    //delete Data

    public void  deleteData (int id){
        SQLiteDatabase database = getWritableDatabase();
        //query to delete redord using id
        String sql = "DELETE FROM RECORD WHERE id=?";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1,(double)id);

        statement.execute();
        database.close();
    }

    public Cursor getData (String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
