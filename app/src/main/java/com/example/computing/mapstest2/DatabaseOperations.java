package com.example.computing.mapstest2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseOperations extends SQLiteOpenHelper
{
    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE "+TableData.TableInfo.TABLE_NAME+"(" + TableData.TableInfo.HOUSE_NAME+" TEXT," + TableData.TableInfo.POSTCODE+" TEXT);";

    public DatabaseOperations(Context context)
    {
        super(context, TableData.TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database Operations", "Table created");
    }

    @Override
    public void onCreate(SQLiteDatabase sqldb)
    {
        sqldb.execSQL(CREATE_QUERY);
    }

    public void populateDatabase(DatabaseOperations dop, String houseName, String postcode)
    {
        SQLiteDatabase sqldb = dop.getWritableDatabase();
        ContentValues cvs = new ContentValues();
        cvs.put(TableData.TableInfo.HOUSE_NAME, houseName);
        cvs.put(TableData.TableInfo.POSTCODE, postcode);

        long db = sqldb.insert(TableData.TableInfo.TABLE_NAME, null, cvs );
        Log.d("Database Operations", "One row inserted");
    }

    public Cursor getData(DatabaseOperations dop)
    {
        SQLiteDatabase sqldb = dop.getReadableDatabase();
        String[] columns = {TableData.TableInfo.HOUSE_NAME, TableData.TableInfo.POSTCODE};
        Cursor cr = sqldb.query(TableData.TableInfo.TABLE_NAME, columns, null, null, null, null, null);
        return cr;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}

