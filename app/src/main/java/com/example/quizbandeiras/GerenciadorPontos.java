package com.example.quizbandeiras;

import android.database.sqlite.SQLiteOpenHelper;

//classe que serivirá para gerenciar os pontos e o nome do usuario
public class GerenciadorPontos {
    //Cria variavel pontos
    private static int pontos = 0;
    //cria variavavel nome
    private static String nome;

    //Retorna pontos
    public static int getPontos() {
        return pontos;
    }

    //Retorna o nome do usuario
    public static String getNome(){//Retorna nome
        return nome;
    }

    //seta o nome do usuario
    public static void setNome(String nome) {
        GerenciadorPontos.nome = nome;
    }
    //Incrementa pontos
    public static void addPontos() {
        pontos++;
    }

    //define pontos como zero
    public static void resetPontos(){//Zera os pontos
        pontos = 0;
    }
}