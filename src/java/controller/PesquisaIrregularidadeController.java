package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Irregularidade;

/**
 *
 * @author luis
 */
@WebServlet(name = "PesquisaIrregularidadeController", urlPatterns = "/PesquisaIrregularidadeController")
public class PesquisaIrregularidadeController extends HttpServlet {
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException{
  request.setAttribute("irregularidades", Irregularidade.obterTodasIrregularidades());
        RequestDispatcher view = request.getRequestDispatcher("pesquisaIrregularidade.jsp");
        view.forward(request, response);
    }
     
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PesquisaPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PesquisaPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
