package com.complete.thesisdesignproject;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBthesis{
    public static final String KEY_ROWID = "_id";
    public static final String KEY_FACULTY_NUMBER= "facultynumber";
    public static final String KEY_PASSWORD = "password";
    private static final String TAG = "DesignProject";
    private static final String DATABASE_NAME = "designproject";//usersdb
    private static final String DATABASE_TABLE =
            "insert into users(facultynumber, password) "
            + "values('201002873','dianamayores')"
            + "values('201003285', 'rovelynmarco')";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_CREATE =
            "create table users (_id integer primary key 1, "
                    + "facultynumber text not null, "
                    + "password text not null)";
    private Context context = null;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBthesis(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS users");
            onCreate(db);
        }
    }


    public void open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
    }
    public void close()
    {
        DBHelper.close();
    }

    //public long AddUser(String faculty, String password)
    //{
    //    ContentValues initialValues = new ContentValues();
     //   initialValues.put(KEY_FACULTY_NUMBER, faculty);
      //  initialValues.put(KEY_PASSWORD, password);
        //return db.insert(DATABASE_TABLE, null, initialValues);

    //}

    public boolean Login(String faculty, String password) throws SQLException
    {
        Cursor mCursor = db.rawQuery("SELECT * FROM " + DATABASE_TABLE + " WHERE facultynumber=? AND password=?", new String[]{faculty,password});
        if (mCursor != null) {
            if(mCursor.getCount() > 0)
                {
                    return true;
                }
        }
        return false;
    }



}