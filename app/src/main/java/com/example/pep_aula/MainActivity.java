package com.example.pep_aula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnInfo = (Button) findViewById(R.id.btn_infoJuego);
        Button btnSalir =(Button) findViewById(R.id.btn_salir);
        Button btn_pep =(Button)findViewById(R.id.btn_info);

        btn_pep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(v.getContext(),Main2ActivityInfoPEP.class);
                startActivityForResult(intent2,0);
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Main2Activity_Info_Juego.class);
                startActivityForResult(intent,0);
            }
        });


    }
}
