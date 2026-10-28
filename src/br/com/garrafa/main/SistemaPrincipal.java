package br.com.garrafa.main;

import java.util.ArrayList;
import java.util.List;

import br.com.garrafa.model.Garrafa;
import br.com.garrafa.model.GarrafaPet;
import br.com.garrafa.model.GarrafaTermica;
import br.com.garrafa.model.Tampa;

public class SistemaPrincipal {

    public static void main(String[] args) {

        System.out.println("--- Abastecendo a prateleira ---");
        // Lista da mãe aceita qualquer filha
        List<Garrafa> prateleira = new ArrayList<>();
        prateleira.add(new GarrafaTermica("Stanley", 1000, new Tampa("Rosca", "Preta"), 2));
        prateleira.add(new GarrafaTermica("Thermos", 500, new Tampa("Bico", "Prata"), 3));
        prateleira.add(new GarrafaPet("Crystal", 500, new Tampa("Rosca", "Azul"), 30));
        prateleira.add(new Garrafa());

        System.out.println("\n--- RELATÓRIO DE CONSERVAÇÃO DA PRATELEIRA ---");
        for (Garrafa garrafa : prateleira) {
            System.out.println("Garrafa: " + garrafa.getMarca() + " (" + garrafa.getMaterial() + ")");
            garrafa.abrirTampa();
            garrafa.encher(300);
            // Mesmo comando; quem decide a conta é o objeto real
            System.out.println(garrafa.calcularTempoConservacao());
            System.out.println("---------------------------------------");
        }
    }
}