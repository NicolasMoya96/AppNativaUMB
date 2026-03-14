package com.example.appnativaumb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MenuPrincipalActivity extends AppCompatActivity {

    private Button btnPaginaUMB, btnBuscadorWeb, btnMensajes, btnAgenda, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnPaginaUMB = findViewById(R.id.btnPaginaUMB);
        btnBuscadorWeb = findViewById(R.id.btnBuscadorWeb);
        btnMensajes = findViewById(R.id.btnMensajes);
        btnAgenda = findViewById(R.id.btnAgenda);
        btnSalir = findViewById(R.id.btnSalir);

        btnPaginaUMB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipalActivity.this, PaginaUMBActivity.class);
                startActivity(intent);
            }
        });

        btnBuscadorWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipalActivity.this, BusquedaWebActivity.class);
                startActivity(intent);
            }
        });

        btnMensajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipalActivity.this, RegistroUsuarioActivity.class);
                startActivity(intent);
            }
        });

        // NUEVO: Botón AGENDA
        btnAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipalActivity.this, AgendaActivity.class);
                startActivity(intent);
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                System.exit(0);
            }
        });
    }
}