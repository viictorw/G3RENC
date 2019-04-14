/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.EspacoDAO;
import dao.TipoEspacoDAO;
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
public class TipoEspaco {
    
    private static final long serialVersionUID = 1L;

    public static TipoEspaco obterTipoEspaco(long idtipoEspaco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;
    private String nome;
    @ManyToOne
    private Modalidade modalidade;

    public TipoEspaco() {
    }

    public TipoEspaco(String nome, Modalidade modalidade) {
        this.nome = nome;
        this.modalidade = modalidade;
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the modalidadePredominanteId
     */
      public void salvar() throws SQLException, ClassNotFoundException {
        TipoEspacoDAO.getInstance().salvar(this);
      }
    public void excluir() throws SQLException, ClassNotFoundException {
        TipoEspacoDAO.getInstance().excluir(this);
    }
    
    public static TipoEspaco obterEspaco(Long id) throws SQLException, ClassNotFoundException {
        return TipoEspacoDAO.getInstance().getTipoEspaco(id);
    }
    
    public static List<TipoEspaco> obterTodosTipoEspacos() throws SQLException, ClassNotFoundException {
        return TipoEspacoDAO.getInstance().getAllTipoEspacos();
    }
}
