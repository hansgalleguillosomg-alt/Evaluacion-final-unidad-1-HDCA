package com.example.miaplicacionbodegataskmaster;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ProductosActivity extends AppCompatActivity {

    private EditText etNombreProducto, etCantidadStock;
    private Button btnAgregarProducto;
    private RecyclerView recyclerProductos;
    private List<String> listaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        etNombreProducto = findViewById(R.id.etNombreProducto);
        etCantidadStock = findViewById(R.id.etCantidadStock);
        btnAgregarProducto = findViewById(R.id.btnAgregarProducto);
        recyclerProductos = findViewById(R.id.recyclerProductos);

        listaProductos = new ArrayList<>();
        listaProductos.add("Caja de Guantes - Stock: 120");
        listaProductos.add("Estante Metálico - Stock: 15");
        listaProductos.add("Cinta de Embalaje - Stock: 85");

        recyclerProductos.setLayoutManager(new LinearLayoutManager(this));

        btnAgregarProducto.setOnClickListener(v -> {
            String producto = etNombreProducto.getText().toString().trim();
            String stock = etCantidadStock.getText().toString().trim();

            if (!producto.isEmpty() && !stock.isEmpty()) {
                String item = producto + " - Stock: " + stock;
                listaProductos.add(item);
                etNombreProducto.setText("");
                etCantidadStock.setText("");
                Toast.makeText(this, "Producto registrado con éxito", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}