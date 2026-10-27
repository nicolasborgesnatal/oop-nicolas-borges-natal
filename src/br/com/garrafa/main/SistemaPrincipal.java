package br.com.garrafa.main;

import br.com.garrafa.model.Garrafa;

public class SistemaPrincipal {

    public static void main(String[] args) {

        // Mesmo molde, dois objetos com estados diferentes
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

        System.out.println("--- Garrafas ---");
        System.out.println("Minha garrafa: " + minhaGarrafa.marca + " | " + minhaGarrafa.material
                + " | " + minhaGarrafa.volumeAtualMl + "/" + minhaGarrafa.capacidadeMl + " ml"
                + " | Tampada: " + minhaGarrafa.tampada);
        System.out.println("Garrafa do professor: " + garrafaDoProfessor.marca + " | " + garrafaDoProfessor.material
                + " | " + garrafaDoProfessor.volumeAtualMl + "/" + garrafaDoProfessor.capacidadeMl + " ml"
                + " | Tampada: " + garrafaDoProfessor.tampada);
    }
}