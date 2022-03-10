package com.edoz.note2go;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ubicaciones extends AppCompatActivity {

    List<ListElement> elements;
    ImageView salir, nueva;

    Toolbar toolbar;
    RecyclerView recyclerView;
    DatabaseReference database;

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference ref_user =db.getReference("Users").child(user.getUid());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicaciones);

        salir = findViewById(R.id.salirimg);
        nueva = findViewById(R.id.nuevaimg);

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(ubicaciones.this, "Sesion cerrada", Toast.LENGTH_SHORT).show();
                goMain();
            }
        });

        nueva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ubicaciones.this, editnota.class);
                startActivity(i);
            }
        });

        userUnico(); //Genera datos del usuario
        crearCardUbicacionesDB();
    }

    private void userUnico() {
        ref_user.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!snapshot.exists()){
                    ListElement uu = new ListElement(
                            user.getEmail(),
                            "Cantidad invalida",
                            "Lista invalida"
                    );

                    ref_user.setValue(uu);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void crearCardUbicacionesDB() {
        ListAdapter listAdapter;
        ArrayList<ListElement> list;
        recyclerView = findViewById(R.id.rv);

        database = FirebaseDatabase.getInstance().getReference("Users");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        listAdapter = new ListAdapter(list, this);
        recyclerView.setAdapter(listAdapter);
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    ListElement le = dataSnapshot.getValue(ListElement.class);
                    list.add(le);
                }
                listAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void goMain() {
        Intent i = new Intent(ubicaciones.this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}