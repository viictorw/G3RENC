/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pichau
 */

import static junit.framework.Assert.assertEquals;
import model.Espaco;
import org.junit.Test;

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
       @Test
    public static void tamanhoAcimaPadrao() {
        Espaco espaco = new Espaco();
      
        assertEquals("Espaço acima do padrão, determinação para quantidades de pessoas passará a ser estabelecida por ambiente sobre administração responsável.",espaco.calculaTamanhoEspaco(2000));
    }
    public static void espacoInvalido() {
        Espaco espaco = new Espaco();
      
        assertEquals("Espaço inválido!",espaco.calculaTamanhoEspaco(-2));
    }
}
