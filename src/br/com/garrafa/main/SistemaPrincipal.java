package br.com.garrafa.main;

import br.com.garrafa.model.Garrafa;

public class SistemaPrincipal {

    public static void main(String[] args) {

        System.out.println("--- Construtor customizado ---");
        Garrafa minhaGarrafa = new Garrafa("Stanley", "Aço inox", 1000);

        System.out.println("\n--- Construtor padrão (encadeado com this()) ---");
        Garrafa garrafaPadrao = new Garrafa();

        System.out.println("\n--- Usando a garrafa Stanley ---");
        minhaGarrafa.encher(750);
        minhaGarrafa.beber(200);

        System.out.println("\n--- Usando a garrafa padrão ---");
        garrafaPadrao.encher(600);   // Inválido: transbordaria
        garrafaPadrao.encher(500);

        System.out.println("\n--- Estado final ---");
        System.out.println(minhaGarrafa.getMarca() + " | " + minhaGarrafa.getMaterial() + " | "
                + minhaGarrafa.getVolumeAtualMl() + "/" + minhaGarrafa.getCapacidadeMl() + " ml"
                + " | Tampada: " + minhaGarrafa.isTampada());
        System.out.println(garrafaPadrao.getMarca() + " | " + garrafaPadrao.getMaterial() + " | "
                + garrafaPadrao.getVolumeAtualMl() + "/" + garrafaPadrao.getCapacidadeMl() + " ml"
                + " | Tampada: " + garrafaPadrao.isTampada());

        // Tentativas bloqueadas: descomente e veja o erro de compilação
        // minhaGarrafa.setMarca("Outra marca");   // Marca não muda depois de fabricada
        // minhaGarrafa.setCapacidadeMl(2000);     // Capacidade também não
    }
}