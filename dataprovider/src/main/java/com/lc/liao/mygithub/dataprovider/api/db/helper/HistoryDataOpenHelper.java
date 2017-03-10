package com.lc.liao.mygithub.dataprovider.api.db.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lc.liao.mygithub.dataprovider.api.db.DbContact;

/**
 * Created by liao on 2017/3/9.
 */

public class HistoryDataOpenHelper extends SQLiteOpenHelper{

    public HistoryDataOpenHelper(Context context) {
        super(context, DbContact.PUBLIC_DB, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DbContact.CREATE_TABLE + DbContact.HISTORY_ADDRESS + DbContact.SQL_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
