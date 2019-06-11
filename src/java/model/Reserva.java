/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
 * @author viict
 */
@Entity
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
    private String dataLocacao;
    private String horaInicioLocacao;
    
    private String horaFimLocacao;
    private Long qtPessoas;
    private Double valorLocacao;
    private Long notaAvaliacao;
    @ManyToOne
    private Espaco espaco;
    @ManyToOne
    private Cliente cliente;
    
    
    
    public Reserva() {
    }

    public Reserva( String dataLocacao, String horaInicioLocacao, String horaFimLocacao, Long qtPessoas, Double valorLocacao, Long notaAvaliacao, Cliente cliente, Espaco espaco) {
        this.dataLocacao = dataLocacao;
        this.horaInicioLocacao = horaInicioLocacao;
        this.horaFimLocacao = horaFimLocacao;
        this.qtPessoas = qtPessoas;
        this.valorLocacao = valorLocacao;
        this.notaAvaliacao = notaAvaliacao;
        this.espaco = espaco;
        this.cliente = cliente;
    }

/*
    public double totalLocacao()
    {
        double totalValor;
        totalValor=(hInicio - hFim) * valorLocacao;
        return totalValor;
        
    }
 */

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public String getHoraInicioLocacao() {
        return horaInicioLocacao;
    }

    public void setHoraInicioLocacao(String horaInicioLocacao) {
        this.horaInicioLocacao = horaInicioLocacao;
    }

    public String getHoraFimLocacao() {
        return horaFimLocacao;
    }

    public void setHoraFimLocacao(String horaFimLocacao) {
        this.horaFimLocacao = horaFimLocacao;
    }

    public Long getQtPessoas() {
        return qtPessoas;
    }

    public void setQtPessoas(Long qtPessoas) {
        this.qtPessoas = qtPessoas;
    }

    public Double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(Double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public Long getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public void setNotaAvaliacao(Long notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
       public void salvar() throws SQLException, ClassNotFoundException, NoSuchMethodException {
        GenericoDAO.getInstance().salvar(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException, NoSuchMethodException {
        GenericoDAO.getInstance().excluir(this);
    }
    
    public static Reserva obterReserva (Long id) throws SQLException, ClassNotFoundException {
        return (Reserva) GenericoDAO.getInstance().get((long) id);
    }
    
    public static List<Object> obterTodasReservas() throws SQLException, ClassNotFoundException {
        return GenericoDAO.getInstance().getAll();
                }

}
