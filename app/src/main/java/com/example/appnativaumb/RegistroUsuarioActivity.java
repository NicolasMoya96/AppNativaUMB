package com.example.appnativaumb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistroUsuarioActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextApellido, editTextEdad;
    private Button btnEnviar, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextEdad = findViewById(R.id.editTextEdad);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnVolver = findViewById(R.id.btnVolver);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editTextNombre.getText().toString();
                String apellido = editTextApellido.getText().toString();
                String edad = editTextEdad.getText().toString();

                if (nombre.isEmpty() || apellido.isEmpty() || edad.isEmpty()) {
                    Toast.makeText(RegistroUsuarioActivity.this,
                            "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(RegistroUsuarioActivity.this, ResultadoUsuarioActivity.class);
                    intent.putExtra("nombre", nombre);
                    intent.putExtra("apellido", apellido);
                    intent.putExtra("edad", edad);
                    startActivity(intent);
                }
            }
        });

        // Botón para volver al menú principal
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistroUsuarioActivity.this, MenuPrincipalActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}