package br.com.garrafa.main;

import br.com.garrafa.model.Garrafa;

public class SistemaPrincipal {

    public static void main(String[] args) {

        Garrafa minhaGarrafa = new Garrafa();
        minhaGarrafa.marca = "Stanley";
        minhaGarrafa.material = "Aço inox";
        minhaGarrafa.capacidadeMl = 1000;
        minhaGarrafa.volumeAtualMl = 750;
        minhaGarrafa.tampada = true;

        Garrafa garrafaDoProfessor = new Garrafa();
        garrafaDoProfessor.marca = "Crystal";
        garrafaDoProfessor.material = "Plástico PET";
        garrafaDoProfessor.capacidadeMl = 500;
        garrafaDoProfessor.volumeAtualMl = 500;
        garrafaDoProfessor.tampada = false;

        System.out.println("--- Testando a garrafa Stanley ---");
        minhaGarrafa.beber(200);      // Inválido: tampada
        minhaGarrafa.abrirTampa();
        minhaGarrafa.beber(200);      // Válido
        minhaGarrafa.beber(-50);      // Inválido: negativo
        minhaGarrafa.beber(5000);     // Inválido: mais do que tem
        minhaGarrafa.encher(100);     // Válido
        minhaGarrafa.encher(1000);    // Inválido: transbordaria
        System.out.println("Espaço livre: " + minhaGarrafa.calcularEspacoLivreMl() + " ml");
        minhaGarrafa.fecharTampa();
        minhaGarrafa.fecharTampa();   // Inválido: já fechada

        System.out.println("\n--- Testando a garrafa Crystal ---");
        // Usando o retorno dos métodos
        boolean encheu = garrafaDoProfessor.encher(300);
        System.out.println("Conseguiu encher? " + encheu);
        boolean bebeu = garrafaDoProfessor.beber(300);
        System.out.println("Conseguiu beber? " + bebeu);
    }
}