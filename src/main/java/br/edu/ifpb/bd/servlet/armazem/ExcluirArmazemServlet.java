package br.edu.ifpb.bd.servlet.armazem;

import java.io.IOException;

import br.edu.ifpb.bd.dao.ArmazemDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ExcluirArmazem")
public class ExcluirArmazemServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id_armazem = request.getParameter("id_armazem");
            
            if (id_armazem != null) {
                request.setAttribute("armazem", new ArmazemDAO().buscar(Integer.parseInt(id_armazem)));
                request.getRequestDispatcher("/armazem/excluirArmazem.jsp").forward(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try {
                    String id_armazem = request.getParameter("id_armazem");

                    if(id_armazem != null && !id_armazem.isEmpty()) {
                        ArmazemDAO armazemDAO = new ArmazemDAO();
                        armazemDAO.excluir(Integer.parseInt(id_armazem));
                    }

                    response.sendRedirect("ListarArmazem");
                } catch (Exception e) {
                    throw new ServletException(e);
                }
    }
}
