package com.ehuaranga.clase3.Model;

/**
 * Created by edhuar on 08.03.18.
 */

public class Registro {
    String id;
    String idComprador;
    String barcodeProducto;

    public Registro() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(String idComprador) {
        this.idComprador = idComprador;
    }

    public String getBarcodeProducto() {
        return barcodeProducto;
    }

    public void setBarcodeProducto(String barcodeProducto) {
        this.barcodeProducto = barcodeProducto;
    }
}
