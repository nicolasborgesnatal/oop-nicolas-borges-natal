package br.com.garrafa.model;

public class Garrafa {

    // Atributos fechados: só a própria classe altera
    private String marca;
    private String material;
    private double capacidadeMl;
    private double volumeAtualMl;
    private boolean tampada;

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
        setVolumeAtualMl(this.volumeAtualMl + quantidadeMl);
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
        setVolumeAtualMl(this.volumeAtualMl - quantidadeMl);
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

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        // Marca é obrigatória
        if (marca == null || marca.isBlank()) {
            System.out.println("Erro: a marca não pode ser vazia.");
            return;
        }
        this.marca = marca;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        // Material é obrigatório
        if (material == null || material.isBlank()) {
            System.out.println("Erro: o material não pode ser vazio.");
            return;
        }
        this.material = material;
    }

    public double getCapacidadeMl() {
        return this.capacidadeMl;
    }

    public void setCapacidadeMl(double capacidadeMl) {
        // Faixa realista para uma garrafa
        if (capacidadeMl <= 0 || capacidadeMl > 3000) {
            System.out.println("Erro: a capacidade deve ser maior que 0 e no máximo 3000 ml.");
            return;
        }
        // Não pode encolher abaixo do que já tem dentro
        if (capacidadeMl < this.volumeAtualMl) {
            System.out.println("Erro: a capacidade não pode ser menor que o volume atual (" + this.volumeAtualMl + " ml).");
            return;
        }
        this.capacidadeMl = capacidadeMl;
    }

    public double getVolumeAtualMl() {
        return this.volumeAtualMl;
    }

    // Privado: volume só muda via encher() e beber()
    private void setVolumeAtualMl(double volumeAtualMl) {
        if (volumeAtualMl < 0 || volumeAtualMl > this.capacidadeMl) {
            System.out.println("Erro de segurança: volume inválido bloqueado.");
            return;
        }
        this.volumeAtualMl = volumeAtualMl;
    }

    // Getter de boolean usa "is" por convenção
    public boolean isTampada() {
        return this.tampada;
    }
}