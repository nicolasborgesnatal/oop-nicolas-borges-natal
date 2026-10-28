package br.com.garrafa.main;

import br.com.garrafa.model.Garrafa;
import br.com.garrafa.model.Tampa;

public class SistemaPrincipal {

    public static void main(String[] args) {

        System.out.println("--- Criando as tampas ---");
        Tampa tampaRosca = new Tampa("Rosca", "Preta");
        Tampa tampaBico = new Tampa("Bico", "Azul");

        System.out.println("\n--- Criando as garrafas (associação) ---");
        Garrafa minhaGarrafa = new Garrafa("Stanley", "Aço inox", 1000, tampaRosca);
        Garrafa garrafaPadrao = new Garrafa();

        System.out.println("\n--- Usando a garrafa Stanley ---");
        minhaGarrafa.encher(750);      // Inválido: tampa nasce fechada
        minhaGarrafa.abrirTampa();
        minhaGarrafa.encher(750);
        minhaGarrafa.beber(200);

        System.out.println("\n--- Navegando pelo objeto associado ---");
        System.out.println("Tampa da Stanley: " + minhaGarrafa.getTampaAcoplada().getTipo() + " ("
                + minhaGarrafa.getTampaAcoplada().getCor() + ") | Aberta: " + minhaGarrafa.getTampaAcoplada().isAberta());
        System.out.println("Tampa da padrão: " + garrafaPadrao.getTampaAcoplada().getTipo() + " ("
                + garrafaPadrao.getTampaAcoplada().getCor() + ") | Aberta: " + garrafaPadrao.getTampaAcoplada().isAberta());

        System.out.println("\n--- Passagem por referência ---");
        // Mexendo na tampa por fora da garrafa
        tampaRosca.fechar();
        System.out.println("A Stanley percebeu? Tampada: " + minhaGarrafa.isTampada());

        System.out.println("\n--- Trocando a tampa ---");
        minhaGarrafa.trocarTampa(null);       // Inválido
        minhaGarrafa.trocarTampa(tampaBico);
    }
}