package br.edu.ifpb.bd.dao;

import br.edu.ifpb.bd.model.Loja;

public class LojaDAO {
    
    public LojaDAO() {};

    public void salvar(Loja loja) {
        String sql = "INSERT INTO loja (matriz, estado, cidade, numero) VALUES (?,?,?,?)";
        
    }
}
