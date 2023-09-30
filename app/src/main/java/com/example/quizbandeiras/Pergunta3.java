package com.example.quizbandeiras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Pergunta3 extends AppCompatActivity {
    RadioButton rdbErrado1, rdbErrado2, rdbCorreto, rdbErrado3;
    Button btnResponder;
    RadioGroup rdgPergunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta3);

        rdbErrado1 = findViewById(R.id.rdbErrado7);
        rdbErrado2 = findViewById(R.id.rdbErrado8);
        rdbCorreto = findViewById(R.id.rdbCorreto3);
        rdbErrado3 = findViewById(R.id.rdbErrado9);
        btnResponder = findViewById(R.id.btnResponder3);
        rdgPergunta= findViewById(R.id.rdgPergunta3);

        btnResponder.setEnabled(false);

       rdgPergunta.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rdbCorreto.isChecked() || rdbErrado1.isChecked() || rdbErrado2.isChecked() || rdbErrado3.isChecked()) {
                    btnResponder.setEnabled(true); //seta o btn ativado caso tenha algum rdb ativo
                }
            }
        });
    }
    public void Responder3(View view){
        if (rdbCorreto.isChecked()){
            GerenciadorPontos.addPontos();
        }
        Intent intent = new Intent(Pergunta3.this, Pergunta4.class);
        startActivity(intent);
        finish();
    }
}