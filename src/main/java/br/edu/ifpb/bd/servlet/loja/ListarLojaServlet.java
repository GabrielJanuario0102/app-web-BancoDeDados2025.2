package br.edu.ifpb.bd.servlet.loja;

import br.edu.ifpb.bd.dao.LojaDAO;
import br.edu.ifpb.bd.model.Loja;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ListarLoja")
public class ListarLojaServlet extends HttpServlet{


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            List<Loja> lista = new LojaDAO().listar();
            request.setAttribute("lojas", lista);
            request.getRequestDispatcher("/loja/listLoja.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
