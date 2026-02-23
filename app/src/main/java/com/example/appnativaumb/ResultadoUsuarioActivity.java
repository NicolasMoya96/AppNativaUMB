package com.example.appnativaumb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultadoUsuarioActivity extends AppCompatActivity {

    private TextView textViewNombre, textViewApellido, textViewEdad;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_usuario);

        textViewNombre = findViewById(R.id.textViewNombre);
        textViewApellido = findViewById(R.id.textViewApellido);
        textViewEdad = findViewById(R.id.textViewEdad);
        btnVolver = findViewById(R.id.btnVolver);

        String nombre = getIntent().getStringExtra("nombre");
        String apellido = getIntent().getStringExtra("apellido");
        String edad = getIntent().getStringExtra("edad");

        textViewNombre.setText("👤 Nombre: " + nombre);
        textViewApellido.setText("👥 Apellido: " + apellido);
        textViewEdad.setText("🎂 Edad: " + edad);

        // Botón para volver al menú principal
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultadoUsuarioActivity.this, MenuPrincipalActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}