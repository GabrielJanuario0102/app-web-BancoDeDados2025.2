package br.edu.ifpb.bd.servlet.armazem;

import java.io.IOException;

import br.edu.ifpb.bd.dao.ArmazemDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListarArmazem")
public class ListarArmazemServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                try {
                    request.setAttribute("armazens", new ArmazemDAO().listar());
                    request.getRequestDispatcher("/armazem/listArmazem.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new ServletException(e);
                }
    }
}
