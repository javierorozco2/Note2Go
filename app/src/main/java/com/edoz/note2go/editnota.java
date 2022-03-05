package com.edoz.note2go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class editnota extends AppCompatActivity {

    ImageButton guardar, gotoUbicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editnota);

        guardar = findViewById(R.id.guardarbtn);
        gotoUbicacion = findViewById(R.id.ubicacionbtn);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        gotoUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(editnota.this, nuevaubicacion.class);
                startActivity(i);
            }
        });
    }
}