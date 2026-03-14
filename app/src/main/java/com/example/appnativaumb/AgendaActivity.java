package com.example.appnativaumb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class AgendaActivity extends AppCompatActivity {

    private EditText editTextFecha, editTextAsunto, editTextActividad;
    private Button btnAgregar, btnConsultar, btnVolver;
    private ListView listViewAgenda;
    private AgendaSQLiteHelper dbHelper;
    private ArrayAdapter<String> adapter;
    private List<String> listaMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        editTextFecha = findViewById(R.id.editTextFecha);
        editTextAsunto = findViewById(R.id.editTextAsunto);
        editTextActividad = findViewById(R.id.editTextActividad);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnConsultar = findViewById(R.id.btnConsultar);
        btnVolver = findViewById(R.id.btnVolver);
        listViewAgenda = findViewById(R.id.listViewAgenda);

        dbHelper = new AgendaSQLiteHelper(this);

        listaMostrar = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaMostrar);
        listViewAgenda.setAdapter(adapter);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fecha = editTextFecha.getText().toString().trim();
                String asunto = editTextAsunto.getText().toString().trim();
                String actividad = editTextActividad.getText().toString().trim();

                if (fecha.isEmpty() || asunto.isEmpty() || actividad.isEmpty()) {
                    Toast.makeText(AgendaActivity.this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                    return;
                }

                Agenda nuevaAgenda = new Agenda();
                nuevaAgenda.setFecha(fecha);
                nuevaAgenda.setAsunto(asunto);
                nuevaAgenda.setActividad(actividad);

                long id = dbHelper.agregarAgenda(nuevaAgenda);

                if (id != -1) {
                    Toast.makeText(AgendaActivity.this, "Agenda agregada con ID: " + id, Toast.LENGTH_SHORT).show();
                    editTextFecha.setText("");
                    editTextAsunto.setText("");
                    editTextActividad.setText("");
                    editTextFecha.requestFocus();
                    consultarAgendas();
                } else {
                    Toast.makeText(AgendaActivity.this, "Error al agregar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultarAgendas();
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgendaActivity.this, MenuPrincipalActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void consultarAgendas() {
        List<Agenda> agendas = dbHelper.consultarTodasAgendas();
        listaMostrar.clear();

        if (agendas.isEmpty()) {
            listaMostrar.add("No hay agendas registradas");
            Toast.makeText(this, "No hay datos", Toast.LENGTH_SHORT).show();
        } else {
            for (Agenda a : agendas) {
                String item = "ID: " + a.getId_agenda() +
                        " | Fecha: " + a.getFecha() +
                        "\nAsunto: " + a.getAsunto() +
                        "\nActividad: " + a.getActividad() +
                        "\n------------------------";
                listaMostrar.add(item);
            }
            Toast.makeText(this, "Mostrando " + agendas.size() + " registros", Toast.LENGTH_SHORT).show();
        }

        adapter.notifyDataSetChanged();
    }
}