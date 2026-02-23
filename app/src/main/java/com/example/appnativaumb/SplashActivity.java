package com.example.appnativaumb;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    // Tiempo de espera: 5 segundos (5000 milisegundos) - REQUISITO DE LA ACTIVIDAD
    private static final int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash); // Carga el layout con el logo

        // Handler para ejecutar código después de un tiempo determinado
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Intent para navegar al menú principal después del splash
                Intent intent = new Intent(SplashActivity.this, MenuPrincipalActivity.class);
                startActivity(intent); // Inicia el menú
                finish(); // Cierra el splash para que no se pueda volver atrás
            }
        }, SPLASH_TIME_OUT); // Tiempo de espera configurado: 5 segundos
    }
}