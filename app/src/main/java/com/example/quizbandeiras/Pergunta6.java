package com.example.quizbandeiras;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Pergunta6 extends AppCompatActivity {

    RadioGroup RdgPergunta;
    RadioButton rdbErrado1, rdbCorreto, rdbErrado2, rdbErrado3;
    Button btnResponder6;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta6);

        rdbErrado1 = findViewById(R.id.rdbErrado16);
        rdbCorreto = findViewById(R.id.rdbCorreto6);
        rdbErrado2 = findViewById(R.id.rdbErrado17);
        rdbErrado3 = findViewById(R.id.rdbErrado18);
        btnResponder6 = findViewById(R.id.btnResponder6);
        RdgPergunta = findViewById(R.id.rdgPergunta6);

        btnResponder6.setEnabled(false);

        RdgPergunta.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rdbCorreto.isChecked()||rdbErrado1.isChecked()||rdbErrado2.isChecked()||rdbErrado3.isChecked()){
                    btnResponder6.setEnabled(true);
                }
            }
        });
    }
    public void Responder(View view){
        if(rdbCorreto.isChecked()){
            GerenciadorPontos.addPontos();
        }
        Intent intent = new Intent(Pergunta6.this, Pergunta7.class);
        startActivity(intent);
        finish();
    }
}