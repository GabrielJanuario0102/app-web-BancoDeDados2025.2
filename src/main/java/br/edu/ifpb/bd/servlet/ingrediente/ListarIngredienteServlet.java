package br.edu.ifpb.bd.servlet.ingrediente;

import java.io.IOException;

import br.edu.ifpb.bd.dao.IngredienteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListarIngrediente")
public class ListarIngredienteServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("ingredientes", new IngredienteDAO().listar());
            request.getRequestDispatcher("/ingrediente/listIngrediente.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
