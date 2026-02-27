package br.edu.ifpb.bd.model;

public class AbastecimentoLoja {
    private int id_abastecimento;
    private int id_loja;
    private int id_armazem;
    private int id_ingrediente;

    private String ingrediente;
    private String cidade;
    private String local_loja;

    private int quantidade_ingrediente;

    // Campos usados para consultas com GROUP BY
    private int total_recebido;
    private int total_abastecido;

    public AbastecimentoLoja() {
    }

    public AbastecimentoLoja(int id_abastecimento, int id_loja, int id_armazem, String ingrediente,
            String local_loja) {
        this.id_abastecimento = id_abastecimento;
        this.id_loja = id_loja;
        this.id_armazem = id_armazem;
        this.ingrediente = ingrediente;
        this.local_loja = local_loja;
    }

    public int getId_abastecimento() {
        return id_abastecimento;
    }

    public void setId_abastecimento(int id_abastecimento) {
        this.id_abastecimento = id_abastecimento;
    }

    public int getId_loja() {
        return id_loja;
    }

    public void setId_loja(int id_loja) {
        this.id_loja = id_loja;
    }

    public int getId_armazem() {
        return id_armazem;
    }

    public void setId_armazem(int id_armazem) {
        this.id_armazem = id_armazem;
    }

    public int getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(int id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public String getLocal_loja() {
        return local_loja;
    }

    public void setLocal_loja(String local_loja) {
        this.local_loja = local_loja;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getQuantidade_ingrediente() {
        return quantidade_ingrediente;
    }

    public void setQuantidade_ingrediente(int quantidade_ingrediente) {
        this.quantidade_ingrediente = quantidade_ingrediente;
    }

    public int getTotal_recebido() {
        return total_recebido;
    }

    public void setTotal_recebido(int total_recebido) {
        this.total_recebido = total_recebido;
    }

    public int getTotal_abastecido() {
        return total_abastecido;
    }

    public void setTotal_abastecido(int total_abastecido) {
        this.total_abastecido = total_abastecido;
    };

    
}
