package controller;

import model.Disponibilidade;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "PesquisaDisponibilidadeController", urlPatterns = {"/PesquisaDisponibilidadeController"})
public class    PesquisaDisponibilidadeController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws SecurityException, IOException, ServletException, SQLException, ClassNotFoundException {
        request.setAttribute("disponibilidades", Disponibilidade.obterTodasDisponibilidades());
        RequestDispatcher view = request.getRequestDispatcher("pesquisaDisponibilidade.jsp");
        view.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            processRequest(request, response);
        } catch (SecurityException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PesquisaDisponibilidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SecurityException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PesquisaDisponibilidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}