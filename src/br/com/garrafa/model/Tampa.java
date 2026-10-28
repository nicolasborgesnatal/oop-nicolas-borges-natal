package br.com.garrafa.model;

public class Tampa {

    private String tipo;
    private String cor;
    private boolean aberta;

    public Tampa(String tipo, String cor) {
        this.setTipo(tipo);
        this.setCor(cor);
        // Tampa sai de fábrica fechada
        this.aberta = false;
        System.out.println("Tampa criada: " + this.tipo + " (" + this.cor + ")");
    }

    public void abrir() {
        // Evita abrir o que já está aberto
        if (this.aberta) {
            System.out.println("Aviso: a tampa já está aberta.");
            return;
        }
        this.aberta = true;
        System.out.println("Tampa aberta.");
    }

    public void fechar() {
        // Evita fechar o que já está fechado
        if (!this.aberta) {
            System.out.println("Aviso: a tampa já está fechada.");
            return;
        }
        this.aberta = false;
        System.out.println("Tampa fechada.");
    }

    public String getTipo() {
        return this.tipo;
    }

    // Privado: tipo da tampa não muda
    private void setTipo(String tipo) {
        if (tipo == null || tipo.isBlank()) {
            System.out.println("Erro: o tipo da tampa não pode ser vazio.");
            return;
        }
        this.tipo = tipo;
    }

    public String getCor() {
        return this.cor;
    }

    // Privado: cor da tampa não muda
    private void setCor(String cor) {
        if (cor == null || cor.isBlank()) {
            System.out.println("Erro: a cor da tampa não pode ser vazia.");
            return;
        }
        this.cor = cor;
    }

    public boolean isAberta() {
        return this.aberta;
    }
}