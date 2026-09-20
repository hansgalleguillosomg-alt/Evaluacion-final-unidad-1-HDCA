package com.example.miaplicacionbodegataskmaster;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerCategorias;
    private Button btnIrCategorias, btnIrProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias de los botones de navegación
        btnIrCategorias = findViewById(R.id.btnIrCategorias);
        btnIrProductos = findViewById(R.id.btnIrProductos);

        //Spinner
        spinnerCategorias = findViewById(R.id.spinnerCategorias);
        String[] categorias = {"Todas las Tareas", "Recepción de Mercadería", "Despacho", "Control de Stock"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                categorias
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategorias.setAdapter(adapter);

        // Evento para ir a Categorías
        btnIrCategorias.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoriasActivity.class);
            startActivity(intent);
        });

        // Evento para ir a Productos
        btnIrProductos.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProductosActivity.class);
            startActivity(intent);
        });
    }
}