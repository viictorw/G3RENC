/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ModalidadeDAO;
import dao.PagamentoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author iza
 */

@Entity
public class Modalidade {
    
            private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;
    private String modalidade;
    private String descricao;

    public Modalidade() {
    }

    public Modalidade(String modalidade, String descricao) {
        this.modalidade = modalidade;
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

    /**
     * @return the modalidadePredominante
     */
    public String getModalidade() {
        return modalidade;
    }

    /**
     * @param modalidade
     */
    public void setModalidade(String modalidade) {    
        this.modalidade = modalidade;
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
        ModalidadeDAO.getInstance().salvar(this);
}
public void excluir() throws SQLException, ClassNotFoundException {
        ModalidadeDAO.getInstance().excluir(this);
    }

    public static Modalidade obterModalidade(Long id) throws SQLException, ClassNotFoundException {
        return ModalidadeDAO.getInstance().getModalidade(id);
    }

    public static List<Modalidade> obterTodasModalidades() throws SQLException, ClassNotFoundException {
        return ModalidadeDAO.getInstance().getAllModalidades();
    }
}
