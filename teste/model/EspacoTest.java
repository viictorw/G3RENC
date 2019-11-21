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

        @Test
        public void tamanhoAcimaPadrao() {
            Espaco espaco = new Espaco();

            assertEquals("Espaço acima do padrão, determinação para quantidades de pessoas passará a ser estabelecida por ambiente sobre administração responsável.", espaco.calculaTamanhoEspaco(2000));
        }

        public void espacoInvalido() {
            Espaco espaco = new Espaco();

            assertEquals("Espaço inválido!", espaco.calculaTamanhoEspaco(-1));
        }
    }

    public class calculaSeguranca {

        @Test
        public void poucasPessoas() {
            Espaco espaco = new Espaco();

            assertEquals("Poucas pessoas,portanto não será feito cálculo da quantidade de seguranças!", espaco.calculaSeguranca(49));
        }

        @Test
        public void pequenoPorte() {
            Espaco espaco = new Espaco();

            assertEquals("Evento de pequeno porte, aconselhável ter 5 seguranças", espaco.calculaSeguranca(89));
        }

        @Test
        public void medioPorte() {
            Espaco espaco = new Espaco();

            assertEquals("Evento de médio porte, aconselhável ter entre 6 e 10 seguranças", espaco.calculaSeguranca(149));
        }

        @Test
        public void grandePorte() {
            Espaco espaco = new Espaco();

            assertEquals("Evento de grande porte, aconselhável ter entre 11 e 15 seguranças", espaco.calculaSeguranca(249));
        }

        @Test
        public void grandegPorte() {
            Espaco espaco = new Espaco();

            assertEquals("Evento de grande+ porte, aconselhável ter entre 16 e 25 seguranças", espaco.calculaSeguranca(549));
        }

        @Test
        public void grandeggPorte() {
            Espaco espaco = new Espaco();

            assertEquals("Evento de grande++ porte, aconselhável ter entre 21 e 30 seguranças", espaco.calculaSeguranca(749));
        }

        @Test
        public void grandegggPorte() {
            Espaco espaco = new Espaco();

            assertEquals("Evento de grande+++ porte, aconselhável ter entre 31 e 50 seguranças", espaco.calculaSeguranca(1249));
        }

        @Test
        public void extragrandePorte() {
            Espaco espaco = new Espaco();

            assertEquals("Evento de grande ex+ porte, aconselhável ter mais do que 50 seguranças", espaco.calculaSeguranca(3249));
        }
        @Test
        public void  acimaNormas() {
        Espaco espaco = new Espaco();
      
        assertEquals("Evento acima das Normas, portanto, a determinação para quantidades de seguranças passará a ser estabelecida por ambiente sobre administração responsável.",espaco.calculaSeguranca(3250));
        }
        @Test
         public void  acimaNormas1() {
        Espaco espaco = new Espaco();
      
        assertEquals("Evento acima das Normas, portanto, a determinação para quantidades de seguranças passará a ser estabelecida por ambiente sobre administração responsável.",espaco.calculaSeguranca(3251));
    }
         @Test
    public void invalido() {
        Espaco espaco = new Espaco();
      
        assertEquals("inválido",espaco.calculaSeguranca(0));
    }
    }
}
