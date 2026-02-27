package br.edu.ifpb.bd.servlet.abastecimento;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import br.edu.ifpb.bd.dao.AbastecimendoLojaDAO;
import br.edu.ifpb.bd.model.AbastecimentoLoja;

@WebServlet("/listarTotalLoja")
public class ListarTotalRecebidoPorLojaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AbastecimendoLojaDAO dao = new AbastecimendoLojaDAO();
        List<AbastecimentoLoja> lista = dao.listarTotalRecebidoPorLoja();

        request.setAttribute("listaTotalLoja", lista);
        request.getRequestDispatcher("/abastecimento/listarTotalRecebidoPorLoja.jsp").forward(request, response);
    }
}