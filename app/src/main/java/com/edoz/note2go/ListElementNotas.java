package com.edoz.note2go;

public class ListElementNotas {
    public String color;
    public String titulo;
    public String contenido;


    public ListElementNotas(String color, String titulo, String contenido) {
        this.color = color;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
