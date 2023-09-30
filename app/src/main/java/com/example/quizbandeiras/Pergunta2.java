package com.example.quizbandeiras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Pergunta2 extends AppCompatActivity {

    RadioButton rdbErrado1, rdbCorreto, rdbErrado2, rdbErrado3;
    Button btnResponder;
    RadioGroup rdgPerguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta2);

        rdbErrado1 = findViewById(R.id.rdbErrado4);
        rdbCorreto = findViewById(R.id.rdbCorreto2);
        rdbErrado2 = findViewById(R.id.rdbErrado5);
        rdbErrado3 = findViewById(R.id.rdbErrado6);
        btnResponder = findViewById(R.id.btnResponder2);
        rdgPerguntas = findViewById(R.id.rdgPerguntas2);
        btnResponder.setEnabled(false);

        rdgPerguntas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if (rdbCorreto.isChecked() || rdbErrado1.isChecked() || rdbErrado2.isChecked() || rdbErrado3.isChecked()) {
                    btnResponder.setEnabled(true); //seta o btn ativado caso tenha algum rdb ativo
                }
            }
        });
    }

    public void Responder2(View view){
        if(rdbCorreto.isChecked()){
            GerenciadorPontos.addPontos();
        }
        Intent intent = new Intent(Pergunta2.this, Pergunta3.class);
        startActivity(intent);
        finish();
    }
}