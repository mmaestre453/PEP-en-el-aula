package com.example.pep_aula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2ActivityInfoPEP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_info_pep);
        final EditText usuario = (EditText) findViewById(R.id.usuario);
        final EditText contraseña =(EditText)findViewById(R.id.contraseña);
        Button btnAñadir = (Button)findViewById(R.id.btn_añadir);
        final TextView prueba = (TextView)findViewById(R.id.textoprueba);
        Button btnConsulta=(Button)findViewById(R.id.btn_verInfo);

        final String usu ="mmaestre453";
        final String contra="Moimaestre123";

        btnConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(v.getContext(),Main2ActivityConsultaEstudiante.class);
                startActivityForResult(intent3,0);
            }
        });


        btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usuario.getText().toString().equals(usu) && contraseña.getText().toString().equals(contra)){
                    prueba.setText("Ingreso Moises Maestre");
                    Intent intent2 = new Intent(v.getContext(),Main2ActivityIngresoInformacion.class);
                    startActivityForResult(intent2,0);
                }
                else {

                    Toast.makeText(getApplicationContext(),"Usuario Incorrecto",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
