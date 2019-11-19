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

    public class calculaDesconto {

        @Test
        public void semDesconto() {
            Pagamento pagamento = new Pagamento();
            assertEquals(49, pagamento.calculaTipoDesconto(49), 0.001);
        }

        @Test
        public void desconto10() {
            Pagamento pagamento = new Pagamento();
            assertEquals(89.1, pagamento.calculaTipoDesconto(99), 0.001);
        }

        @Test
        public void desconto15() {
            Pagamento pagamento = new Pagamento();

            assertEquals(126.65, pagamento.calculaTipoDesconto(149), 0.001);
        }

        @Test
        public void desconto20() {
            Pagamento pagamento = new Pagamento();
            assertEquals(159.2, pagamento.calculaTipoDesconto(199), 0.001);
        }

        @Test
        public void desconto25() {
            Pagamento pagamento = new Pagamento();
            assertEquals(224.25, pagamento.calculaTipoDesconto(299), 0.001);
        }

        @Test
        public void desconto30() {
            Pagamento pagamento = new Pagamento();
            assertEquals(210.7, pagamento.calculaTipoDesconto(301), 0.001);
        }
    }

}
