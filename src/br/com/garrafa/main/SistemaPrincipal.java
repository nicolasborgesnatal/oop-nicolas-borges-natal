package br.com.garrafa.main;

import br.com.garrafa.model.GarrafaPet;
import br.com.garrafa.model.GarrafaTermica;
import br.com.garrafa.model.Tampa;

public class SistemaPrincipal {

    public static void main(String[] args) {

        System.out.println("--- Criando as filhas (super() chama a mãe primeiro) ---");
        GarrafaTermica stanley = new GarrafaTermica("Stanley", 1000, new Tampa("Rosca", "Preta"), 2);
        GarrafaPet crystal = new GarrafaPet("Crystal", 500, new Tampa("Rosca", "Azul"), 30);

        System.out.println("\n--- Métodos herdados da mãe ---");
        // Nenhum desses métodos foi escrito nas filhas
        stanley.abrirTampa();
        stanley.encher(800);
        stanley.beber(250);
        crystal.abrirTampa();
        crystal.encher(500);

        System.out.println("\n--- Dados herdados + exclusivos ---");
        System.out.println("Térmica: " + stanley.getMarca() + " | " + stanley.getMaterial() + " | "
                + stanley.getVolumeAtualMl() + "/" + stanley.getCapacidadeMl() + " ml"
                + " | Camadas de isolamento: " + stanley.getCamadasIsolamento());
        System.out.println("PET: " + crystal.getMarca() + " | " + crystal.getMaterial() + " | "
                + crystal.getVolumeAtualMl() + "/" + crystal.getCapacidadeMl() + " ml"
                + " | Reciclado: " + crystal.getPercentualReciclado() + "%");

        System.out.println("\n--- Validação na filha ---");
        GarrafaTermica termicaInvalida = new GarrafaTermica("Genérica", 500, new Tampa("Bico", "Branca"), 5);
        System.out.println("Camadas registradas: " + termicaInvalida.getCamadasIsolamento());
    }
}