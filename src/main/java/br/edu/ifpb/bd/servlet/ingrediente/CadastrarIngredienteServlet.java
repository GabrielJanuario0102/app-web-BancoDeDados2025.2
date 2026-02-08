package br.edu.ifpb.bd.servlet.ingrediente;

import br.edu.ifpb.bd.model.*;
import br.edu.ifpb.bd.dao.*;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CadastrarIngrediente")
public class CadastrarIngredienteServlet extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            request.getRequestDispatcher("/ingrediente/formIngrediente.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Ingrediente ingrediente = new Ingrediente();
            ingrediente.setNome(request.getParameter("nome"));
            ingrediente.setTipo_medida(request.getParameter("tipo_medida"));

            IngredienteDAO ingredienteDAO = new IngredienteDAO();
            ingredienteDAO.salvar(ingrediente);
            
            response.sendRedirect("ListarIngrediente");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
