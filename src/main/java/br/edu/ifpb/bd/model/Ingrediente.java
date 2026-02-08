package br.edu.ifpb.bd.model;

public class Ingrediente {
    private int id;
    private String nome;
    private String tipo_medida;

    public Ingrediente() {};

    public Ingrediente(int id, String nome, String tipo_medida) {
        this.id = id;
        this.nome = nome;
        this.tipo_medida = tipo_medida;
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

    public String getTipo_medida() {
        return tipo_medida;
    }

    public void setTipo_medida(String tipo_medida) {
        this.tipo_medida = tipo_medida;
    }
    
}
