/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class Cartao {
    
        private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;
    private String bandeira;
    private String validade;
    private Long numeroCartao;
    private String codigoSeguranca;
    @ManyToOne
    private Cliente cliente;
    
    public Cartao(){
        
    }

    public Cartao(String bandeira, String validade, Long numeroCartao, String codigoSeguranca, Cliente cliente) {
        this.bandeira = bandeira;
        this.validade = validade;
        this.numeroCartao = numeroCartao;
        this.codigoSeguranca = codigoSeguranca;
        this.cliente = cliente;
    }
    
    public Cartao(String bandeira, String validade, String codigoSeguranca, Cliente cliente) {
        this.bandeira = bandeira;
        this.validade = validade;
        this.codigoSeguranca = codigoSeguranca;
        this.cliente = cliente;
    }



    public Cliente getCliente() {
        return cliente;
    }

    public Cartao setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public Cartao(Long id, String bandeira, String validade, Long numeroCartao, String codigoSeguranca) {
       this.id = id;
        this.bandeira = bandeira;
        this.validade = validade;
        this.numeroCartao = numeroCartao;
       this.codigoSeguranca = codigoSeguranca;
    }

    public Long getId() {
        return id;
    }

    public Cartao setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBandeira() {
        return bandeira;
    }

    public Cartao setBandeira(String bandeira) {
        this.bandeira = bandeira;
        return this;
    }

    public String getValidade() {
        return validade;
    }

    public Cartao setValidade(String validade) {
        this.validade = validade;
        return this;
    }

    public Long getNumeroCartao() {
        return numeroCartao;
    }

    public Cartao setNumeroCartao(Long numeroCartao) {
        this.numeroCartao = numeroCartao;
        return this;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public void setIdCliente(long cliente) {

    }


}
