package br.edu.ifpb.bd.servlet.armazem;

import java.io.IOException;

import br.edu.ifpb.bd.dao.ArmazemDAO;
import br.edu.ifpb.bd.model.Armazem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CadastrarArmazem")
public class CadastrarArmazemServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                try {
                    request.getRequestDispatcher("/armazem/formArmazem.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new ServletException(e);
                }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Armazem armazem = new Armazem();
            armazem.setEstado(request.getParameter("estado"));
            armazem.setCidade(request.getParameter("cidade"));
            armazem.setNumero(request.getParameter("numero"));

            ArmazemDAO armazemDao = new ArmazemDAO();
            armazemDao.salvar(armazem);

            response.sendRedirect("ListarArmazem");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
