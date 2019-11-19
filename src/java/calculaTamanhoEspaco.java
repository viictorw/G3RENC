/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pichau
 */
import model.Espaco;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class calculaTamanhoEspaco {
    @Test
    public static void tamanhoInsuficiente() {
        Espaco espaco = new Espaco();
      
        assertEquals("Espaço insuficiente para o tipo desejado!",espaco.calculaTamanhoEspaco(19));
    }
    
    @Test
    public static void tamanhoPequeno() {
        Espaco espaco = new Espaco();
      
        assertEquals("Espaço de pequeno porte, aconselhável ter no máximo 300 pessoas",espaco.calculaTamanhoEspaco(99));
    }
    
    @Test
    public static void tamanhoMedio() {
        Espaco espaco = new Espaco();
      
        assertEquals("Espaço de médio porte, aconselhável ter no máximo 750 pessoas",espaco.calculaTamanhoEspaco(249));
    }
    
    @Test
    public static void tamanhoGrande() {
        Espaco espaco = new Espaco();
      
        assertEquals("Espaço de grande porte, aconselhável ter no máximo 1000 pessoas",espaco.calculaTamanhoEspaco(319));
    }
    
    @Test
    public static void tamanhoGrandeg() {
        Espaco espaco = new Espaco();
      
        assertEquals("Espaço de grande+ porte, aconselhável ter no máximo 1500 pessoas",espaco.calculaTamanhoEspaco(499));
    }
    
    @Test
    public static void tamanhoGrandegg() {
        Espaco espaco = new Espaco();
      
        assertEquals("Espaço de grande++ porte, aconselhável ter no máximo 2300 pessoas",espaco.calculaTamanhoEspaco(749));
    }
    
    @Test
    public static void tamanhoGrandeggg() {
        Espaco espaco = new Espaco();
      
        assertEquals("Espaço de grande+++ porte, aconselhável ter no máximo 3000 pessoas",espaco.calculaTamanhoEspaco(999));
    }
    
    @Test
    public static void tamanhoExtraGrande() {
        Espaco espaco = new Espaco();
      
        assertEquals("Espaço de grande ex+ porte, aconselhável ter no máximo 6000 pessoas",espaco.calculaTamanhoEspaco(1999));
    }
       
}
