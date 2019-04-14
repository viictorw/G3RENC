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
import model.Pagamento;
import model.Reserva;

/**
 *
 * @author viict
 */
//@WebServlet(name = "ManterPagamentoController", urlPatterns = {"/ManterPagamentoController"})
public class ManterPagamentoController extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {

        String acao = request.getParameter("acao");

        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);

        } else {
            if (acao.equals("prepararOperacao")) {
                prepararOperacao(request, response);
            }
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("reservas", Reserva.obterTodasReservas());

            if (!operacao.equals("Incluir")) {
                Pagamento pagamento = Pagamento.obterPagamento(Long.parseLong(request.getParameter("id")));
                request.setAttribute("pagamento", pagamento);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterPagamento.jsp");
            view.forward(request, response);

        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, ClassNotFoundException {
        String operacao = request.getParameter("operacao");

        String vencimento = request.getParameter("txtVencimentoPagamento");
        String numeroCodBarras = request.getParameter("txtCodBarrasPagamento");
        double valorTotal = Double.parseDouble(request.getParameter("txtValorTotalPagamento"));
        long idReservas = Long.parseLong(request.getParameter("idReservas"));
        Long id = null;
        if (!operacao.equals("Incluir")) {
            id = Long.parseLong(request.getParameter("id"));
        }

        try {
            Reserva reserva = null;
            if (idReservas != 0) {
                reserva = Reserva.obterReserva(idReservas);
            }

            Pagamento pagamento = new Pagamento(vencimento, numeroCodBarras, valorTotal, reserva);
            if (operacao.equals("Incluir")) {
                pagamento.salvar();
            } else {
                if (operacao.equals("Editar")) {
                    pagamento.setId(id);
                    pagamento.salvar();

                } else {
                    if (operacao.equals("Excluir")) {
                        pagamento.setId(id);
                        pagamento.excluir();

                    }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPagamentoController");
            view.forward(request, response);
        } catch (IOException e) {
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
