package com.ehuaranga.clase3.LocalDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ehuaranga.clase3.Model.Comprador;
import com.ehuaranga.clase3.Model.Producto;
import com.ehuaranga.clase3.Model.Registro;

import java.util.ArrayList;

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
        db.execSQL(SQL_CREATE_TABLE_USUARIOS);
        db.execSQL(SQL_CREATE_TABLE_PRODUCTOS);
        db.execSQL(SQL_CREATE_TABLE_REGISTROS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLE_PRODUCTOS);
        db.execSQL(SQL_DELETE_TABLE_USUARIOS);
        db.execSQL(SQL_DELETE_TABLE_REGISTROS);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void agregarUsuario(Comprador usuario){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_USUARIO, usuario.getId());
        values.put(COLUMN_NAME_NOMBRE_USUARIO, usuario.getNombre());
        values.put(COLUMN_NAME_NACIONALIDAD_USUARIO, usuario.getNacionalidad());
        db.insert(TABLE_USUARIOS, null, values);
        db.close();
    }

    public void eliminarUsuario(Comprador usuario){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM "+TABLE_USUARIOS+" WHERE "+COLUMN_NAME_ID_USUARIO+" = '"+usuario.getId()+"'";
        db.execSQL(query);
    }

    public Comprador getUsuarioById(String id){
        Comprador comprador = new Comprador();
        String query = "SELECT * FROM "+TABLE_USUARIOS+ " WHERE "+COLUMN_NAME_ID_USUARIO + " = '"+id+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            comprador.setId(id);
            comprador.setNombre(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_NOMBRE_USUARIO)));
            comprador.setNacionalidad(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_NACIONALIDAD_USUARIO)));
        }
        return comprador;
    }

    public void agregarProducto(Producto producto){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_BARCODE_PRODUCTOS, producto.getBarcode());
        values.put(COLUMN_NAME_NOMBRE_PRODUCTOS, producto.getNombre());
        values.put(COLUMN_NAME_PRECIO_PRODUCTOS, producto.getPrecio());
        db.insert(TABLE_PRODUCTOS, null, values);
        db.close();
    }

    public void eliminarUsuario(Producto producto){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM "+TABLE_PRODUCTOS+" WHERE "+COLUMN_NAME_BARCODE_PRODUCTOS+" = '"+producto.getBarcode()+"'";
        db.execSQL(query);
    }

    public Producto getProductoById(String id){
        Producto producto = new Producto();
        String query = "SELECT * FROM "+TABLE_PRODUCTOS+ " WHERE "+COLUMN_NAME_BARCODE_PRODUCTOS+ " = '"+id+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            producto.setBarcode(id);
            producto.setNombre(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_NOMBRE_PRODUCTOS)));
            producto.setPrecio(cursor.getFloat(cursor.getColumnIndex(COLUMN_NAME_PRECIO_PRODUCTOS)));
        }
        return producto;
    }

    public void agregarRegistro(Comprador usuario, Producto producto){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID_REGISTRO, usuario.getId());
        values.put(COLUMN_NAME_BARCODE_REGISTRO, producto.getBarcode());
        values.put(COLUMN_NAME_IDUSER_REGISTRO, usuario.getNacionalidad());
        db.insert(TABLE_REGISTROS, null, values);
        db.close();
    }


    public ArrayList<Registro> obtenerRegistros(){
        ArrayList<Registro> registros = new ArrayList<>();
        String query = "SELECT * FROM "+TABLE_REGISTROS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        while(cursor.moveToNext()){
            Registro registro = new Registro();
            registro.setId(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_ID_REGISTRO)));
            registro.setBarcodeProducto(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_BARCODE_REGISTRO)));
            registro.setIdComprador(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_IDUSER_REGISTRO)));

            registros.add(registro);
        }

        return registros;
    }

    public ArrayList<Producto> obtenerProductos(){
        ArrayList<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM "+TABLE_PRODUCTOS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        while(cursor.moveToNext()){
            Producto producto = new Producto();
            producto.setBarcode(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_BARCODE_PRODUCTOS)));
            producto.setNombre(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_NOMBRE_PRODUCTOS)));
            producto.setPrecio(Float.parseFloat(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_PRECIO_PRODUCTOS))));

            productos.add(producto);
        }

        return productos;
    }

}
