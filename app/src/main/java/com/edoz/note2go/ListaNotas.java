package com.edoz.note2go;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListaNotas extends AppCompatActivity {

    List<ListElementNotas> elements;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Notas");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        init();

    }

    public void init(){
        elements = new ArrayList<>();
        elements.add(new ListElementNotas("#434344", "Nota 1", "cmewfwmepfweowfweweff" ));
        elements.add(new ListElementNotas("#535833", "Nota 2", "cmewfwmepfweowfweweff" ));
        elements.add(new ListElementNotas("#328823", "Nota 3", "cmewfwmepfweowfweweff" ));
        elements.add(new ListElementNotas("#535345", "Nota 4", "cmewfwmepfweowfweweff" ));
        elements.add(new ListElementNotas("#987988", "Nota 5", "cmewfwmepfweowfweweff" ));
        elements.add(new ListElementNotas("#454344", "Nota 6", "cmewfwmepfweowfweweff" ));
        elements.add(new ListElementNotas("#434667", "Nota 7", "cmewfwmepfweowfweweff" ));
        elements.add(new ListElementNotas("#643342", "Nota 8", "cmewfwmepfweowfweweff" ));
        elements.add(new ListElementNotas("#886676", "Nota 9", "cmewfwmepfweowfweweff" ));
        elements.add(new ListElementNotas("#766765", "Nota 10", "cmewfwmepfweowfweweff" ));
        elements.add(new ListElementNotas("#656775", "Nota 11", "cmewfwmepfweowfweweff" ));


        ListAdapterNotas listAdapterNotas = new ListAdapterNotas(elements,this);
        RecyclerView recyclerView = findViewById(R.id.recycleNotas);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapterNotas);
    }
}