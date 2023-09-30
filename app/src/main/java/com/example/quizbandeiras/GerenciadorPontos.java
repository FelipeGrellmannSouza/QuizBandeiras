package com.example.quizbandeiras;
//classe que serivirá para gerenciar os pontos e o nome do usuario
public class GerenciadorPontos {
    //Cria variavel pontos
    private static int pontos = 0;
    //cria variavavel nome
    private static String nome;
    public static int getPontos() {//Retorna pontos
        return pontos;
    }//Retorna pontos
    public static String getNome(){//Retorna nome
        return nome;
    }//Retorna o nome do usuario

    //seta o nome do usuario
    public static void setNome(String nome) {
        GerenciadorPontos.nome = nome;
    }
    //Incrementa pontos
    public static void addPontos() { //Acrescenta um ponto
        pontos++;
    }

    //define pontos como zero
    public static void resetPontos(){//Zera os pontos
        pontos = 0;
    }
}