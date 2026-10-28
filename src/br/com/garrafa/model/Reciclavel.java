package br.com.garrafa.model;

// Capacidade compartilhada por objetos sem parentesco entre si
public interface Reciclavel {

    // Constantes: implicitamente public static final
    int PERCENTUAL_MINIMO = 0;
    int PERCENTUAL_MAXIMO = 100;
    int PERCENTUAL_SELO_VERDE = 50;

    // Métodos: implicitamente public abstract
    String descartarCorretamente();

    boolean possuiSeloVerde();
}