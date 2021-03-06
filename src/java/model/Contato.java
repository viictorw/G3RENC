/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Contato;
import dao.Base;
import dao.GenericoDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author iza
 */
@Entity
public class Contato implements  Base, Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;
    private String numero;
    @ManyToOne
    private Cliente cliente;

    public Contato(){
        
    }
    
    public Contato(String numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }



    public Contato(long id, String numero) {
        this.id = id;
        this.numero = numero;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public Contato setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }


    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
    
    public void gravar() throws SQLException, ClassNotFoundException, NoSuchMethodException {
        GenericoDAO.getInstance().salvar(this);
    }
           
    
    public void excluir() throws SQLException, ClassNotFoundException, NoSuchMethodException {
        GenericoDAO.getInstance().excluir(this);
    }

    public static  Contato obterContato(Long id) throws SQLException, ClassNotFoundException {
        return (Contato) GenericoDAO.getInstance().get((long) id);
    }

    public static List<Object> obterTodosContatos() throws SQLException, ClassNotFoundException {
        return GenericoDAO.getInstance().getAll();
    }
}
