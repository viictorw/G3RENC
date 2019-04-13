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
 * @author iza
 */
@Entity
public class Disponibilidadee implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
     private Long id;
    private String dataDisponivel;
    private String hora_inicio;
    private String hora_fim;
     @ManyToOne
    private Espaco espaco;

    public Disponibilidadee() {
    }
    

    public Disponibilidadee(String dataDisponivel, String hora_inicio, String hora_fim, Espaco espaco) {
        this.dataDisponivel = dataDisponivel;
        this.hora_inicio = hora_inicio;
        this.hora_fim = hora_fim;
        this.espaco = espaco;
    }
    
    public Disponibilidadee(String dataDisponivel, String hora_inicio, String hora_fim) {
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


    
}
