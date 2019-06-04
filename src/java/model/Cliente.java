/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ClienteDAO;
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
public class Cliente implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String dataNascimento;
    private String email;
    private String senha;
   

    public Cliente() {
    }

    public Cliente(String nome, String sobrenome, String dataNascimento,  String email,String cpf, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public static Cliente logar(String email, String senha) throws ClassNotFoundException {
        return ClienteDAO.logar(email, senha);
    }
      public void gravar() throws SQLException, ClassNotFoundException{
        ClienteDAO.getInstance().salvar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException{
        ClienteDAO.getInstance().excluir(this);
    }
    public static Cliente obterCliente(Long id) throws SQLException, ClassNotFoundException{
        return ClienteDAO.getInstance().getCliente(id);
    }
    public static List<Cliente> obterTodosOsClientes() throws SQLException, ClassNotFoundException{
        return ClienteDAO.getInstance().getAllClientes();
    }

}
