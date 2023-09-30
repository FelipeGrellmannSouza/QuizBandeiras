package com.example.quizbandeiras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ranking extends AppCompatActivity {
    Button btnTelaPrincipal, btnResponderNovamente;
    TextView txtNome, txtPontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        btnResponderNovamente = findViewById(R.id.btnResponderNovamente);
        btnTelaPrincipal = findViewById(R.id.btnTelaPrincipal);
        txtPontos = findViewById(R.id.txtPontos);
        txtNome = findViewById(R.id.txtNome);
        //Pega os pontos feitos e mostra na tela
        int pontos = GerenciadorPontos.getPontos();
        txtPontos.setText(String.valueOf(pontos));

        //Pega o nome digitado e mostra na tela
        String Nome = GerenciadorPontos.getNome();
        txtNome.setText(""+Nome);
    }
    //Fecha a tela Ranking e abre a tela Principal
    public void Tela1(View view){
        Intent intent = new Intent(Ranking.this, MainActivity.class);
        finish();
        startActivity(intent);
    }
    //Fecha a tela Ranking e abre a tela da pergunta1 e reseta os pontos
    public void Tela2(View view){
        Intent intent = new Intent(Ranking.this, Pergunta1.class);
        finish();
        GerenciadorPontos.resetPontos();
        startActivity(intent);
    }
}