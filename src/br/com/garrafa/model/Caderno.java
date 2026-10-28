package br.com.garrafa.model;

// Caderno NÃO é Garrafa, mas TAMBÉM é Reciclavel
public class Caderno implements Reciclavel {

    private String marca;
    private int quantidadeFolhas;
    private int percentualPapelReciclado;

    public Caderno(String marca, int quantidadeFolhas, int percentualPapelReciclado) {
        this.setMarca(marca);
        this.setQuantidadeFolhas(quantidadeFolhas);
        this.setPercentualPapelReciclado(percentualPapelReciclado);
        System.out.println("Caderno criado: " + this.marca + " | " + this.quantidadeFolhas + " folhas | "
                + this.percentualPapelReciclado + "% reciclado");
    }

    // Contrato da interface: papel vai no coletor azul
    @Override
    public String descartarCorretamente() {
        return "Caderno " + this.marca + ": descarte no coletor azul (papel). Retire a espiral antes.";
    }

    // Contrato da interface: selo depende do papel reciclado
    @Override
    public boolean possuiSeloVerde() {
        return this.percentualPapelReciclado >= Reciclavel.PERCENTUAL_SELO_VERDE;
    }

    public String getMarca() {
        return this.marca;
    }

    // Privado: marca não muda depois de fabricado
    private void setMarca(String marca) {
        if (marca == null || marca.isBlank()) {
            System.out.println("Erro: a marca do caderno não pode ser vazia.");
            return;
        }
        this.marca = marca;
    }

    public int getQuantidadeFolhas() {
        return this.quantidadeFolhas;
    }

    // Privado: quantidade de folhas vem de fábrica
    private void setQuantidadeFolhas(int quantidadeFolhas) {
        if (quantidadeFolhas <= 0) {
            System.out.println("Erro: o caderno deve ter pelo menos uma folha.");
            return;
        }
        this.quantidadeFolhas = quantidadeFolhas;
    }

    public int getPercentualPapelReciclado() {
        return this.percentualPapelReciclado;
    }

    // Privado: composição do papel não muda depois de fabricado
    private void setPercentualPapelReciclado(int percentualPapelReciclado) {
        if (percentualPapelReciclado < Reciclavel.PERCENTUAL_MINIMO || percentualPapelReciclado > Reciclavel.PERCENTUAL_MAXIMO) {
            System.out.println("Erro: o percentual de papel reciclado deve estar entre "
                    + Reciclavel.PERCENTUAL_MINIMO + " e " + Reciclavel.PERCENTUAL_MAXIMO + ".");
            return;
        }
        this.percentualPapelReciclado = percentualPapelReciclado;
    }
}