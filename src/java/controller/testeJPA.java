/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdministradorDAO;
import dao.CartaoDAO;
import dao.ClienteDAO;
import dao.ContatoDAO;
import dao.DisponibilidadeeDAO;
import dao.EspacoDAO;
import dao.IrregularidadeDAO;
import dao.ModalidadeDAO;
import dao.PagamentoDAO;
import dao.ReservaDAO;
import dao.TipoEspacoDAO;
import model.Administrador;
import model.Cartao;
import model.Cliente;
import model.Contato;
import model.Disponibilidadee;
import model.Espaco;
import model.Irregularidade;
import model.Modalidade;
import model.Pagamento;
import model.Reserva;
import model.TipoEspaco;

/**
 *
 * @author viict
 */
public class testeJPA {

    public static void main(String[] args) {

        

        /* Inicio Classe RESERVA*/
        
         Cliente cliente = new Cliente("Victor", "Torreões", "123456", "13/03/1994", "Andre@gmail.com", "Mamona");
         ClienteDAO dao = ClienteDAO.getInstance();
         dao.getInstance().salvar(cliente);

         Espaco espaco = new Espaco("Sportol", "12324", "36049120", "Alver juinoi", 123, "do outro lado", "esse mesmo", "juiz de fuera", "mg", 55.0, 450, "20:00", "06:00");
         EspacoDAO daoa = EspacoDAO.getInstance();
         daoa.getInstance().salvar(espaco);
         

        /*data, hinicio, hfim, qt pessoas, valor, nota, espaco, cliente*/
        
         Reserva reserva = new Reserva("05/01/2020", "05:30", "55", (long) 7777, 55.5, (long) 88, cliente, espaco);
         ReservaDAO.getInstance().salvar(reserva);
         
        
        /*data, cod_barras, valor, reserva*/ 
        Pagamento p2 = new Pagamento("20/10/2019", "777.666.555.444", 5000.0, reserva);
        PagamentoDAO.getInstance().salvar(p2);
        
        /*Fim Classe RESERVA e Pagamento*/
        
        /*
         Administrador admin = new Administrador("iza.ribeiro@lul.com", "Iza", "123");
         Administrador admin1 = new Administrador("luis.gui@lul.com", "Luis", "123");
         Administrador admin2 = new Administrador("victor.wagner@lul.com", "Victor", "123");
         AdministradorDAO.getInstance().salvar(admin);
         AdministradorDAO.getInstance().salvar(admin1);
         AdministradorDAO.getInstance().salvar(admin2);
        
        
       
      
         Contato contato = new Contato("321654", cliente);
         ContatoDAO.getInstance().salvar(contato);
         
         Cartao cartao = new Cartao("visa", "01/03/2022", "856", cliente);//Por que isso não funciona com Long????????????????????????????????AAAAAAAAAAAAAAAAAAAAHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
         CartaoDAO.getInstance().salvar(cartao);
        
         Disponibilidadee disponibilidade = new Disponibilidadee("20/12/2019", "10:00", "18:00");
         DisponibilidadeeDAO.getInstance().salvar(disponibilidade);
       
     
        
         Irregularidade irregularidade = new Irregularidade("Matim", "Ocorreu o seguinte problema", espaco);
         IrregularidadeDAO.getInstance().salvar(irregularidade);
        
         Modalidade modalidade = new Modalidade("Skateeee", "skaiteros");
         ModalidadeDAO.getInstance().salvar(modalidade);
        
         TipoEspaco tipoEspaco = new TipoEspaco("Graminha", modalidade);
         TipoEspacoDAO.getInstance().salvar(tipoEspaco);*/
    }

}
