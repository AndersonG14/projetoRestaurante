package br.ufpb.dcx.anderson.restaurante;

public class ItemMenu {
    private String nome;
    private double preco;

    // Construtor
    public ItemMenu(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Exibir detalhes do item
    public void exibirItem() {
        System.out.println(nome + " - R$ " + preco);
    }
}