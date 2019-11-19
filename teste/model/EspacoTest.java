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

    public class calculaTamanhoEspaco {

        @Test
        public void tamanhoInsuficiente() {
            Espaco espaco = new Espaco();
            assertEquals("Espaço insuficiente para o tipo desejado!", espaco.calculaTamanhoEspaco(19));
        }

        @Test
        public void tamanhoPequeno() {
            Espaco espaco = new Espaco();
            assertEquals("Espaço de pequeno porte, aconselhável ter no máximo 300 pessoas", espaco.calculaTamanhoEspaco(99));
        }

        @Test
        public void tamanhoMedio() {
            Espaco espaco = new Espaco();
            assertEquals("Espaço de médio porte, aconselhável ter no máximo 750 pessoas", espaco.calculaTamanhoEspaco(249));
        }

        @Test
        public void tamanhoGrande() {
            Espaco espaco = new Espaco();
            assertEquals("Espaço de grande porte, aconselhável ter no máximo 1000 pessoas", espaco.calculaTamanhoEspaco(319));
        }

        @Test
        public void tamanhoGrandeg() {
            Espaco espaco = new Espaco();
            assertEquals("Espaço de grande+ porte, aconselhável ter no máximo 1500 pessoas", espaco.calculaTamanhoEspaco(499));
        }

        @Test
        public void tamanhoGrandegg() {
            Espaco espaco = new Espaco();
            assertEquals("Espaço de grande++ porte, aconselhável ter no máximo 2300 pessoas", espaco.calculaTamanhoEspaco(749));
        }

        @Test
        public void tamanhoGrandeggg() {
            Espaco espaco = new Espaco();
            assertEquals("Espaço de grande+++ porte, aconselhável ter no máximo 3000 pessoas", espaco.calculaTamanhoEspaco(999));
        }

        @Test
        public void tamanhoExtraGrande() {
            Espaco espaco = new Espaco();

            assertEquals("Espaço de grande ex+ porte, aconselhável ter no máximo 6000 pessoas", espaco.calculaTamanhoEspaco(1999));
        }
    }

}
