/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Reserva;
import model.Cliente;
import model.Espaco;

/**
 *
 * @author viict
 */
public class ManterReservaController extends HttpServlet {

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
            throws ServletException, IOException {

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
            request.setAttribute("espacos", Espaco.obterTodosEspacos());
            request.setAttribute("clientes", Cliente.obterTodosOsClientes());

            if (!operacao.equals("Incluir")) {
                long id = Long.parseLong(request.getParameter("id").trim());
                Reserva reserva = Reserva.obterReserva((long) id);
                request.setAttribute("reserva", reserva);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterReserva.jsp");
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

    
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String operacao = request.getParameter("operacao");

        String dataLocacao = request.getParameter("txtDataLocacao");
        String horaInicioLocacao = request.getParameter("txtHrInicio");
        String horaFimLocacao = request.getParameter("txtHrFim");
        Long qtPessoas = Long.parseLong(request.getParameter("txtqtPessoas"));
        double valorLocacao = Double.parseDouble(request.getParameter("txtvalorLocacao"));
        long notaAvaliacao = Long.parseLong(request.getParameter("txtAvaliacao"));
        long idClientes = Long.parseLong(request.getParameter("optCliente"));
        long idEspacos = Long.parseLong(request.getParameter("optEspaco"));

          Long id = null;
        if (!operacao.equals("Incluir")) {
            id = Long.parseLong(request.getParameter("id"));
        }
        
        try {
            Cliente cliente = null;
            Espaco espaco = null;

            if (idClientes != 0) {

                cliente = Cliente.obterCliente(idClientes);
                
            }
            
            if(idEspacos != 0){
                espaco = Espaco.obterEspaco(idEspacos);
            }
            
            Reserva reserva = new Reserva(dataLocacao, horaInicioLocacao, horaFimLocacao, qtPessoas, valorLocacao, notaAvaliacao, cliente, espaco);
            if (operacao.equals("Incluir")) {
                reserva.salvar();
            } else {
                if (operacao.equals("Editar")) {
                    reserva.setId(id);
                    reserva.salvar();
                } else {
                    if (operacao.equals("Excluir")) {
                        reserva.setId(id);
                        reserva.excluir();
                    }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaReservaController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
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
        processRequest(request, response);
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
        processRequest(request, response);
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
