package br.edu.ifpb.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import br.edu.ifpb.bd.model.Armazem;
import br.edu.ifpb.bd.util.ConnectionFactory;

public class ArmazemDAO {

    public void salvar(Armazem armazem) throws Exception {
        String sql = "INSERT INTO armazem (estado, cidade, numero) VALUES (?,?,?)";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, armazem.getEstado());
            pstmt.setString(2, armazem.getCidade());
            pstmt.setString(3, armazem.getNumero());
            pstmt.execute();
        }
    }

        public void excluir(int id) throws Exception {
        String sql = "DELETE FROM armazem WHERE id_armazem = ?";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.execute();
        }
    }







    public List<Armazem> listar() throws Exception {
        List<Armazem> lista = new ArrayList<>();
        String sql = "SELECT * FROM armazem";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                lista.add(new Armazem(
                        rs.getInt("id_armazem"),
                        rs.getString("estado"),
                        rs.getString("cidade"),
                        rs.getString("numero")));
            }
            return lista;
        }
    }

    public Armazem buscar(int id) throws Exception {
        String sql = "SELECT * FROM armazem WHERE id_armazem = ?";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Armazem a = new Armazem();
                a.setId(id);
                a.setEstado(rs.getString("estado"));
                a.setCidade(rs.getString("cidade"));
                a.setNumero(rs.getString("numero"));
                return a;

                
            }
        }
        return null;
    }

    public void atualizar(Armazem a) throws Exception {
        String sql = "UPDATE armazem SET estado=?, cidade=?, numero=? WHERE id_armazem=?";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, a.getEstado());
            pstmt.setString(2, a.getCidade());
            pstmt.setString(3, a.getNumero());
            pstmt.setInt(4, a.getId());
            pstmt.execute();
        }
    }


}
