package org.Main;


public class ProdutoAtacado {

    private int id;
    private String nome;
    private double preco;


    public ProdutoAtacado(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;

    }


    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Preço: " + preco;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

}
