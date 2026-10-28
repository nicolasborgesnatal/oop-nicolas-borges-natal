package br.com.garrafa.model;

// Garrafa PET É UMA Garrafa e TAMBÉM é Reciclavel
public class GarrafaPet extends Garrafa implements Reciclavel {

    // Exclusivo: só a PET tem percentual de plástico reciclado
    private int percentualReciclado;

    // Construtor padrão: PET genérica de 500 ml, sem plástico reciclado
    public GarrafaPet() {
        this("Genérica", 500, new Tampa("Rosca", "Branca"), 0);
    }

    public GarrafaPet(String marca, double capacidadeMl, Tampa tampaAcoplada, int percentualReciclado) {
        // PET é sempre de plástico PET; a mãe valida o resto
        super(marca, "Plástico PET", capacidadeMl, tampaAcoplada);
        this.setPercentualReciclado(percentualReciclado);
    }

    // Implementação obrigatória do contrato abstrato da mãe
    @Override
    public String calcularTempoConservacao() {
        return "Conservação: cerca de 1 hora (PET não tem isolamento térmico).";
    }

    // Contrato da interface: plástico vai no coletor vermelho
    @Override
    public String descartarCorretamente() {
        return "Garrafa " + this.getMarca() + ": descarte no coletor vermelho (plástico). Esvazie antes.";
    }

    // Contrato da interface: selo depende do plástico reciclado
    @Override
    public boolean possuiSeloVerde() {
        return this.percentualReciclado >= Reciclavel.PERCENTUAL_SELO_VERDE;
    }

    public int getPercentualReciclado() {
        return this.percentualReciclado;
    }

    // Privado: composição do plástico não muda depois de fabricada
    private void setPercentualReciclado(int percentualReciclado) {
        if (percentualReciclado < Reciclavel.PERCENTUAL_MINIMO || percentualReciclado > Reciclavel.PERCENTUAL_MAXIMO) {
            System.out.println("Erro: o percentual reciclado deve estar entre "
                    + Reciclavel.PERCENTUAL_MINIMO + " e " + Reciclavel.PERCENTUAL_MAXIMO + ".");
            return;
        }
        this.percentualReciclado = percentualReciclado;
    }
}