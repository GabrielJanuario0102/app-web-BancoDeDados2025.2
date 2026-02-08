package br.edu.ifpb.bd.servlet.ingrediente;

import br.edu.ifpb.bd.dao.IngredienteDAO;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ExcluirIngrediente")
public class ExcluirIngredienteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id_ingrediente = request.getParameter("id_ingrediente");

            if (id_ingrediente != null) {
                request.setAttribute("ingrediente", new IngredienteDAO().buscar(Integer.parseInt(id_ingrediente)));
                request.getRequestDispatcher("/ingrediente/excluirIngrediente.jsp").forward(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id_ingrediente = request.getParameter("id_ingrediente");

            if (id_ingrediente != null && !id_ingrediente.isEmpty()) {
                IngredienteDAO ingredienteDAO = new IngredienteDAO();
                ingredienteDAO.excluir(Integer.parseInt(id_ingrediente));
            }

            response.sendRedirect("ListarIngrediente");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
