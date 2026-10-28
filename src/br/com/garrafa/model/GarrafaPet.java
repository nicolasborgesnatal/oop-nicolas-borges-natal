package br.com.garrafa.model;

// Garrafa PET É UMA Garrafa
public class GarrafaPet extends Garrafa {

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

    public int getPercentualReciclado() {
        return this.percentualReciclado;
    }

    // Privado: composição do plástico não muda depois de fabricada
    private void setPercentualReciclado(int percentualReciclado) {
        if (percentualReciclado < 0 || percentualReciclado > 100) {
            System.out.println("Erro: o percentual reciclado deve estar entre 0 e 100.");
            return;
        }
        this.percentualReciclado = percentualReciclado;
    }
}