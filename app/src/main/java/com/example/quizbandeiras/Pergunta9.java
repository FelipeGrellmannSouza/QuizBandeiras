package com.example.quizbandeiras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Pergunta9 extends AppCompatActivity {
    RadioGroup rdgPergunta;
    RadioButton rdbErrado1, rdbErrado2, rdbErrado3, rdbCorreto;
    Button btnResponder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta9);

        rdbErrado1 = findViewById(R.id.rdbErrado25);
        rdbErrado2 = findViewById(R.id.rdbErrado26);
        rdbErrado3 = findViewById(R.id.rdbErrado27);
        rdbCorreto = findViewById(R.id.rdbCorreto9);
        btnResponder = findViewById(R.id.btnResponder9);
        rdgPergunta = findViewById(R.id.rdgPergunta9);

        btnResponder.setEnabled(false);

        rdgPergunta.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rdbCorreto.isChecked()||rdbErrado1.isChecked()||rdbErrado2.isChecked()||rdbErrado3.isChecked()){
                    btnResponder.setEnabled(true);
                }
            }
        });
    }

    public void Responder(View view){
        if(rdbCorreto.isChecked()){
            GerenciadorPontos.addPontos();
        }
        Intent intent = new Intent(Pergunta9.this, Pergunta10.class);
        startActivity(intent);
        finish();
    }
}
