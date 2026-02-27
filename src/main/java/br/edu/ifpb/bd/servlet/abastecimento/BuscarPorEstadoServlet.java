package br.edu.ifpb.bd.servlet.abastecimento;

import java.io.IOException;
import java.util.List;

import br.edu.ifpb.bd.dao.AbastecimendoLojaDAO;
import br.edu.ifpb.bd.model.AbastecimentoLoja;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/BuscarPorEstado")
public class BuscarPorEstadoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeEstado = request.getParameter("nomeEstado");
        if(nomeEstado == null) {
            nomeEstado = "";
        }

        AbastecimendoLojaDAO dao = new AbastecimendoLojaDAO();
        List<AbastecimentoLoja> lista = dao.listarAbastecimentoEstadoLoja(nomeEstado);

        request.setAttribute("lista", lista);
        request.getRequestDispatcher("/abastecimento/BuscarAbastecimentoPorEstado.jsp")
                .forward(request, response);
    }
}