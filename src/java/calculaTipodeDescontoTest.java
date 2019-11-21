
import static junit.framework.Assert.assertEquals;
import model.Pagamento;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pichau
 */
public class calculaTipodeDescontoTest {
    
        @Test
        public static void semDesconto() {
            Pagamento pagamento = new Pagamento();
            assertEquals(49, pagamento.calculaTipodeDesconto(49), 0.001);
        }

        @Test
        public static void desconto10() {
            Pagamento pagamento = new Pagamento();
            assertEquals(89.1, pagamento.calculaTipodeDesconto(99), 0.001);
        }

        @Test
        public static void desconto15() {
            Pagamento pagamento = new Pagamento();

            assertEquals(126.65, pagamento.calculaTipodeDesconto(149), 0.001);
        }

        @Test
        public static void desconto20() {
            Pagamento pagamento = new Pagamento();
            assertEquals(159.2, pagamento.calculaTipodeDesconto(199), 0.001);
        }

        @Test
        public static void desconto25() {
            Pagamento pagamento = new Pagamento();
            assertEquals(224.25, pagamento.calculaTipodeDesconto(299), 0.001);
        }

        @Test
        public static void desconto30() {
            Pagamento pagamento = new Pagamento();
            assertEquals(210.7, pagamento.calculaTipodeDesconto(301), 0.001);
        }
    }
