package br.edu.ifpb.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.edu.ifpb.bd.model.*;
import br.edu.ifpb.bd.util.*;

import java.util.List;

import java.util.ArrayList;

public class IngredienteDAO {

    public void salvar(Ingrediente ingrediente) throws Exception {
        String sql = "INSERT INTO ingrediente (nome, tipo_medida) VALUES (?,?)";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ingrediente.getNome());
            pstmt.setString(2, ingrediente.getTipo_medida());
            pstmt.execute();
        }
    }

    public List<Ingrediente> listar() throws Exception {
        List<Ingrediente> lista = new ArrayList<>();
        String sql = "SELECT * FROM ingrediente";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                lista.add(new Ingrediente(
                        rs.getInt("id_ingrediente"),
                        rs.getString("nome"),
                        rs.getString("tipo_medida")));
            }
            return lista;
        }
    }

    public Ingrediente buscar(int id) throws Exception {
        String sql = "SELECT * FROM ingrediente WHERE id_ingrediente = ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setId(id);
                ingrediente.setNome(rs.getString("nome"));
                ingrediente.setTipo_medida(rs.getString("tipo_medida"));

                return ingrediente;
            }
            return null;
        }
    }

    public void atualizar(Ingrediente a) throws Exception {
        String sql = "UPDATE ingrediente SET nome = ?, tipo_medida = ? WHERE id_ingrediente=?";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, a.getNome());
            pstmt.setString(2, a.getTipo_medida());
            pstmt.setInt(1, a.getId());
            pstmt.executeUpdate();
        }
    }

    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM ingrediente WHERE id_ingrediente = ?";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.execute();
        }
    }

}
