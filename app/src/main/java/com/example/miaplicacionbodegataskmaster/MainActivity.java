package com.example.miaplicacionbodegataskmaster;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configuración del Spinner requerido por la rúbrica
        spinnerCategorias = findViewById(R.id.spinnerCategorias);

        // Opciones de categorías para la gestión de tareas de bodega
        String[] categorias = {"Todas las Tareas", "Recepción de Mercadería", "Despacho", "Control de Stock"};

        // Adaptador para poblar el Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                categorias
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategorias.setAdapter(adapter);
    }
}