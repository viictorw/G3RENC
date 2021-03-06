/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Disponibilidade;
import model.Espaco;

/**
 *
 * @author iza Ribeiro
 */
/*@WebServlet(name = "ManterDisponibilidadeController", urlPatterns = {"/ManterDisponibilidadeController"})*/
public class ManterDisponibilidadeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, NoSuchMethodException {
        
        String acao = request.getParameter("acao");
        
        if(acao.equals("confirmarOperacao")){
           confirmarOperacao(request, response);
        
        }else{
            if(acao.equals("prepararOperacao")){
                prepararOperacao(request, response);
            }
        }
    }
    
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try{
        String operacao = request.getParameter("operacao");
        request.setAttribute("operacao", operacao);
        request.setAttribute("espacos", Espaco.obterTodosEspacos());
        
        if(!operacao.equals("Incluir")){
            Disponibilidade disponibilidade = Disponibilidade.obterDisponibilidade(Long.parseLong(request.getParameter("id")));
            request.setAttribute("disponibilidade", disponibilidade);
        }
                RequestDispatcher view = request.getRequestDispatcher("/manterDisponibilidade.jsp");
                view.forward(request, response);
                
    }catch(ServletException e){
                throw e;
            }catch(IOException | SQLException | ClassNotFoundException e){
                throw new ServletException(e);
            }
    }
    
     public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, ClassNotFoundException, NoSuchMethodException {
        String operacao = request.getParameter("operacao");

        String data = request.getParameter("txtDataDisponibilidade");
        String horaInicio = request.getParameter("txtHoraInicioDisponibilidade");
        String horaFim = request.getParameter("txtHoraFimDisponibilidade");
        long idEspaco = Long.parseLong(request.getParameter("idEspacos"));
        Long id = null;
        if (!operacao.equals("Incluir")) {
            id = Long.parseLong(request.getParameter("id"));
        }
        try {
            Espaco esp = null;
            if (idEspaco != 0) {
                esp = Espaco.obterEspaco(idEspaco);
            }
            Disponibilidade disponibilidade = new Disponibilidade(data,horaInicio,horaFim,esp);
            if (operacao.equals("Incluir")) {
                disponibilidade.salvar();
            }else {
                if (operacao.equals("Editar")) {
                    disponibilidade.setId(id);
                    disponibilidade.salvar();
                } else {
                    if (operacao.equals("Excluir")) {
                        disponibilidade.setId(id);
                        disponibilidade.excluir();
                    }
                }
            }
        
            RequestDispatcher view = request.getRequestDispatcher("PesquisaDisponibilidadeController");
            view.forward(request, response);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw e;
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ManterDisponibilidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ManterDisponibilidadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
