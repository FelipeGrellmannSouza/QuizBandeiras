package com.example.quizbandeiras;

//classe que serivirá para gerenciar os pontos e o nome do usuario
public class GerenciadorPontos {
    //Criando a Variavel nome e pontos
    private static int pontos = 0;
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