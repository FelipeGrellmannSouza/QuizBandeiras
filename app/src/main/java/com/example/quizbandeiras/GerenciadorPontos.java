package com.example.quizbandeiras;
import android.util.Log;

//classe que serivirá para gerenciar os pontos e o nome do usuario
public class GerenciadorPontos {
    //Criando Variaveis
    private static int pontos = 0;
    private static String nome;
    private static long tempoInicio; // Variável para armazenar o tempo de início do quiz em milissegundos



    //Inicia o tempo
    public static void iniciarTempo(){
        tempoInicio = System.currentTimeMillis();
    }



    //Método onde é calculado a pontuação em função do tempo
    public static int calcularPontos(){
        long tempoAtual = System.currentTimeMillis();
        long tempoDecorrido = (tempoAtual - tempoInicio) / 1000; //1000 converte para segundos

        int pontosFinal = pontos * 1000;

        double penalidadeTempo = Math.max(0, (tempoDecorrido-15)*10);//-15 é o tempo minimo/ *10 é para aumentar a perca de pontos
        pontosFinal -= penalidadeTempo;

        pontosFinal = Math.max(0, pontosFinal);

        // Logs para verificar os valores
        Log.d("DEBUG", "Tempo Decorrido: " + tempoDecorrido);
        Log.d("DEBUG", "Penalidade: " + penalidadeTempo);
        Log.d("DEBUG", "Pontos: " + pontos);
        Log.d("DEBUG", "Pontos Final: " + pontosFinal);

        return pontosFinal;
    }


    //Retorna pontos
    public static int getPontos() {
        return pontos;
    }

    //Retorna o nome do usuario
    public static String getNome(){
        return nome;
    }

    //seta o nome do usuario
    public static void setNome(String nome) {
        GerenciadorPontos.nome = nome;
    }
    //Incrementa pontos
    public static void addPontos() {
        pontos = pontos + 1;
    }

    //define pontos como zero
    public static void resetPontos(){
        pontos = 0;
        tempoInicio = 0;
    }
}