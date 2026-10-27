package br.com.garrafa.model;

public class Garrafa {

    // Públicos por enquanto
    public String marca;
    public String material;
    public double capacidadeMl;
    public double volumeAtualMl;
    public boolean tampada;

    public boolean encher(double quantidadeMl) {
        // Só aceita quantidade positiva
        if (quantidadeMl <= 0) {
            System.out.println("Erro: a quantidade para encher deve ser maior que zero.");
            return false;
        }
        // Garrafa fechada não recebe líquido
        if (this.tampada) {
            System.out.println("Erro: abra a tampa antes de encher.");
            return false;
        }
        // Impede ultrapassar a capacidade
        if (quantidadeMl > calcularEspacoLivreMl()) {
            System.out.println("Erro: a garrafa transbordaria. Espaço livre: " + calcularEspacoLivreMl() + " ml.");
            return false;
        }
        this.volumeAtualMl += quantidadeMl;
        System.out.println("Garrafa enchida com " + quantidadeMl + " ml. Volume atual: " + this.volumeAtualMl + " ml.");
        return true;
    }

    public boolean beber(double quantidadeMl) {
        // Só aceita quantidade positiva
        if (quantidadeMl <= 0) {
            System.out.println("Erro: a quantidade para beber deve ser maior que zero.");
            return false;
        }
        // Garrafa fechada não libera líquido
        if (this.tampada) {
            System.out.println("Erro: abra a tampa antes de beber.");
            return false;
        }
        // Não dá para beber mais do que tem
        if (quantidadeMl > this.volumeAtualMl) {
            System.out.println("Erro: só há " + this.volumeAtualMl + " ml na garrafa.");
            return false;
        }
        this.volumeAtualMl -= quantidadeMl;
        System.out.println("Você bebeu " + quantidadeMl + " ml. Volume atual: " + this.volumeAtualMl + " ml.");
        return true;
    }

    public void abrirTampa() {
        // Evita abrir o que já está aberto
        if (!this.tampada) {
            System.out.println("Aviso: a tampa já está aberta.");
            return;
        }
        this.tampada = false;
        System.out.println("Tampa aberta.");
    }

    public void fecharTampa() {
        // Evita fechar o que já está fechado
        if (this.tampada) {
            System.out.println("Aviso: a tampa já está fechada.");
            return;
        }
        this.tampada = true;
        System.out.println("Tampa fechada.");
    }

    public double calcularEspacoLivreMl() {
        return this.capacidadeMl - this.volumeAtualMl;
    }
}