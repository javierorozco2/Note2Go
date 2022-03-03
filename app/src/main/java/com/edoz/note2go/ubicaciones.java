package com.edoz.note2go;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class ubicaciones extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicaciones);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //Colocar el toolbar
        getSupportActionBar().setTitle("Mis notas"); //Titulo del toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}