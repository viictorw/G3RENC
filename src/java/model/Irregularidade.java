/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.IrregularidadeDAO;
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
public class Irregularidade {

        private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String autor;
    private String descricao;
    @ManyToOne
    private Espaco espaco;

    public Irregularidade() {
    }

    public Irregularidade(String autor, String descricao, Espaco espaco) {
        this.autor = autor;
        this.descricao = descricao;
        this.espaco = espaco;
    }

     public Irregularidade(String autor, String descricao) {
        this.autor = autor;
        this.descricao = descricao;
    }
  

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
  public void salvar() throws SQLException, ClassNotFoundException {
        IrregularidadeDAO.getInstance().salvar(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException {
        IrregularidadeDAO.getInstance().excluir(this);
    }
    
    public static Irregularidade obterIrregularidade(Long id) throws SQLException, ClassNotFoundException {
        return IrregularidadeDAO.getInstance().getIrregularidade((long) id);
    }
    
    public static List<Irregularidade> obterTodasIrregularidades() throws SQLException, ClassNotFoundException {
        return IrregularidadeDAO.getInstance().getAllIrregularidades();
    }

}


