package com.edoz.note2go;

public class ListElement {
    public String nombre;
    public String cantidad;
    public String listas;


    public ListElement(String nombre, String cantidad, String listas) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.listas = listas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getListas() {
        return listas;
    }

    public void setListas(String listas) {
        this.listas = listas;
    }
}
