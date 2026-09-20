package com.example.miaplicacionbodegataskmaster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CategoriasActivity extends AppCompatActivity {

    private ListView listViewCategorias;
    private Button btnVolver;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> listaCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        // Vincular elementos de la UI
        listViewCategorias = findViewById(R.id.listViewCategorias);
        btnVolver = findViewById(R.id.btnVolver);

        // Inicializar la lista de categorías de ejemplo
        listaCategorias = new ArrayList<>();
        listaCategorias.add("Bebidas y Refrescos");
        listaCategorias.add("Abarrotes y Despensa");
        listaCategorias.add("Lácteos y Refrigerados");
        listaCategorias.add("Limpieza y Hogar");
        listaCategorias.add("Snacks y Golosinas");

        // Configurar el adaptador para el ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaCategorias);
        listViewCategorias.setAdapter(adapter);

        // Evento al hacer clic en una categoría
        listViewCategorias.setOnItemClickListener((parent, view, position, id) -> {
            String categoriaSeleccionada = listaCategorias.get(position);
            Toast.makeText(CategoriasActivity.this, "Seleccionado: " + categoriaSeleccionada, Toast.LENGTH_SHORT).show();

            // Aquí puedes abrir la pantalla de productos pasando la categoría si lo deseas
            Intent intent = new Intent(CategoriasActivity.this, ProductosActivity.class);
            intent.putExtra("CATEGORIA", categoriaSeleccionada);
            startActivity(intent);
        });

        // Botón para volver a la pantalla anterior
        btnVolver.setOnClickListener(v -> finish());
    }
}