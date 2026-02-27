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

@WebServlet("/listarAcimaMedia")
public class ListarLojasAcimaDaMediaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AbastecimendoLojaDAO dao = new AbastecimendoLojaDAO();
        List<AbastecimentoLoja> lista = dao.listarLojasAcimaDaMedia();

        request.setAttribute("listaAcimaMedia", lista);
        request.getRequestDispatcher("/abastecimento/listarLojasAcimaDaMedia.jsp")
               .forward(request, response);
    }
}