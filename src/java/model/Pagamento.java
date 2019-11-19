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

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public void salvar() throws SQLException, ClassNotFoundException, NoSuchMethodException {
        GenericoDAO.getInstance().salvar(this);
    }
    public void excluir() throws SQLException, ClassNotFoundException, NoSuchMethodException {
        GenericoDAO.getInstance().excluir(this);
    }

    public static Pagamento obterPagamento(Long id) throws SQLException, ClassNotFoundException {
        return (Pagamento) GenericoDAO.getInstance().get((long) id);
    }

    public static List<Object> obterTodosPagamentos() throws SQLException, ClassNotFoundException {
        return GenericoDAO.getInstance().getAll();
    }

    public double calculaTipoDesconto(double valorTotal){
        double valorDesconto=0;
        if (valorTotal>0) {
            if (valorTotal < 50) {
                System.out.println("Sem desconto. Valor será: " + valorTotal);
                return valorTotal;
            }
            else if (valorTotal < 100) {
                valorDesconto = valorTotal - ((valorTotal/100)*10);
                System.out.println("10% de desconto. Novo valor: "+valorDesconto);
                valorTotal= valorDesconto;
                return valorTotal;
            }
            else if (valorTotal < 150) {
                valorDesconto = valorTotal - ((valorTotal/100)*15);
                System.out.println("15% de desconto. Novo valor:  "+valorDesconto);
                valorTotal= valorDesconto;
                return valorTotal;
            }
            else if (valorTotal < 200) {
                valorDesconto = valorTotal - ((valorTotal/100)*20);
                System.out.println("20% de desconto. Novo valor:  "+valorDesconto);
                valorTotal= valorDesconto;
                return valorTotal;
            } 
            else if (valorTotal < 300) {
                valorDesconto = valorTotal - ((valorTotal/100)*25);
                System.out.println("25% de desconto. Novo valor:  "+valorDesconto);
                valorTotal= valorDesconto;
                return valorTotal;
            }else {
                valorDesconto = valorTotal - ((valorTotal/100)*30);
                System.out.println("30% de desconto. Novo valor:  "+valorDesconto);
                valorTotal= valorDesconto;
                return valorTotal;
            }
            
        }else{
        System.out.println("Valor total é inválido!");
        }
        return valorTotal;
        }
        
}
