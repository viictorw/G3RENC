/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ReembolsoDAO;
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
 * @author viict
 */
@Entity

public class Reembolso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String estado;
    @ManyToOne
    private Pagamento pagamento;

    public Reembolso() {
    }

    public Reembolso(String estado, Pagamento pagamento) {
        this.estado = estado;
        this.pagamento = pagamento;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

       public void salvar() throws SQLException, ClassNotFoundException {
        ReembolsoDAO.getInstance().salvar(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException {
        ReembolsoDAO.getInstance().excluir(this);
    }
    
    public static Reembolso obterReembolso(Long id) throws SQLException, ClassNotFoundException {
        return ReembolsoDAO.getInstance().getReembolso(id);
    }
    
    public static List<Reembolso> obterTodosReembolsos() throws SQLException, ClassNotFoundException {
        return ReembolsoDAO.getInstance().getAllReembolsos();
                }
    
}
