package com.example.borrar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvhello;
    private Button btnCambiar;
    private EditText edNombre;
    SharedPreferences preferencia;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvhello = findViewById(R.id.tvact1);
        btnCambiar = findViewById(R.id.btnAct1);
        edNombre = findViewById(R.id.editTextAct1);

        //CARGAMOS EL TEXTO
        preferencia = getPreferences(Context.MODE_PRIVATE);
        String name = preferencia.getString(getString(R.string.nombrePreferencia),getString(R.string.defaultNombre));
        tvhello.setText(name);




        /*Intent intent = getIntent();
        tvhello.setText(intent.getStringExtra(Values.CLAVE_INTENT));*/
        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra(Values.CLAVE_INTENT,edNombre.getText().toString());
                startActivityForResult(intent,Values.REQ_ACT_2);

            }
        });





    }

    @Override
    public  void  onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == Values.REQ_ACT_2) {
            if(resultCode == RESULT_OK){
                tvhello.setText(data.getStringExtra(Values.CLAVE_INTENT));
                //GUARDAMOS EL TEXTO
                SharedPreferences.Editor editor = preferencia.edit();
                editor.putString(getString(R.string.nombrePreferencia),tvhello.getText().toString());
                editor.apply();
            }

        }
    }





}