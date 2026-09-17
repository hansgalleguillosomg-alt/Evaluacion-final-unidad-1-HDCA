package com.example.miaplicacionbodegataskmaster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsuario, edtPassword;
    private RadioGroup rgTipoUsuario;
    private CheckBox chkRecordar;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Referencias a los componentes del XML
        edtUsuario = findViewById(R.id.edtUsuario);
        edtPassword = findViewById(R.id.edtPassword);
        rgTipoUsuario = findViewById(R.id.rgTipoUsuario);
        chkRecordar = findViewById(R.id.chkRecordar);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = edtUsuario.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                // Validación simple de campos vacíos
                if (usuario.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Por favor complete los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validar qué RadioButton está seleccionado
                int selectedId = rgTipoUsuario.getCheckedRadioButtonId();
                String tipoUsuario = (selectedId == R.id.rbAdmin) ? "Administrador" : "Bodeguero";

                // Mensaje de éxito y salto al MainActivity
                Toast.makeText(LoginActivity.this, "Bienvenido " + tipoUsuario, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Cierra el login para que al volver atrás no regrese aquí
            }
        });
    }
}
