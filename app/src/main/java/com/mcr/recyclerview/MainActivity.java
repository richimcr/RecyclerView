package com.mcr.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btActivacion;
    RecyclerView recyclerNombres;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager recyclerManager;
    List<String> nombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombres = new ArrayList<>();
        nombres.add("Ricardo");
        nombres.add("Alejandra");
        recyclerNombres = (RecyclerView) findViewById(R.id.recyclerNombres);
        recyclerManager=new LinearLayoutManager(getApplicationContext());

        mAdapter = new Adapter(nombres, R.layout.recycler_latyout, new Adapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(String nombre, int posicion) {
                Toast.makeText(getApplicationContext(),nombre+" esta en la posicion "+posicion,Toast.LENGTH_SHORT).show();
            }
        });
        recyclerNombres.setLayoutManager(recyclerManager);
        recyclerNombres.setAdapter(mAdapter);

         btActivacion = (Button) findViewById(R.id.btActivar);
         btActivacion.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(getApplicationContext(),"Hola soy un boton",Toast.LENGTH_SHORT).show();
             }
         });


    }




}
