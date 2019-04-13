/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AdministradorDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




/**
 *
 * @author viict
 */
@Entity
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    private String senha;

    public Administrador() {
    }

    public Administrador(String email, String nome, String senha) {

        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void salvar() throws SQLException, ClassNotFoundException {
        AdministradorDAO.getInstance().salvar(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException {
        AdministradorDAO.getInstance().excluir(this);
    }
    
    public static Administrador obterAdministrador(Long id) throws SQLException, ClassNotFoundException {
        return AdministradorDAO.getInstance().getAdministrador((long) id);
    }
    
    public static List<Administrador> obterTodosAdministradores() throws SQLException, ClassNotFoundException {
        return AdministradorDAO.getInstance().getAllAdministradores();
    }
    
   public static Administrador logar(String email, String senha) throws ClassNotFoundException {
        return AdministradorDAO.logar(email, senha);
    }
    

}
