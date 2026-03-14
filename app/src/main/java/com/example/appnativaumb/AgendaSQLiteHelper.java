package com.example.appnativaumb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class AgendaSQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "AgendaDB.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_AGENDA = "agenda";
    private static final String COLUMN_ID = "id_agenda";
    private static final String COLUMN_FECHA = "fecha";
    private static final String COLUMN_ASUNTO = "asunto";
    private static final String COLUMN_ACTIVIDAD = "actividad";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_AGENDA + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_FECHA + " TEXT NOT NULL,"
            + COLUMN_ASUNTO + " TEXT NOT NULL,"
            + COLUMN_ACTIVIDAD + " TEXT NOT NULL" + ")";

    public AgendaSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_AGENDA);
        onCreate(db);
    }

    // MÉTODO AGREGAR
    public long agregarAgenda(Agenda agenda) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_FECHA, agenda.getFecha());
        values.put(COLUMN_ASUNTO, agenda.getAsunto());
        values.put(COLUMN_ACTIVIDAD, agenda.getActividad());

        long id = db.insert(TABLE_AGENDA, null, values);
        db.close();
        return id;
    }

    // MÉTODO CONSULTAR TODOS
    public List<Agenda> consultarTodasAgendas() {
        List<Agenda> listaAgendas = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_AGENDA + " ORDER BY " + COLUMN_FECHA + " DESC";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Agenda agenda = new Agenda();
                agenda.setId_agenda(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)));
                agenda.setFecha(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FECHA)));
                agenda.setAsunto(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ASUNTO)));
                agenda.setActividad(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ACTIVIDAD)));

                listaAgendas.add(agenda);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return listaAgendas;
    }

    // MÉTODO CONSULTAR POR ID
    public Agenda consultarAgendaPorId(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_AGENDA, new String[]{COLUMN_ID, COLUMN_FECHA, COLUMN_ASUNTO, COLUMN_ACTIVIDAD},
                COLUMN_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);

        Agenda agenda = null;
        if (cursor != null && cursor.moveToFirst()) {
            agenda = new Agenda();
            agenda.setId_agenda(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)));
            agenda.setFecha(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FECHA)));
            agenda.setAsunto(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ASUNTO)));
            agenda.setActividad(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ACTIVIDAD)));
            cursor.close();
        }
        db.close();
        return agenda;
    }
}