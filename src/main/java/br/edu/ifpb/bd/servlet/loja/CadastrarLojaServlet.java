package br.edu.ifpb.bd.servlet.loja;

import java.io.IOException;

import br.edu.ifpb.bd.dao.LojaDAO;
import br.edu.ifpb.bd.model.Loja;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CadastrarLoja")
public class CadastrarLojaServlet extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.getRequestDispatcher("/loja/formLoja.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Loja loja = new Loja();
            loja.setMatriz(Boolean.parseBoolean(request.getParameter("matriz")));
            loja.setEstado(request.getParameter("estado"));
            loja.setCidade(request.getParameter("cidade"));
            loja.setNumero(request.getParameter("numero"));

            new LojaDAO().salvar(loja);

            response.sendRedirect("ListarLoja");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
