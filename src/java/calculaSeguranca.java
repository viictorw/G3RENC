

import static junit.framework.Assert.assertEquals;
import model.Espaco;
import org.junit.Test;


public class calculaSeguranca {
    @Test
    public static void poucasPessoas() {
        Espaco espaco = new Espaco();
      
        assertEquals("Poucas pessoas,portanto não será feito cálculo da quantidade de seguranças!",espaco.calculaTamanhoEspaco(49));
    }
    
    @Test
    public static void pequenoPorte() {
        Espaco espaco = new Espaco();
      
        assertEquals("Evento de pequeno porte, aconselhável ter 5 seguranças",espaco.calculaTamanhoEspaco(89));
    }
    
    @Test
    public static void medioPorte() {
        Espaco espaco = new Espaco();
      
        assertEquals("Evento de médio porte, aconselhável ter entre 6 e 10 seguranças",espaco.calculaTamanhoEspaco(149));
    }
    
    @Test
    public static void grandePorte() {
        Espaco espaco = new Espaco();
      
        assertEquals("Evento de grande porte, aconselhável ter entre 11 e 15 seguranças",espaco.calculaTamanhoEspaco(249));
    }
    
    @Test
    public static void  grandegPorte() {
        Espaco espaco = new Espaco();
      
        assertEquals("Evento de grande+ porte, aconselhável ter entre 16 e 25 seguranças",espaco.calculaTamanhoEspaco(549));
    }
    
    @Test
    public static void  grandeggPorte() {
        Espaco espaco = new Espaco();
      
        assertEquals("Evento de grande++ porte, aconselhável ter entre 21 e 30 seguranças",espaco.calculaTamanhoEspaco(749));
    }
    
    @Test
    public static void  grandegggPorte() {
        Espaco espaco = new Espaco();
      
        assertEquals("Evento de grande+++ porte, aconselhável ter entre 31 e 50 seguranças",espaco.calculaTamanhoEspaco(1249));
    }
    
    @Test
    public static void  extragrandePorte() {
        Espaco espaco = new Espaco();
      
        assertEquals("Evento de grande ex+ porte, aconselhável ter mais do que 50 seguranças",espaco.calculaTamanhoEspaco(3249));
    }
}
