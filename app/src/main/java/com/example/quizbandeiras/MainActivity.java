package com.example.quizbandeiras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNomeUsuario;
    Button btnInciar, btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNomeUsuario = findViewById(R.id.edtNomeUsuario);
        btnInciar = findViewById(R.id.btnIniciar);
        btnSair = findViewById(R.id.btnSair);

        btnInciar.setEnabled(false);
        edtNomeUsuario.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().isEmpty()){
                    btnInciar.setEnabled(false);
                }
                else{
                    btnInciar.setEnabled(true);
                }
            }
        });
    }


    public void sair(View view){
        finishAffinity();
    }

    public void Iniciar(View view){    //método para o botão iniciar
        String nome = edtNomeUsuario.getText().toString();//Pega o nome do usuario
        GerenciadorPontos.setNome(nome);
        Intent intent = new Intent(MainActivity.this, Pergunta1.class); //Chama activity_pergunta1
        GerenciadorPontos.resetPontos(); //Zera os pontos
        startActivity(intent);
    }
}