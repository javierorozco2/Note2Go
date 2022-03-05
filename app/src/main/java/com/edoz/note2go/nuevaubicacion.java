package com.edoz.note2go;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class nuevaubicacion extends AppCompatActivity {

    List<ListElementUbicGuard> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevaubicacion);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Ubicaciones");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        crearCardUbicacionesG();
    }

    public void crearCardUbicacionesG() {
        elements = new ArrayList<>();

        // Nombre de ubicacion, cantidad de notas, listas dentro de ella
        elements.add(new ListElementUbicGuard("Casa"));
        elements.add(new ListElementUbicGuard("Escuela"));
        elements.add(new ListElementUbicGuard("Trabajo"));
        elements.add(new ListElementUbicGuard("Gym"));
        elements.add(new ListElementUbicGuard("Otro"));

        ListAdapterUbicGuard listAdapter = new ListAdapterUbicGuard(elements,this);
        RecyclerView rv = findViewById(R.id.ubicGuardadas);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(listAdapter);
    }



}