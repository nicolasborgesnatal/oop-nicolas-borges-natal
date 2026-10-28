package br.com.garrafa.main;

import java.util.List;

import br.com.garrafa.model.Caderno;
import br.com.garrafa.model.Garrafa;
import br.com.garrafa.model.GarrafaPet;
import br.com.garrafa.model.GarrafaTermica;
import br.com.garrafa.model.Reciclavel;
import br.com.garrafa.model.Tampa;

public class SistemaPrincipal {

    public static void main(String[] args) {

        System.out.println("--- Criando os objetos ---");
        GarrafaTermica stanley = new GarrafaTermica("Stanley", 1000, new Tampa("Rosca", "Preta"), 2);
        GarrafaPet crystal = new GarrafaPet("Crystal", 500, new Tampa("Rosca", "Azul"), 60);
        GarrafaPet petGenerica = new GarrafaPet();
        Caderno tilibra = new Caderno("Tilibra", 96, 70);

        System.out.println("\n--- Conservação (classe abstrata + polimorfismo) ---");
        List<Garrafa> prateleira = List.of(stanley, crystal, petGenerica);
        for (Garrafa garrafa : prateleira) {
            System.out.println(garrafa.getMarca() + " -> " + garrafa.calcularTempoConservacao());
        }

        System.out.println("\n--- Reciclagem (polimorfismo de interface) ---");
        // Garrafa e Caderno juntos: o que os une é o contrato, não a herança
        Reciclavel[] reciclaveis = { crystal, petGenerica, tilibra };
        for (Reciclavel item : reciclaveis) {
            System.out.println(item.descartarCorretamente());
            System.out.println("Selo verde (mín. " + Reciclavel.PERCENTUAL_SELO_VERDE + "% reciclado)? "
                    + item.possuiSeloVerde());
            System.out.println("---");
        }

        System.out.println("\n--- Múltiplos tipos ---");
        System.out.println("Crystal é uma Garrafa? " + (crystal instanceof Garrafa));
        System.out.println("Crystal é Reciclavel? " + (crystal instanceof Reciclavel));
        System.out.println("Caderno é uma Garrafa? " + Garrafa.class.isInstance(tilibra));
        System.out.println("Caderno é Reciclavel? " + (tilibra instanceof Reciclavel));
        System.out.println("Stanley é Reciclavel? " + (stanley instanceof Reciclavel));

        System.out.println("\n--- Validação com as constantes da interface ---");
        new Caderno("Genérico", 96, 150);
    }
}