/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DisponibilidadeDAO;
import dao.PagamentoDAO;
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
public class Disponibilidade implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
     private Long id;
    private String dataDisponivel;
    private String hora_inicio;
    private String hora_fim;
     @ManyToOne
    private Espaco espaco;

    public Disponibilidade() {
    }
    

    public Disponibilidade(String dataDisponivel, String hora_inicio, String hora_fim, Espaco espaco) {
        this.dataDisponivel = dataDisponivel;
        this.hora_inicio = hora_inicio;
        this.hora_fim = hora_fim;
        this.espaco = espaco;
    }
    
    public Disponibilidade(String dataDisponivel, String hora_inicio, String hora_fim) {
        this.dataDisponivel = dataDisponivel;
        this.hora_inicio = hora_inicio;
        this.hora_fim = hora_fim;
    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataDisponivel() {
        return dataDisponivel;
    }

    public void setDataDisponivel(String dataDisponivel) {
        this.dataDisponivel = dataDisponivel;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(String hora_fim) {
        this.hora_fim = hora_fim;
    }

    public void salvar() throws SQLException, ClassNotFoundException {
            DisponibilidadeDAO.getInstance().salvar(this);
    }
    public void excluir() throws SQLException, ClassNotFoundException {
            DisponibilidadeDAO.getInstance().excluir(this);
        }

    public static Disponibilidade obterDisponibilidade(Long id) throws SQLException, ClassNotFoundException {
        return DisponibilidadeDAO.getInstance().getDisponibilidade((long) id);
    }

    public static List<Disponibilidade> obterTodasDisponibilidades() throws SQLException, ClassNotFoundException {
        return DisponibilidadeDAO.getInstance().getAllDisponibilidades();
    }
    
}
