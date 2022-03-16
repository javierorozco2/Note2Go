package com.edoz.note2go.clases;

public class Notas {
    String titulo;
    String texto;
    String ubicacion;
    String fecha;
    String color;

    public Notas(String titulo, String texto, String ubicacion, String fecha, String color) {
        this.titulo = titulo;
        this.texto = texto;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.color = color;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
