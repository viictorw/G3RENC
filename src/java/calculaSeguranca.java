

import static junit.framework.Assert.assertEquals;
import model.Espaco;
import org.junit.Test;


public class calculaSeguranca {
    @Test
    public static void poucasPessoas() {
        Espaco espaco = new Espaco();
      
        assertEquals("Poucas pessoas,portanto não será feito cálculo da quantidade de seguranças!",espaco.calculaSeguranca(49));
    }
    
    @Test
    public static void pequenoPorte() {
        Espaco espaco = new Espaco();
      
        assertEquals("Evento de pequeno porte, aconselhável ter 5 seguranças",espaco.calculaSeguranca(89));
    }
    
    @Test
    public static void medioPorte() {
        Espaco espaco = new Espaco();
      
        assertEquals("Evento de médio porte, aconselhável ter entre 6 e 10 seguranças",espaco.calculaSeguranca(149));
    }
    
    @Test
    public static void grandePorte() {
        Espaco espaco = new Espaco();
      
        assertEquals("Evento de grande porte, aconselhável ter entre 11 e 15 seguranças",espaco.calculaSeguranca(249));
    }
    
    @Test
    public static void grandegPorte() {
        Espaco espaco = new Espaco();
      
        assertEquals("Evento de grande+ porte, aconselhável ter entre 16 e 25 seguranças",espaco.calculaSeguranca(549));
    }
    
    @Test
    public static void grandeggPorte() {
        Espaco espaco = new Espaco();
      
        assertEquals("Evento de grande++ porte, aconselhável ter entre 21 e 30 seguranças",espaco.calculaSeguranca(749));
    }
    
    @Test
    public static void grandegggPorte() {
        Espaco espaco = new Espaco();
      
        assertEquals("Evento de grande+++ porte, aconselhável ter entre 31 e 50 seguranças",espaco.calculaSeguranca(1249));
    }
    
    @Test
    public static void extragrandePorte() {
        Espaco espaco = new Espaco();
      
        assertEquals("Evento de grande ex+ porte, aconselhável ter mais do que 50 seguranças",espaco.calculaSeguranca(3249));
    }
@Test
    public static void acimaNormas() {
        Espaco espaco = new Espaco();
      
        assertEquals("Evento acima das Normas, portanto, a determinação para quantidades de seguranças passará a ser estabelecida por ambiente sobre administração responsável.",espaco.calculaSeguranca(3250));
    }
    @Test
    public static void acimaNormas1() {
        Espaco espaco = new Espaco();
      
        assertEquals("Evento acima das Normas, portanto, a determinação para quantidades de seguranças passará a ser estabelecida por ambiente sobre administração responsável.",espaco.calculaSeguranca(3251));
    }
    @Test
    public static void invalido() {
        Espaco espaco = new Espaco();
      
        assertEquals("inválido",espaco.calculaSeguranca(0));
    }
}
