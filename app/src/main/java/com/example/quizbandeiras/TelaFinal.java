package com.example.quizbandeiras;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class TelaFinal extends AppCompatActivity {

    //Elementos da tela
    Button btnTelaPrincipal;
    TextView txtNome, txtPontos;
    RecyclerView lista;


    //Chamando o banco de dados
    BancoDados mydb = new BancoDados(TelaFinal.this);
    //Lista
    ArrayList<String> nome_usuario, pontos_usuario;//Pontos e nome do usuario no Db
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telafinal);

        //btnResponderNovamente = findViewById(R.id.btnResponderNovamente);
        btnTelaPrincipal = findViewById(R.id.btnTelaPrincipal);
        txtPontos = findViewById(R.id.txtPontos);
        txtNome = findViewById(R.id.txtNome);
        lista = findViewById(R.id.lista);//lista onde ficara o ranking de usuarios



        //Pega os pontos feitos e mostra na tela
        int pontos = GerenciadorPontos.getPontos();
        String nome = GerenciadorPontos.getNome();

        //Definindo nome e o ponto do usuario no banco de dados
        mydb.addPlayerRanking(nome, pontos);
        //inicializando listas
        nome_usuario = new ArrayList<>();
        pontos_usuario = new ArrayList<>();


        storeDatainArrays();

        customAdapter = new CustomAdapter(TelaFinal.this, nome_usuario, pontos_usuario);
        lista.setAdapter(customAdapter);

        lista.setLayoutManager(new LinearLayoutManager(TelaFinal.this));


        //mostra os pontos marcados
        txtPontos.setText(String.valueOf(pontos));
        //Pega o nome digitado e mostra na tela
        txtNome.setText(""+nome);
    }

    void storeDatainArrays(){
        Cursor cursor = mydb.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No Data.", Toast.LENGTH_SHORT).show();
        } else {
            int nomeColumnIndex = cursor.getColumnIndex("nome_usuario");
            int pontosColumnIndex = cursor.getColumnIndex("pontos_usuario");

            while (cursor.moveToNext()){
                // Acessar dados usando os índices das colunas
                String nome = cursor.getString(nomeColumnIndex);
                int pontos = cursor.getInt(pontosColumnIndex);

                // Adicionar dados às listas
                nome_usuario.add(nome);
                pontos_usuario.add(String.valueOf(pontos));
            }
        }
        cursor.close();
    }

    //Fecha a tela Ranking e abre a tela Principal
    public void Tela1(View view){
        Intent intent = new Intent(TelaFinal.this, MainActivity.class);
        finish();
        startActivity(intent);
    }
}