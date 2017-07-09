package com.aplicaciones.braya.franklin1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;

/**
 * Created by braya on 31/03/2017.
 */
public class ayudaBD extends SQLiteOpenHelper {

public static abstract class DatosTabla implements BaseColumns{
    public  static final String NOMBRE_TABLA = "entry";
    public  static final String COLUMNA_ID= "entryid";
    public  static final String COLUM_NAME_TITLE= "title";
    public  static final String COLUMN_NAME_SUBTITLE= "subtitle";
}

public static  final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="blastfinder.bd";

    public ayudaBD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public String[] buscar_reg(String buscar){
        String[] datos=new String[4];
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM  Material WHERE nombre.idMaterial =''"+buscar+'"';
        Cursor registros = database.rawQuery(q.null);
        if (registros.moveToFirst()){
        for(int i = 0 ; i<3;i++){
            datos[i]=registros.getString(i);
        }
        datos[4]="Encontrado";
    }else{
        datos[4]="No se encontro a "+buscar;

    } return datos;

    }
}