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

@WebServlet(name = "PesquisaDisponibilidadeController", urlPatterns = {"/PesquisaDisponibilidadeController"})
public class    PesquisaDisponibilidadeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws SecurityException, IOException, ServletException {
        try {
            request.setAttribute("disponibilidades", Disponibilidade.obterTodasDisponibilidades());
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaDisponibilidade.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}