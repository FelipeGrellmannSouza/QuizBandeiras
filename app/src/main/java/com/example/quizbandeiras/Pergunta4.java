package com.example.quizbandeiras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Pergunta4 extends AppCompatActivity {


    RadioButton rdbErrado1, rdbErrado2, rdbCorreto, rdbErrado3;
    Button btnResponder;
    RadioGroup rdgPergunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta4);

        rdbErrado1 = findViewById(R.id.rdbErrado12);
        rdbErrado2 = findViewById(R.id.rdbErrado10);
        rdbCorreto = findViewById(R.id.rdbCorreto4);
        rdbErrado3 = findViewById(R.id.rdbErrado11);
        btnResponder = findViewById(R.id.btnResponder4);
        rdgPergunta = findViewById(R.id.rdgPergunta4);

        btnResponder.setEnabled(false);

        rdgPergunta.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rdbCorreto.isChecked() || rdbErrado1.isChecked() || rdbErrado2.isChecked() || rdbErrado3.isChecked()) {
                    btnResponder.setEnabled(true); //seta o btn ativado caso tenha algum rdb ativo
                }
            }
        });
    }
    public void Responder4(View view){
        if (rdbCorreto.isChecked()){
            GerenciadorPontos.addPontos();
        }
        Intent intent = new Intent(Pergunta4.this, Pergunta5.class);
        startActivity(intent);
        finish();
    }
}