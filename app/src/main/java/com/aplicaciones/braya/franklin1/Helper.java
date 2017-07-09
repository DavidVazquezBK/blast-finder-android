package com.aplicaciones.braya.franklin1;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Brayan on 09/07/2017.
 */
public class Helper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "modeloBlastFinder.mwb";
    private static final int DATABASE_VERSION = 1;

    public Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
