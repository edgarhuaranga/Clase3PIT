package com.ehuaranga.clase3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ehuaranga.clase3.LocalDB.Clase3DBHelper;
import com.ehuaranga.clase3.Model.Producto;

import java.util.ArrayList;

public class SegundaPantalla extends AppCompatActivity {

    TextView textViewMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);

        textViewMensaje = findViewById(R.id.textview_mensaje);

        String mensaje = getIntent().getStringExtra("mensaje");

        textViewMensaje.setText(mensaje);

        Clase3DBHelper helper = new Clase3DBHelper(this);

        ArrayList<Producto> productos = helper.obtenerProductos();

        for(Producto producto: productos){
            textViewMensaje.append(producto.getNombre()+"\n");
        }

    }
}
