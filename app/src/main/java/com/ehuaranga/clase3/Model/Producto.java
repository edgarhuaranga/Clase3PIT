package com.ehuaranga.clase3.Model;

/**
 * Created by edhuar on 08.03.18.
 */

public class Producto {
    String barcode;
    String nombre;
    float precio;

    public Producto(){

    }

    public Producto(String barcode, String nombre, float precio) {
        this.barcode = barcode;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "barcode='" + barcode + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
