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
public class Espaco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String nome;
    private String cnpj;
    private String cep;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private Double area;
    private Integer quantidadePessoas;
    private String horaFuncionamentoInicio;
    private String horaFuncionamentoFinal;
    @ManyToOne
    private TipoEspaco tipoEspaco;

    public Espaco() {
    }

    public Espaco(String nome, String cnpj, String cep, String logradouro, Integer numero, String complemento, String bairro, String cidade, String uf, Double area, Integer quantidadePessoas, String horaFuncionamentoInicio, String horaFuncionamentoFinal, TipoEspaco tipoEspaco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.area = area;
        this.quantidadePessoas = quantidadePessoas;
        this.horaFuncionamentoInicio = horaFuncionamentoInicio;
        this.horaFuncionamentoFinal = horaFuncionamentoFinal;
        this.tipoEspaco = tipoEspaco;
    }

    public TipoEspaco getTipoEspaco() {
        return tipoEspaco;
    }

    public void setTipoEspaco(TipoEspaco tipoEspaco) {
        this.tipoEspaco = tipoEspaco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(Integer quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public String getHoraFuncionamentoInicio() {
        return horaFuncionamentoInicio;
    }

    public void setHoraFuncionamentoInicio(String horaFuncionamentoInicio) {
        this.horaFuncionamentoInicio = horaFuncionamentoInicio;
    }

    public String getHoraFuncionamentoFinal() {
        return horaFuncionamentoFinal;
    }

    public void setHoraFuncionamentoFinal(String horaFuncionamentoFinal) {
        this.horaFuncionamentoFinal = horaFuncionamentoFinal;
    }

    public void salvar() throws SQLException, ClassNotFoundException, NoSuchMethodException {
        GenericoDAO.getInstance().salvar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException, NoSuchMethodException {
        GenericoDAO.getInstance().excluir(this);
    }

    public static Espaco obterEspaco(Long id) throws SQLException, ClassNotFoundException {
        return (Espaco) GenericoDAO.getInstance().get((long) id);
    }

    public static List<Object> obterTodosEspacos() throws SQLException, ClassNotFoundException {
        return GenericoDAO.getInstance().getAll();
    }

    public void calculaTamanhoEspaco(int area) {
        if (area>0) {
            if (area < 20) {
                System.out.println("Espaço insuficiente para o tipo desejado!");
            }
            else if (area < 100) {
                System.out.println("Espaço de pequeno porte, aconselhável ter no máximo 300 pessoas");
            }
            else if (area < 250) {
                System.out.println("Espaço de médio porte, aconselhável ter no máximo 750 pessoas");
            }
            else if (area < 320) {
                System.out.println("Espaço de grande porte, aconselhável ter no máximo 1000 pessoas");
            } 
            else if (area < 500) {
                System.out.println("Espaço de grande+ porte, aconselhável ter no máximo 1500 pessoas");
            }
            else if (area < 750) {
                System.out.println("Espaço de grande++ porte, aconselhável ter no máximo 2300 pessoas");
            }
            else if (area < 1000) {
                System.out.println("Espaço de grande+++ porte, aconselhável ter no máximo 3000 pessoas");
            }
            else if (area < 2000) {
                System.out.println("Espaço de grande ex+ porte, aconselhável ter no máximo 6000 pessoas");
            }
            else {
                System.out.println("Espaço acima do padrão, determinação para quantidades de pessoas passará a ser estabelecida por ambiente sobre administração responsável.");
            }
            
        }else{
        System.err.println("Espaço inválido!");
        }
    }
    public void calculaSeguranca(int quantidadePessoas){
        if (quantidadePessoas>0) {
            if (quantidadePessoas < 50) {
                System.out.println("Poucas pessoas,portanto não será feito cálculo da quantidade de seguranças!");
            }
            else if (quantidadePessoas < 90) {
                System.out.println("Evento de pequeno porte, aconselhável ter 5 seguranças");
            }
            else if (quantidadePessoas < 150) {
                System.out.println("Evento de médio porte, aconselhável ter entre 6 e 10 seguranças");
            }
            else if (quantidadePessoas < 250) {
                System.out.println("Evento de grande porte, aconselhável ter entre 11 e 15 seguranças");
            } 
            else if (quantidadePessoas < 550) {
                System.out.println("Evento de grande+ porte, aconselhável ter entre 16 e 25 seguranças");
            }
            else if (quantidadePessoas < 750) {
                System.out.println("Evento de grande++ porte, aconselhável ter entre 21 e 30 seguranças");
            }
            else if (quantidadePessoas < 1250) {
                System.out.println("Evento de grande+++ porte, aconselhável ter entre 31 e 50 seguranças");
            }
            else if (quantidadePessoas < 3250) {
                System.out.println("Evento de grande ex+ porte, aconselhável ter mais do que 50 seguranças");
            }
            else {
                System.out.println("Evento acima das Normas, portanto, a determinação para quantidades de seguranças passará a ser estabelecida por ambiente sobre administração responsável.");
            }
            
        }else{
        System.err.println("Quantidade de pessoas é inválido!");
        }
    }

}
