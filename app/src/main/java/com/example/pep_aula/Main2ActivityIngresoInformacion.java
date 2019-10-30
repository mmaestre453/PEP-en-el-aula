package com.example.pep_aula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2ActivityIngresoInformacion extends AppCompatActivity {

    private ArrayList<String> telefonos;
    private ArrayAdapter<String> adaptador1;
    private ListView lv1;
    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_ingreso_informacion);

        telefonos=new ArrayList<String>();
        telefonos.add("¿Por que es importante el PEP para una intitucion? : Plan o proyecto académico, que ha sido entendido en diversos momentos como un manuscrito que recopila algunos de los aspectos que orientan el trasegar académico del programa, noción por demás instrumental, del ser y que hacer de lo curricular en nuestra Alma Máter.");
        telefonos.add("¿A que personas va dirigido el programa de ingenieria de sistemas? : El programa de Ingeniería de Sistemas está dirigido a personas que disfruten y les apasione la tecnología. La Universidad Autónoma de Bucaramanga (UNAB) integra en esta carrera saberes de las Ciencias de la Computación, Ingeniería del Software, Tecnologías de Información y Comunicaciones (TIC), y Teoría Sistemática y de Organizaciones, con el fin de atender necesidades organizacionales que repercuten en la competitividad de las empresas.");
        telefonos.add("¿Creditos de la ingenieria de sistemas durante los 5 años : 168 creditos!!!");
        adaptador1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,telefonos);
        lv1=(ListView)findViewById(R.id.listView);
        lv1.setAdapter(adaptador1);

        et1=(EditText)findViewById(R.id.editText);

        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int posicion=i;

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Main2ActivityIngresoInformacion.this);
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿ Elimina este teléfono ?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        telefonos.remove(posicion);
                        adaptador1.notifyDataSetChanged();
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
                dialogo1.show();

                return false;
            }
        });
    }

    public void agregar(View v) {
        String valor = et1.getText().toString();
        telefonos.add(et1.getText().toString());
        BasedeDatos basedeDatos = new BasedeDatos(this, "DEMODB",null,1);
        SQLiteDatabase db = basedeDatos.getWritableDatabase();
        if (db != null){
            ContentValues registroNuevo = new ContentValues();
            registroNuevo.put("descripcion",valor);
            db.insert("Tarea",null,registroNuevo);
            Toast.makeText(this,"Datos Almacenados!!",Toast.LENGTH_SHORT).show();
        }
        adaptador1.notifyDataSetChanged();
        et1.setText("");
    }



}

