package com.example.quizbandeiras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Pergunta10 extends AppCompatActivity {
    RadioGroup rdgPergunta;
    RadioButton rdbCorreto, rdbErrado1, rdbErrado2, rdbErrado3;
    Button btnResponder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta10);

        rdbCorreto = findViewById(R.id.rdbCorreto10);
        rdbErrado1 = findViewById(R.id.rdbErrado28);
        rdbErrado2 = findViewById(R.id.rdbErrado29);
        rdbErrado3 = findViewById(R.id.rdbErrado30);
        btnResponder = findViewById(R.id.btnResponder10);
        rdgPergunta = findViewById(R.id.rdgPergunta10);

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
        if (rdbCorreto.isChecked()){
            GerenciadorPontos.addPontos();
        }
        Intent intent = new Intent(Pergunta10.this, Ranking.class);
        startActivity(intent);
        finish();
    }
}
