package com.ehuaranga.clase3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ehuaranga.clase3.LocalDB.Clase3DBHelper;
import com.ehuaranga.clase3.Model.Comprador;
import com.ehuaranga.clase3.Model.Producto;

public class MainActivity extends AppCompatActivity {

    EditText editTextNombreComprador;
    EditText editTextDNIComprador;
    EditText editTextNacionalidadComprador;

    EditText editTextNombreProducto;
    EditText editTextBarcodeProducto;
    EditText editTextPrecioProducto;

    Button buttonInsertarProducto;
    Button buttonInsertarComprador;
    Clase3DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new Clase3DBHelper(this);

        editTextNombreProducto = findViewById(R.id.edittext_nombre_producto);
        editTextBarcodeProducto = findViewById(R.id.edittext_barcode);
        editTextPrecioProducto = findViewById(R.id.edittext_precio_producto);

        editTextNombreComprador = findViewById(R.id.edittext_nombre_comprador);
        editTextDNIComprador = findViewById(R.id.edittext_dni_comprador);
        editTextNacionalidadComprador = findViewById(R.id.edittext_nacionalidad_comprador);

        buttonInsertarProducto = findViewById(R.id.button_insertar_producto);
        buttonInsertarComprador = findViewById(R.id.button_insertar_comprador);

        buttonInsertarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto producto = new Producto();

                producto.setBarcode(editTextBarcodeProducto.getText().toString());
                producto.setNombre(editTextNombreProducto.getText().toString());
                producto.setPrecio(Float.parseFloat(editTextPrecioProducto.getText().toString()));

                helper.agregarProducto(producto);
            }
        });

        buttonInsertarComprador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comprador comprador = new Comprador();
                comprador.setId(editTextDNIComprador.getText().toString());
                comprador.setNombre(editTextNombreComprador.getText().toString());
                comprador.setNacionalidad(editTextNacionalidadComprador.getText().toString());

                helper.agregarUsuario(comprador);
            }
        });


    }
}
