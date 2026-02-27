package br.edu.ifpb.bd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.bd.util.ConnectionFactory;
import br.edu.ifpb.bd.model.AbastecimentoLoja;

public class AbastecimendoLojaDAO {
    public AbastecimendoLojaDAO() {
    };

    public List<AbastecimentoLoja> listarAbastecimentoIngrediente(String nomeIngrediente) {
        List<AbastecimentoLoja> lista = new ArrayList<>();
        String sql = "select al.id_abastecimento id_abastecimento, i.nome ingrediente, l.id_loja id_loja, l.estado local_loja, a.id_armazem id_armazem "
                + //
                "FROM abastecimento_loja al " + //
                "JOIN ingrediente i ON al.id_ingrediente = i.id_ingrediente " + //
                "JOIN loja l on al.id_loja = l.id_loja " + //
                "JOIN armazem a on al.id_armazem = a.id_armazem " + //
                "WHERE i.nome LIKE ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + nomeIngrediente + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                lista.add(
                        new AbastecimentoLoja(rs.getInt("id_abastecimento"),
                                rs.getInt("id_loja"),
                                rs.getInt("id_armazem"),
                                rs.getString("ingrediente"),
                                rs.getString("local_loja")));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }

    public List<AbastecimentoLoja> listarAbastecimentoEstadoLoja(String nomeEstado) {
        List<AbastecimentoLoja> lista = new ArrayList<>();
        String sql = "select al.id_abastecimento id_abastecimento, i.nome ingrediente, l.id_loja id_loja, l.estado local_loja, a.id_armazem id_armazem "
                + //
                "FROM abastecimento_loja al " + //
                "JOIN ingrediente i ON al.id_ingrediente = i.id_ingrediente " + //
                "JOIN loja l on al.id_loja = l.id_loja " + //
                "JOIN armazem a on al.id_armazem = a.id_armazem " + //
                "WHERE l.estado LIKE ?";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + nomeEstado + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                lista.add(
                        new AbastecimentoLoja(rs.getInt("id_abastecimento"),
                                rs.getInt("id_loja"),
                                rs.getInt("id_armazem"),
                                rs.getString("ingrediente"),
                                rs.getString("local_loja")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }

    public List<AbastecimentoLoja> listarTotalRecebidoPorLoja() {

        List<AbastecimentoLoja> lista = new ArrayList<>();

        String sql = "SELECT l.id_loja, l.cidade, " +
                "SUM(al.quantidade_ingrediente) AS total_recebido " +
                "FROM abastecimento_loja al " +
                "INNER JOIN loja l ON al.id_loja = l.id_loja " +
                "GROUP BY l.id_loja, l.cidade " +
                "ORDER BY total_recebido DESC";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                AbastecimentoLoja obj = new AbastecimentoLoja();
                obj.setId_loja(rs.getInt("id_loja"));
                obj.setCidade(rs.getString("cidade"));
                obj.setTotal_recebido(rs.getInt("total_recebido"));

                lista.add(obj);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return lista;
    }

    public List<AbastecimentoLoja> listarTotalPorIngrediente() {

        List<AbastecimentoLoja> lista = new ArrayList<>();

        String sql = "SELECT i.nome AS ingrediente, " +
                "SUM(al.quantidade_ingrediente) AS total_abastecido " +
                "FROM abastecimento_loja al " +
                "INNER JOIN ingrediente i ON al.id_ingrediente = i.id_ingrediente " +
                "GROUP BY i.nome " +
                "ORDER BY total_abastecido DESC";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                AbastecimentoLoja obj = new AbastecimentoLoja();
                obj.setIngrediente(rs.getString("ingrediente"));
                obj.setTotal_abastecido(rs.getInt("total_abastecido"));

                lista.add(obj);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return lista;
    }

    public List<AbastecimentoLoja> listarLojasComAbastecimento() {

        List<AbastecimentoLoja> lista = new ArrayList<>();

        String sql = "SELECT l.id_loja, l.cidade, " +
                "al.id_abastecimento, al.quantidade_ingrediente " +
                "FROM loja l " +
                "LEFT JOIN abastecimento_loja al " +
                "ON l.id_loja = al.id_loja " +
                "ORDER BY l.id_loja";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                AbastecimentoLoja obj = new AbastecimentoLoja();
                obj.setId_loja(rs.getInt("id_loja"));
                obj.setCidade(rs.getString("cidade"));
                obj.setId_abastecimento(rs.getInt("id_abastecimento"));
                obj.setQuantidade_ingrediente(rs.getInt("quantidade_ingrediente"));

                lista.add(obj);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return lista;
    }

    public List<AbastecimentoLoja> listarLojasAcimaDaMedia() {

        List<AbastecimentoLoja> lista = new ArrayList<>();

        String sql = "SELECT l.id_loja, l.cidade, " +
                "SUM(al.quantidade_ingrediente) AS total_recebido " +
                "FROM abastecimento_loja al " +
                "INNER JOIN loja l ON al.id_loja = l.id_loja " +
                "GROUP BY l.id_loja, l.cidade " +
                "HAVING SUM(al.quantidade_ingrediente) > " +
                "(SELECT AVG(quantidade_ingrediente) FROM abastecimento_loja) " +
                "ORDER BY total_recebido DESC";

        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                AbastecimentoLoja obj = new AbastecimentoLoja();
                obj.setId_loja(rs.getInt("id_loja"));
                obj.setCidade(rs.getString("cidade"));
                obj.setTotal_recebido(rs.getInt("total_recebido"));

                lista.add(obj);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return lista;
    }

}
