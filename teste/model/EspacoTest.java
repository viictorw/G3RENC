/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.After;
import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import java.util.List;
import static org.eclipse.persistence.jpa.jpql.Assert.fail;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 *
 * @author luisg
 */
public class EspacoTest {
    
    public EspacoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    

    public void setUp() {
    }
    

    public void tearDown() {
    }

    /**
     * Test of getTipoEspaco method, of class Espaco.
     */
    @Test
    public void testGetTipoEspaco() {
        System.out.println("getTipoEspaco");
        Espaco instance = new Espaco();
        TipoEspaco expResult = null;
        TipoEspaco result = instance.getTipoEspaco();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipoEspaco method, of class Espaco.
     */
    @Test
    public void testSetTipoEspaco() {
        System.out.println("setTipoEspaco");
        TipoEspaco tipoEspaco = null;
        Espaco instance = new Espaco();
        instance.setTipoEspaco(tipoEspaco);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Espaco.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Espaco instance = new Espaco();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Espaco.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Espaco instance = new Espaco();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class Espaco.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Espaco instance = new Espaco();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class Espaco.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Espaco instance = new Espaco();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCnpj method, of class Espaco.
     */
    @Test
    public void testGetCnpj() {
        System.out.println("getCnpj");
        Espaco instance = new Espaco();
        String expResult = "";
        String result = instance.getCnpj();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCnpj method, of class Espaco.
     */
    @Test
    public void testSetCnpj() {
        System.out.println("setCnpj");
        String cnpj = "";
        Espaco instance = new Espaco();
        instance.setCnpj(cnpj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCep method, of class Espaco.
     */
    @Test
    public void testGetCep() {
        System.out.println("getCep");
        Espaco instance = new Espaco();
        String expResult = "";
        String result = instance.getCep();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCep method, of class Espaco.
     */
    @Test
    public void testSetCep() {
        System.out.println("setCep");
        String cep = "";
        Espaco instance = new Espaco();
        instance.setCep(cep);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLogradouro method, of class Espaco.
     */
    @Test
    public void testGetLogradouro() {
        System.out.println("getLogradouro");
        Espaco instance = new Espaco();
        String expResult = "";
        String result = instance.getLogradouro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLogradouro method, of class Espaco.
     */
    @Test
    public void testSetLogradouro() {
        System.out.println("setLogradouro");
        String logradouro = "";
        Espaco instance = new Espaco();
        instance.setLogradouro(logradouro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumero method, of class Espaco.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        Espaco instance = new Espaco();
        Integer expResult = null;
        Integer result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumero method, of class Espaco.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        Integer numero = null;
        Espaco instance = new Espaco();
        instance.setNumero(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComplemento method, of class Espaco.
     */
    @Test
    public void testGetComplemento() {
        System.out.println("getComplemento");
        Espaco instance = new Espaco();
        String expResult = "";
        String result = instance.getComplemento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComplemento method, of class Espaco.
     */
    @Test
    public void testSetComplemento() {
        System.out.println("setComplemento");
        String complemento = "";
        Espaco instance = new Espaco();
        instance.setComplemento(complemento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBairro method, of class Espaco.
     */
    @Test
    public void testGetBairro() {
        System.out.println("getBairro");
        Espaco instance = new Espaco();
        String expResult = "";
        String result = instance.getBairro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBairro method, of class Espaco.
     */
    @Test
    public void testSetBairro() {
        System.out.println("setBairro");
        String bairro = "";
        Espaco instance = new Espaco();
        instance.setBairro(bairro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCidade method, of class Espaco.
     */
    @Test
    public void testGetCidade() {
        System.out.println("getCidade");
        Espaco instance = new Espaco();
        String expResult = "";
        String result = instance.getCidade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCidade method, of class Espaco.
     */
    @Test
    public void testSetCidade() {
        System.out.println("setCidade");
        String cidade = "";
        Espaco instance = new Espaco();
        instance.setCidade(cidade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUf method, of class Espaco.
     */
    @Test
    public void testGetUf() {
        System.out.println("getUf");
        Espaco instance = new Espaco();
        String expResult = "";
        String result = instance.getUf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUf method, of class Espaco.
     */
    @Test
    public void testSetUf() {
        System.out.println("setUf");
        String uf = "";
        Espaco instance = new Espaco();
        instance.setUf(uf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArea method, of class Espaco.
     */
    @Test
    public void testGetArea() {
        System.out.println("getArea");
        Espaco instance = new Espaco();
        Double expResult = null;
        Double result = instance.getArea();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArea method, of class Espaco.
     */
    @Test
    public void testSetArea() {
        System.out.println("setArea");
        Double area = null;
        Espaco instance = new Espaco();
        instance.setArea(area);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantidadePessoas method, of class Espaco.
     */
    @Test
    public void testGetQuantidadePessoas() {
        System.out.println("getQuantidadePessoas");
        Espaco instance = new Espaco();
        Integer expResult = null;
        Integer result = instance.getQuantidadePessoas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantidadePessoas method, of class Espaco.
     */
    @Test
    public void testSetQuantidadePessoas() {
        System.out.println("setQuantidadePessoas");
        Integer quantidadePessoas = null;
        Espaco instance = new Espaco();
        instance.setQuantidadePessoas(quantidadePessoas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHoraFuncionamentoInicio method, of class Espaco.
     */
    @Test
    public void testGetHoraFuncionamentoInicio() {
        System.out.println("getHoraFuncionamentoInicio");
        Espaco instance = new Espaco();
        String expResult = "";
        String result = instance.getHoraFuncionamentoInicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHoraFuncionamentoInicio method, of class Espaco.
     */
    @Test
    public void testSetHoraFuncionamentoInicio() {
        System.out.println("setHoraFuncionamentoInicio");
        String horaFuncionamentoInicio = "";
        Espaco instance = new Espaco();
        instance.setHoraFuncionamentoInicio(horaFuncionamentoInicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHoraFuncionamentoFinal method, of class Espaco.
     */
    @Test
    public void testGetHoraFuncionamentoFinal() {
        System.out.println("getHoraFuncionamentoFinal");
        Espaco instance = new Espaco();
        String expResult = "";
        String result = instance.getHoraFuncionamentoFinal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHoraFuncionamentoFinal method, of class Espaco.
     */
    @Test
    public void testSetHoraFuncionamentoFinal() {
        System.out.println("setHoraFuncionamentoFinal");
        String horaFuncionamentoFinal = "";
        Espaco instance = new Espaco();
        instance.setHoraFuncionamentoFinal(horaFuncionamentoFinal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvar method, of class Espaco.
     */
    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        Espaco instance = new Espaco();
        instance.salvar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class Espaco.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        Espaco instance = new Espaco();
        instance.excluir();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obterEspaco method, of class Espaco.
     */
    @Test
    public void testObterEspaco() throws Exception {
        System.out.println("obterEspaco");
        Long id = null;
        Espaco expResult = null;
        Espaco result = Espaco.obterEspaco(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obterTodosEspacos method, of class Espaco.
     */
    @Test
    public void testObterTodosEspacos() throws Exception {
        System.out.println("obterTodosEspacos");
        List<Object> expResult = null;
        List<Object> result = Espaco.obterTodosEspacos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculaTamanhoEspaco method, of class Espaco.
     */
    @Test
    public void testCalculaTamanhoEspaco() {
        System.out.println("calculaTamanhoEspaco");
        int area = 0;
        Espaco instance = new Espaco();
        instance.calculaTamanhoEspaco(area);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculaSeguranca method, of class Espaco.
     */
    @Test
    public void testCalculaSeguranca() {
        System.out.println("calculaSeguranca");
        int quantidadePessoas = 0;
        Espaco instance = new Espaco();
        instance.calculaSeguranca(quantidadePessoas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
