package br.edu.ifpb.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.bd.model.Loja;
import br.edu.ifpb.bd.util.ConnectionFactory;

public class LojaDAO {

    public LojaDAO() {
    };

    public void salvar(Loja loja) throws Exception {
        String sql = "INSERT INTO loja (matriz, estado, cidade, numero) VALUES (?,?,?,?)";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setBoolean(1, loja.getMatriz());
            pstmt.setString(2, loja.getEstado());
            pstmt.setString(3, loja.getCidade());
            pstmt.setString(4, loja.getNumero());

            pstmt.executeUpdate();
        }
    }

    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM loja WHERE id_loja = ?";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public List<Loja> listar() throws Exception {
        String sql = "SELECT * FROM loja";
        List<Loja> lista = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                lista.add(new Loja(rs.getInt("id_loja"),
                rs.getBoolean("matriz"),
                rs.getString("estado"),
                rs.getString("cidade"),
                rs.getString("numero")));
            }
            return lista;
        }
    }

    public Loja buscar(int id) throws Exception {
        String sql = "SELECT * FROM loja WHERE id_loja = ?";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                Loja loja = new Loja(id,
                rs.getBoolean("matriz"),
                rs.getString("estado"),
                rs.getString("cidade"),
                rs.getString("numero"));

                return loja;
            }
            return null;
        }
    }

    public void atualizar(Loja l) throws Exception {
        String sql = "UPDATE loja SET matriz = ?, estado = ?, cidade = ?, numero = ? WHERE id_loja = ?";
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setBoolean(1, l.getMatriz());
            pstmt.setString(2, l.getEstado());
            pstmt.setString(3, l.getCidade());
            pstmt.setString(4, l.getNumero());
            pstmt.setInt(5, l.getId());
            
            pstmt.executeUpdate();
        }
    }
}
