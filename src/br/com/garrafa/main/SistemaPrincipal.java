package br.com.garrafa.main;

import java.util.ArrayList;
import java.util.List;

import br.com.garrafa.model.Garrafa;
import br.com.garrafa.model.GarrafaPet;
import br.com.garrafa.model.GarrafaTermica;
import br.com.garrafa.model.Tampa;

public class SistemaPrincipal {

    public static void main(String[] args) {

        // Teste de compilação: descomente e veja o erro
        // Garrafa generica = new Garrafa("Genérica", "Plástico", 500, new Tampa("Rosca", "Branca"));
        // Erro: Cannot instantiate the type Garrafa

        System.out.println("--- Abastecendo a prateleira ---");
        // O tipo da lista é abstrato, mas os objetos são sempre filhas concretas
        List<Garrafa> prateleira = new ArrayList<>();
        prateleira.add(new GarrafaTermica("Stanley", 1000, new Tampa("Rosca", "Preta"), 2));
        prateleira.add(new GarrafaTermica("Thermos", 500, new Tampa("Bico", "Prata"), 3));
        prateleira.add(new GarrafaPet("Crystal", 500, new Tampa("Rosca", "Azul"), 30));
        prateleira.add(new GarrafaPet());

        System.out.println("\n--- RELATÓRIO DE CONSERVAÇÃO DA PRATELEIRA ---");
        for (Garrafa garrafa : prateleira) {
            System.out.println("Garrafa: " + garrafa.getMarca() + " (" + garrafa.getMaterial() + ")");
            garrafa.abrirTampa();
            garrafa.encher(300);
            // Método abstrato na mãe, implementado em cada filha
            System.out.println(garrafa.calcularTempoConservacao());
            System.out.println("---------------------------------------");
        }
    }
}