package com.ehuaranga.clase3.LocalDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.ehuaranga.clase3.LocalDB.Clase3DBContract.DBClase3.COLUMN_NAME_BARCODE_PRODUCTOS;
import static com.ehuaranga.clase3.LocalDB.Clase3DBContract.DBClase3.COLUMN_NAME_BARCODE_REGISTRO;
import static com.ehuaranga.clase3.LocalDB.Clase3DBContract.DBClase3.COLUMN_NAME_IDUSER_REGISTRO;
import static com.ehuaranga.clase3.LocalDB.Clase3DBContract.DBClase3.COLUMN_NAME_ID_REGISTRO;
import static com.ehuaranga.clase3.LocalDB.Clase3DBContract.DBClase3.COLUMN_NAME_ID_USUARIO;
import static com.ehuaranga.clase3.LocalDB.Clase3DBContract.DBClase3.COLUMN_NAME_NACIONALIDAD_USUARIO;
import static com.ehuaranga.clase3.LocalDB.Clase3DBContract.DBClase3.COLUMN_NAME_NOMBRE_PRODUCTOS;
import static com.ehuaranga.clase3.LocalDB.Clase3DBContract.DBClase3.COLUMN_NAME_NOMBRE_USUARIO;
import static com.ehuaranga.clase3.LocalDB.Clase3DBContract.DBClase3.COLUMN_NAME_PRECIO_PRODUCTOS;
import static com.ehuaranga.clase3.LocalDB.Clase3DBContract.DBClase3.TABLE_PRODUCTOS;
import static com.ehuaranga.clase3.LocalDB.Clase3DBContract.DBClase3.TABLE_REGISTROS;
import static com.ehuaranga.clase3.LocalDB.Clase3DBContract.DBClase3.TABLE_USUARIOS;

/**
 * Created by edhuar on 08.03.18.
 */

public class Clase3DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "pit2018.db";

    private static final String SQL_CREATE_TABLE_PRODUCTOS=
            "CREATE TABLE " + TABLE_PRODUCTOS+ " (" +
                    COLUMN_NAME_BARCODE_PRODUCTOS + " TEXT PRIMARY KEY," +
                    COLUMN_NAME_NOMBRE_PRODUCTOS + " TEXT," +
                    COLUMN_NAME_PRECIO_PRODUCTOS + " TEXT)";

    private static final String SQL_CREATE_TABLE_USUARIOS=
            "CREATE TABLE " + TABLE_USUARIOS+ " (" +
                    COLUMN_NAME_ID_USUARIO + " TEXT PRIMARY KEY," +
                    COLUMN_NAME_NOMBRE_USUARIO + " TEXT," +
                    COLUMN_NAME_NACIONALIDAD_USUARIO + " TEXT)";

    private static final String SQL_CREATE_TABLE_REGISTROS=
            "CREATE TABLE " + TABLE_REGISTROS+ " (" +
                    COLUMN_NAME_ID_REGISTRO + " TEXT PRIMARY KEY," +
                    COLUMN_NAME_BARCODE_REGISTRO + " TEXT," +
                    COLUMN_NAME_IDUSER_REGISTRO + " TEXT)";

    public static final String SQL_DELETE_TABLE_PRODUCTOS = "DROP TABLE IF EXISTS "+ TABLE_PRODUCTOS;
    public static final String SQL_DELETE_TABLE_USUARIOS= "DROP TABLE IF EXISTS "+ TABLE_USUARIOS;
    public static final String SQL_DELETE_TABLE_REGISTROS= "DROP TABLE IF EXISTS "+ TABLE_REGISTROS;

    public Clase3DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
