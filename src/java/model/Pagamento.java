/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String vencimento;
    private String numeroCodBarras;
    private Double valorTotal;
    @ManyToOne
    private Reserva reserva;

    public Pagamento() {
    }

    
    
    public Pagamento(String vencimento, String numeroCodBarras, Double valorTotal, Reserva reserva) {
        this.vencimento = vencimento;
        this.numeroCodBarras = numeroCodBarras;
        this.valorTotal = valorTotal;
        this.reserva = reserva;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getNumeroCodBarras() {
        return numeroCodBarras;
    }

    public void setNumeroCodBarras(String numeroCodBarras) {
        this.numeroCodBarras = numeroCodBarras;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
