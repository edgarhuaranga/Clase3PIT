package com.ehuaranga.clase3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextNombreComprador;
    EditText editTextDNIComprador;
    EditText editTextNacionalidadComprador;

    EditText editTextNombreProducto;
    EditText editTextBarcodeProducto;
    EditText editTextPrecioProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombreProducto = findViewById(R.id.edittext_nombre_producto);
        editTextBarcodeProducto = findViewById(R.id.edittext_barcode);
        editTextPrecioProducto = findViewById(R.id.edittext_precio_producto);

        editTextNombreComprador = findViewById(R.id.edittext_nombre_comprador);
        editTextDNIComprador = findViewById(R.id.edittext_dni_comprador);
        editTextNacionalidadComprador = findViewById(R.id.edittext_nacionalidad_comprador);

    }
}
