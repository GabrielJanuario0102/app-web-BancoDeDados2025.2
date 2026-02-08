package br.edu.ifpb.bd.servlet.armazem;

import java.io.IOException;

import br.edu.ifpb.bd.dao.ArmazemDAO;
import br.edu.ifpb.bd.model.Armazem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/EditarArmazem")
public class EditarArmazemServlet extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id_armazem = request.getParameter("id_armazem");
            if(id_armazem != null) {
                request.setAttribute("armazem", new ArmazemDAO().buscar(Integer.parseInt(id_armazem)));
                
                request.getRequestDispatcher("/armazem/editarArmazem.jsp").forward(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id_armazem = request.getParameter("id_armazem");
            
            if(id_armazem != null && !id_armazem.isEmpty()) {
                Armazem armazem = new Armazem();
                armazem.setEstado(request.getParameter("estado"));
                armazem.setCidade(request.getParameter("cidade"));
                armazem.setNumero(request.getParameter("numero"));
                armazem.setId(Integer.parseInt(id_armazem));

                ArmazemDAO armazemDAO = new ArmazemDAO();
                armazemDAO.atualizar(armazem);

                response.sendRedirect("ListarArmazem");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
