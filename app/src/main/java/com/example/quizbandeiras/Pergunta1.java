package com.example.quizbandeiras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Pergunta1 extends AppCompatActivity {

    RadioGroup rdgPergunta1;
    RadioButton rdbCorreto, rdbErrado1, rdbErrado2, rdbErrado3;
    Button btnResponder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta1);

        rdgPergunta1 = findViewById(R.id.rdgPergunta1);
        rdbCorreto = findViewById(R.id.rdbCorretoPergunta1);
        rdbErrado1 = findViewById(R.id.rdbErrado1);
        rdbErrado2 = findViewById(R.id.rdbErrado2);
        rdbErrado3 = findViewById(R.id.rdbErrado3);
        btnResponder = findViewById(R.id.btnResponder);

        btnResponder.setEnabled(false);//desativa o btn

        rdgPergunta1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Verificar se algum RadioButton está selecionado
                if (rdbCorreto.isChecked() || rdbErrado1.isChecked() || rdbErrado2.isChecked() || rdbErrado3.isChecked()) {
                    btnResponder.setEnabled(true); //seta o btn ativado caso tenha algum rdb ativo
                }
            }
        });
    }
    //Adiciona pontos caso acerte, manda para proxima tela e finaliza a tela anterior
    public void Responder(View view) {
        if (rdbCorreto.isChecked()) {
            GerenciadorPontos.addPontos();
        }
        Intent intent = new Intent(Pergunta1.this, Pergunta2.class);
        startActivity(intent);
        finish();
    }
}