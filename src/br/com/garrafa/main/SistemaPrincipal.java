package br.com.garrafa.main;

import br.com.garrafa.model.Garrafa;

public class SistemaPrincipal {

    public static void main(String[] args) {

        System.out.println("--- Configurando a garrafa ---");
        Garrafa minhaGarrafa = new Garrafa();
        minhaGarrafa.setMarca("Stanley");
        minhaGarrafa.setMaterial("Aço inox");
        minhaGarrafa.setCapacidadeMl(1000);
        System.out.println("Garrafa configurada: " + minhaGarrafa.getMarca() + " | "
                + minhaGarrafa.getMaterial() + " | " + minhaGarrafa.getCapacidadeMl() + " ml");

        System.out.println("\n--- Tentando burlar os setters ---");
        minhaGarrafa.setMarca("");            // Inválido: vazio
        minhaGarrafa.setCapacidadeMl(-100);   // Inválido: negativo
        minhaGarrafa.setCapacidadeMl(5000);   // Inválido: acima de 3000
        System.out.println("Depois das tentativas: " + minhaGarrafa.getMarca() + " | "
                + minhaGarrafa.getCapacidadeMl() + " ml");

        System.out.println("\n--- Usando a garrafa ---");
        minhaGarrafa.encher(750);
        minhaGarrafa.fecharTampa();
        minhaGarrafa.beber(200);              // Inválido: tampada
        minhaGarrafa.abrirTampa();
        minhaGarrafa.beber(200);
        minhaGarrafa.setCapacidadeMl(300);    // Inválido: menor que o volume

        System.out.println("\n--- Estado final (lido pelos getters) ---");
        System.out.println("Marca: " + minhaGarrafa.getMarca());
        System.out.println("Material: " + minhaGarrafa.getMaterial());
        System.out.println("Capacidade: " + minhaGarrafa.getCapacidadeMl() + " ml");
        System.out.println("Volume atual: " + minhaGarrafa.getVolumeAtualMl() + " ml");
        System.out.println("Tampada: " + minhaGarrafa.isTampada());
        System.out.println("Espaço livre: " + minhaGarrafa.calcularEspacoLivreMl() + " ml");

        // Tentativa de hack: descomente e veja o erro de compilação
        // minhaGarrafa.volumeAtualMl = 999999;
    }
}