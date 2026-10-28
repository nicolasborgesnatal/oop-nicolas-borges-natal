package br.com.garrafa.model;

public class Garrafa {

    private String marca;
    private String material;
    private double capacidadeMl;
    private double volumeAtualMl;

    // Associação: a Garrafa TEM-UMA Tampa
    private Tampa tampaAcoplada;

    // Construtor padrão: reaproveita o customizado com valores genéricos
    public Garrafa() {
        this("Genérica", "Plástico PET", 500, new Tampa("Rosca", "Branca"));
    }

    // Construtor customizado: dados essenciais obrigatórios no nascimento
    public Garrafa(String marca, String material, double capacidadeMl, Tampa tampaAcoplada) {
        this.setMarca(marca);
        this.setMaterial(material);
        this.setCapacidadeMl(capacidadeMl);
        this.setTampaAcoplada(tampaAcoplada);
        // Estado inicial: vazia
        this.volumeAtualMl = 0;
        System.out.println("Garrafa criada: " + this.marca + " | " + this.material + " | " + this.capacidadeMl
                + " ml | Tampa: " + this.tampaAcoplada.getTipo() + " (" + this.tampaAcoplada.getCor() + ")");
    }

    public boolean encher(double quantidadeMl) {
        // Só aceita quantidade positiva
        if (quantidadeMl <= 0) {
            System.out.println("Erro: a quantidade para encher deve ser maior que zero.");
            return false;
        }
        // Garrafa fechada não recebe líquido
        if (this.isTampada()) {
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
        if (this.isTampada()) {
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

    // Repassa o comando para o objeto associado
    public void abrirTampa() {
        this.tampaAcoplada.abrir();
    }

    // Repassa o comando para o objeto associado
    public void fecharTampa() {
        this.tampaAcoplada.fechar();
    }

    // Ação real: tampa perdida ou quebrada é substituída
    public void trocarTampa(Tampa novaTampa) {
        this.setTampaAcoplada(novaTampa);
        if (this.tampaAcoplada == novaTampa) {
            System.out.println("Tampa trocada: agora é " + novaTampa.getTipo() + " (" + novaTampa.getCor() + ").");
        }
    }

    public double calcularEspacoLivreMl() {
        return this.capacidadeMl - this.volumeAtualMl;
    }
    
    // Contrato na base da hierarquia; cada filha sobrescreve
    public String calcularTempoConservacao() {
        return "Conservação não definida para uma garrafa genérica.";
    }

    public String getMarca() {
        return this.marca;
    }

    // Privado: marca não muda depois de fabricada
    private void setMarca(String marca) {
        if (marca == null || marca.isBlank()) {
            System.out.println("Erro: a marca não pode ser vazia.");
            return;
        }
        this.marca = marca;
    }

    public String getMaterial() {
        return this.material;
    }

    // Privado: material não muda depois de fabricada
    private void setMaterial(String material) {
        if (material == null || material.isBlank()) {
            System.out.println("Erro: o material não pode ser vazio.");
            return;
        }
        this.material = material;
    }

    public double getCapacidadeMl() {
        return this.capacidadeMl;
    }

    // Privado: capacidade não muda depois de fabricada
    private void setCapacidadeMl(double capacidadeMl) {
        if (capacidadeMl <= 0 || capacidadeMl > 3000) {
            System.out.println("Erro: a capacidade deve ser maior que 0 e no máximo 3000 ml.");
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

    public Tampa getTampaAcoplada() {
        return this.tampaAcoplada;
    }

    // Privado: troca só pelo processo trocarTampa()
    private void setTampaAcoplada(Tampa tampaAcoplada) {
        if (tampaAcoplada == null) {
            System.out.println("Erro: a garrafa precisa de uma tampa válida.");
            return;
        }
        this.tampaAcoplada = tampaAcoplada;
    }

    // Quem sabe se está fechada é a própria tampa
    public boolean isTampada() {
        return !this.tampaAcoplada.isAberta();
    }
}