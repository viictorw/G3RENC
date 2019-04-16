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
import model.Cartao;
import model.Cliente;

/**
 *
 * @author iza Ribeiro
 */
/*@WebServlet(name = "ManterCartaoController", urlPatterns = {"/ManterCartaoController"})*/
public class ManterCartaoController extends HttpServlet {

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
        request.setAttribute("clientes", Cliente.obterTodosOsClientes());
        
        if(!operacao.equals("Incluir")){
             Cartao cartao = Cartao.obterCartao(Long.parseLong(request.getParameter("id")));
            request.setAttribute("cartao", cartao);
        }
                RequestDispatcher view = request.getRequestDispatcher("/manterCartao.jsp");
                view.forward(request, response);
                
    }catch(ServletException e){
                throw e;
            }catch(IOException e){
                throw new ServletException(e);
            }catch(SQLException e){
                throw new ServletException(e);
            }catch(ClassNotFoundException e){
                throw new ServletException(e);
            }
    }
    
       public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException  {
        String operacao = request.getParameter("operacao");
        
        Long id = null;
        long numero = Long.parseLong(request.getParameter("txtNumeroCartao"));
        String bandeira = request.getParameter("txtBandeiraCartao");
        String validade = request.getParameter("txtValidadeCartao");
        String codSeguranca = request.getParameter("txtCodCartao");
         long idCliente = Long.parseLong(request.getParameter("idClientes"));
         if (!operacao.equals("Incluir")) {
            id = Long.parseLong(request.getParameter("id"));
        }
        
        
        try {
            Cliente cliente = null;
            if (idCliente != 0) {
                cliente = Cliente.obterCliente(idCliente);
            }     
            
            Cartao cartao = new Cartao(bandeira, validade, numero, codSeguranca, cliente);
            if (operacao.equals("Incluir")) {
                cartao.gravar();
            } else {
                if (operacao.equals("Editar")) {
                    cartao.setId(id);
                    cartao.gravar();
                } else {
                    if (operacao.equals("Excluir")) {
                        cartao.setId(id);
                        cartao.excluir();
                    }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaCartaoController");
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

         try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterAdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterAdministradorController.class.getName()).log(Level.SEVERE, null, ex);
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
