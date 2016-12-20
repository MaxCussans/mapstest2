package com.example.computing.mapstest2;

import android.provider.BaseColumns;

/**
 * Created by Computing on 20/12/2016.
 */

public class TableData
{
    public TableData()
    {

    }

    public static abstract class TableInfo implements BaseColumns
    {
        public static final String HOUSE_NAME = "House";
        public static final String POSTCODE = "Postcode";
        public static final String DATABASE_NAME = "House_Information";
        public static final String TABLE_NAME = "House_info";
    }
}
