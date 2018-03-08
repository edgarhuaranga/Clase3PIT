package com.ehuaranga.clase3.LocalDB;

import android.provider.BaseColumns;

/**
 * Created by edhuar on 08.03.18.
 */

public class Clase3DBContract {

    public Clase3DBContract() {
    }

    public static class DBClase3 implements BaseColumns{
        public static final String TABLE_PRODUCTOS = "productos";
        public static final String TABLE_USUARIOS = "usuarios";
        public static final String TABLE_REGISTROS = "registro";

        public static final String COLUMN_NAME_BARCODE_PRODUCTOS = "barcode_producto";
        public static final String COLUMN_NAME_NOMBRE_PRODUCTOS = "nombre_producto";
        public static final String COLUMN_NAME_PRECIO_PRODUCTOS = "precio_producto";

        public static final String COLUMN_NAME_ID_USUARIO = "id_usuario";
        public static final String COLUMN_NAME_NOMBRE_USUARIO = "nombre_usuario";
        public static final String COLUMN_NAME_NACIONALIDAD_USUARIO = "nacionalidad_usuario";

        public static final String COLUMN_NAME_ID_REGISTRO = "id_registro";
        public static final String COLUMN_NAME_BARCODE_REGISTRO = "barcode_registro";
        public static final String COLUMN_NAME_IDUSER_REGISTRO = "iduser_registro";

    }
}
