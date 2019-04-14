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
import dao.DisponibilidadeDAO;
import dao.EspacoDAO;
import dao.IrregularidadeDAO;
import dao.ModalidadeDAO;
import dao.PagamentoDAO;
import dao.ReembolsoDAO;
import dao.ReservaDAO;
import dao.TipoEspacoDAO;
import model.Administrador;
import model.Cartao;
import model.Cliente;
import model.Contato;
import model.Disponibilidade;
import model.Espaco;
import model.Irregularidade;
import model.Modalidade;
import model.Pagamento;
import model.Reembolso;
import model.Reserva;
import model.TipoEspaco;

/**
 *
 * @author viict
 */
public class testeJPA {

    public static void main(String[] args) {

        /* Inicio De execução*/
   /*    Cliente cliente = new Cliente("Victor", "Torreões", "123456", "13/03/1994", "Andre@gmail.com", "Mamona");
        ClienteDAO.getInstance().salvar(cliente);

        Modalidade modalidade = new Modalidade("Skateros","Skateros de todo BR HUE");
        ModalidadeDAO.getInstance().salvar(modalidade);
        
         TipoEspaco tipoEspaco = new TipoEspaco("Outro", modalidade);
         TipoEspacoDAO.getInstance().salvar(tipoEspaco);
         
        Espaco espaco = new Espaco("Sportol", "12324", "36049120", "Alver juinoi", 123, "do outro lado", "esse mesmo", "juiz de fuera", "mg", 55.0, 450, "20:00", "06:00", tipoEspaco);
        EspacoDAO.getInstance().salvar(espaco);

        Disponibilidade disponibilidade = new Disponibilidade("20/12/2019", "10:00", "18:00", espaco);
         DisponibilidadeDAO.getInstance().salvar(disponibilidade);
        /*data, hinicio, hfim, qt pessoas, valor, nota, espaco, cliente*/
        
        
     /*   Reserva reserva = new Reserva("05/01/2020", "05:30", "55", (long) 7777, 55.5, (long) 88, cliente, espaco);
        ReservaDAO.getInstance().salvar(reserva);

        /*data, cod_barras, valor, reserva*/
     /* Pagamento p = new Pagamento("18/10/2019", "555.444.333.222", 5.0, reserva);
        PagamentoDAO.getInstance().salvar(p);

        Pagamento p2 = new Pagamento("20/10/2019", "777.666.555.444", 5000.0, reserva);
       PagamentoDAO.getInstance().salvar(p2);

        Pagamento p3 = new Pagamento("19/10/2019", "666.555.444.33", 50.0, reserva);
       PagamentoDAO.getInstance().salvar(p3);


        /*status , pagamento*/
   /*     Reembolso reembolso = new Reembolso("Aprovado", p);
        ReembolsoDAO.getInstance().salvar(reembolso);

        Reembolso reembolso2 = new Reembolso("Recusado", p2);
        ReembolsoDAO.getInstance().salvar(reembolso2);

        Reembolso reembolso3 = new Reembolso("Em análise", p3);
        ReembolsoDAO.getInstance().salvar(reembolso3);

        /*Fim Classe RESERVA, Reembolso e Pagamento*/
        
       Administrador admin = new Administrador("Iza","iza.ribeiro@lul.br",  "123");
         Administrador admin1 = new Administrador("Luis", "luis.gui@lul.br",  "123");
         Administrador admin2 = new Administrador("Victor", "victor.wagner@lul.br",  "123");
         AdministradorDAO.getInstance().salvar(admin);
         AdministradorDAO.getInstance().salvar(admin1);
         AdministradorDAO.getInstance().salvar(admin2);
       /* 
        Cliente cli1 = new Cliente("Izabella", "Ribeiro", "123545848", "22/02/1999", "iza@gmail.com", "123");
       Cliente cli2 = new Cliente("Victor", "Wagner", "123545848", "22/02/1999", "victor@gmail.com", "123");
       Cliente cli3 = new Cliente("Luis", "Zanovello", "123545848", "22/02/1999", "luis@gmail.com", "123");
       ClienteDAO.getInstance().salvar(cli1);
       ClienteDAO.getInstance().salvar(cli2);
       ClienteDAO.getInstance().salvar(cli3);
       
       Contato cont1 = new Contato("32133414", cli3);
       ContatoDAO.getInstance().salvar(cont1);
       
       Cartao cart1 = new Cartao("visa", "05/06/2026", "3442", cli3);
       CartaoDAO.getInstance().salvar(cart1);
      
         Contato contato = new Contato("321654", cliente);
         ContatoDAO.getInstance().salvar(contato);
         
         Cartao cartao = new Cartao("visa", "01/03/2022", "856", cliente);//Por que isso não funciona com Long????????????????????????????????AAAAAAAAAAAAAAAAAAAAHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
         CartaoDAO.getInstance().salvar(cartao);
        

       
     
        
         Irregularidade irregularidade = new Irregularidade("Matim", "Ocorreu o seguinte problema", espaco);
         IrregularidadeDAO.getInstance().salvar(irregularidade);
        
     */
        
        
    }

}
