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

public class MainActivity2 extends AppCompatActivity {
    private TextView tvCargar;
    private Button btnCambiar;
    private EditText edNombre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvCargar = findViewById(R.id.tvAct2);
        btnCambiar = findViewById(R.id.btnAct2);
        edNombre = findViewById(R.id.editTextTextAct2);

        Intent intent = getIntent();
        tvCargar.setText(intent.getStringExtra(Values.CLAVE_INTENT));

        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(Values.CLAVE_INTENT,edNombre.getText().toString());
                setResult(RESULT_OK,intent);


                finish();


            }
        });{

        }


    }


}