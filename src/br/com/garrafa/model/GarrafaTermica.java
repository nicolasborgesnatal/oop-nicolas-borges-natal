package br.com.garrafa.model;

// Garrafa térmica É UMA Garrafa
public class GarrafaTermica extends Garrafa {

    // Exclusivo: só a térmica tem isolamento
    private int camadasIsolamento;

    public GarrafaTermica(String marca, double capacidadeMl, Tampa tampaAcoplada, int camadasIsolamento) {
        // Térmica é sempre de aço inox; a mãe valida o resto
        super(marca, "Aço inox", capacidadeMl, tampaAcoplada);
        this.setCamadasIsolamento(camadasIsolamento);
    }

    // Cada camada segura 6 horas de temperatura
    @Override
    public String calcularTempoConservacao() {
        int horas = this.camadasIsolamento * 6;
        return "Conservação: " + horas + " horas (" + this.camadasIsolamento + " camada(s) de isolamento).";
    }

    public int getCamadasIsolamento() {
        return this.camadasIsolamento;
    }

    // Privado: isolamento não muda depois de fabricada
    private void setCamadasIsolamento(int camadasIsolamento) {
        if (camadasIsolamento < 1 || camadasIsolamento > 3) {
            System.out.println("Erro: a garrafa térmica deve ter de 1 a 3 camadas de isolamento.");
            return;
        }
        this.camadasIsolamento = camadasIsolamento;
    }
}