package br.edu.ifpb.bd.model;

public class Loja {
    private int id;
    private Boolean matriz;
    private String estado;
    private String cidade;
    private String numero;

    public Loja() {}

    public Loja(int id, Boolean matriz, String estado, String cidade, String numero) {
        this.id = id;
        this.matriz = matriz;
        this.estado = estado;
        this.cidade = cidade;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getMatriz() {
        return matriz;
    }

    public void setMatriz(Boolean matriz) {
        this.matriz = matriz;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    };

    
}
