package com.scloud.aftechsales.interfacesplus;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by germanangarita on 27/02/17.
 */

public class OrdenServicio extends SQLiteOpenHelper{

    String sqlCreate = "CREATE TABLE ordenservicios (id_orden INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "numero_orden TEXT, " +
            "id_equipo INTEGER, " +
            "no_identificacion INTEGER, " +
            "placa TEXT, " +
            "vin TEXT, " +
            "codigo INTEGER, " +
            "id_servicios INTEGER, " +
            "id_cliente INTEGER, " +
            "id_centro_costo INTEGER, " +
            "id_usuario INTEGER, " +
            "firma TEXT, " +
            "fecha_apertura TEXT, " +
            "fecha_cierre TEXT, " +
            "creat_at TEXT )";

    public OrdenServicio(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST ordenservicios");
        db.execSQL(sqlCreate);

    }
}
