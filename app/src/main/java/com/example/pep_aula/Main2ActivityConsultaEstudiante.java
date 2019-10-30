package com.example.pep_aula;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main2ActivityConsultaEstudiante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_consulta_estudiante);
        cargar();
    }

    private void cargar(){
        BasedeDatos basedeDatos = new BasedeDatos(this, "DEMODB",null,1);
        SQLiteDatabase db = basedeDatos.getWritableDatabase();
        if(db != null){
            Cursor c = db.rawQuery("select * from Tarea",null);
            int cantidad = c.getCount();
            int i =0;
            String[]arreglo = new String [cantidad];
            if(c.moveToFirst()){
                do{
                    String linea = c.getInt(0) + " " + c.getString(1) ;
                    arreglo[i]=linea;
                    i++;

                }while(c.moveToNext());

                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arreglo);
                ListView lista =(ListView)findViewById(R.id.mostrar);
                lista.setAdapter(adapter);
            }
        }
    }
}
