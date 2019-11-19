/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class PagamentoTest {
    
    public PagamentoTest() {
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
     * Test of getId method, of class Pagamento.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Pagamento instance = new Pagamento();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Pagamento.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Pagamento instance = new Pagamento();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVencimento method, of class Pagamento.
     */
    @Test
    public void testGetVencimento() {
        System.out.println("getVencimento");
        Pagamento instance = new Pagamento();
        String expResult = "";
        String result = instance.getVencimento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVencimento method, of class Pagamento.
     */
    @Test
    public void testSetVencimento() {
        System.out.println("setVencimento");
        String vencimento = "";
        Pagamento instance = new Pagamento();
        instance.setVencimento(vencimento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumeroCodBarras method, of class Pagamento.
     */
    @Test
    public void testGetNumeroCodBarras() {
        System.out.println("getNumeroCodBarras");
        Pagamento instance = new Pagamento();
        String expResult = "";
        String result = instance.getNumeroCodBarras();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumeroCodBarras method, of class Pagamento.
     */
    @Test
    public void testSetNumeroCodBarras() {
        System.out.println("setNumeroCodBarras");
        String numeroCodBarras = "";
        Pagamento instance = new Pagamento();
        instance.setNumeroCodBarras(numeroCodBarras);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReserva method, of class Pagamento.
     */
    @Test
    public void testGetReserva() {
        System.out.println("getReserva");
        Pagamento instance = new Pagamento();
        Reserva expResult = null;
        Reserva result = instance.getReserva();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReserva method, of class Pagamento.
     */
    @Test
    public void testSetReserva() {
        System.out.println("setReserva");
        Reserva reserva = null;
        Pagamento instance = new Pagamento();
        instance.setReserva(reserva);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValorTotal method, of class Pagamento.
     */
    @Test
    public void testGetValorTotal() {
        System.out.println("getValorTotal");
        Pagamento instance = new Pagamento();
        Double expResult = null;
        Double result = instance.getValorTotal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValorTotal method, of class Pagamento.
     */
    @Test
    public void testSetValorTotal() {
        System.out.println("setValorTotal");
        Double valorTotal = null;
        Pagamento instance = new Pagamento();
        instance.setValorTotal(valorTotal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvar method, of class Pagamento.
     */
    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        Pagamento instance = new Pagamento();
        instance.salvar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class Pagamento.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        Pagamento instance = new Pagamento();
        instance.excluir();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obterPagamento method, of class Pagamento.
     */
    @Test
    public void testObterPagamento() throws Exception {
        System.out.println("obterPagamento");
        Long id = null;
        Pagamento expResult = null;
        Pagamento result = Pagamento.obterPagamento(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obterTodosPagamentos method, of class Pagamento.
     */
    @Test
    public void testObterTodosPagamentos() throws Exception {
        System.out.println("obterTodosPagamentos");
        List<Object> expResult = null;
        List<Object> result = Pagamento.obterTodosPagamentos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculaTipoDesconto method, of class Pagamento.
     */
    @Test
    public void testCalculaTipoDesconto() {
        System.out.println("calculaTipoDesconto");
        double valorTotal = 0.0;
        Pagamento instance = new Pagamento();
        double expResult = 0.0;
        double result = instance.calculaTipoDesconto(valorTotal);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
