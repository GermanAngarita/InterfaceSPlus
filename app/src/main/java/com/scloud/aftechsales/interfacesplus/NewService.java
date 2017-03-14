package com.scloud.aftechsales.interfacesplus;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class NewService extends AppCompatActivity implements View.OnClickListener{

    EditText no_identificacion, placaObj, vinObj, codObj;
    Button btnSelectEquipo;

    OrdenServicio ordenservicio;
    SQLiteDatabase db;

    ImageView fotoIngreso;
    String tomarFoto = "1";
    static  final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_service);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                llamarintent();

            }
        });

        ordenservicio = new OrdenServicio(this,"OrdenServicio", null, 1);
        db = ordenservicio.getWritableDatabase();


        fotoIngreso = (ImageView)findViewById(R.id.image_appbar);

        no_identificacion = (EditText)findViewById(R.id.etextNoIdentificacion);
        placaObj = (EditText)findViewById(R.id.etextPlaca);
        vinObj = (EditText)findViewById(R.id.etextVin);
        codObj = (EditText)findViewById(R.id.etextCod);


        //Buttons
        btnSelectEquipo = (Button)findViewById(R.id.btn_select_tequipo);

        btnSelectEquipo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.btn_select_tequipo):

                //String placa, vin;
                //placa = placaObj.getText().toString();
                //vin = vinObj.getText().toString();
                //int no_id, cod;
                //no_id = Integer.parseInt(no_identificacion.getText().toString());
                //cod = Integer.parseInt(codObj.getText().toString());

                Context context = getApplicationContext();
                CharSequence text = "Listado de identificación de Equipos";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                //Intent a la lista de Equipos
                Intent toSelectTipoEquipo = new Intent(NewService.this, SelectTipoEquipoActivity.class);
                //toSelectTipoEquipo.putExtra("IdOrden", no_id);
                startActivity(toSelectTipoEquipo);



            break;
        }
    }

    private void llamarintent(){

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(takePictureIntent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            fotoIngreso.setImageBitmap(imageBitmap);
            tomarFoto = "0";
        }
    }


}
