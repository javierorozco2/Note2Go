package com.edoz.note2go;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ubicaciones extends AppCompatActivity {

    List<ListElement> elements;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicaciones);


        crearCardUbicaciones();
    }

    public void crearCardUbicaciones() {
        elements = new ArrayList<>();

        // Nombre de ubicacion, cantidad de notas, listas dentro de ella
        elements.add(new ListElement("Casa","10 Notas","Nota 1  • Nota 2 • Nota 3 • Nota 4 • Nota 5 • Nota 6 • Nota 7 • Nota 8 • Nota 9 • Nota 10 \n"));
        elements.add(new ListElement("Escuela","10 Notas","Nota 1  • Nota 2 • Nota 3 • Nota 4 • Nota 5 • Nota 6 • Nota 7 • Nota 8 • Nota 9 • Nota 10 \n"));
        elements.add(new ListElement("Trabajo","10 Notas","Nota 1  • Nota 2 • Nota 3 • Nota 4 • Nota 5 • Nota 6 • Nota 7 • Nota 8 • Nota 9 • Nota 10 \n"));

        ListAdapter listAdapter = new ListAdapter(elements,this);
        RecyclerView rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(listAdapter);
    }
}