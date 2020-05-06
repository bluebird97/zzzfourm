package com.paulkg12.t61.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBOpenHelper extends DaoMaster.DevOpenHelper {

    public DBOpenHelper(Context context, String name) {
        super(context, name);
    }

    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }
}