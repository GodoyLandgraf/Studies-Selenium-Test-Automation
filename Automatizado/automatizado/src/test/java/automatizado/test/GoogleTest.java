package automatizado.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import automatizado.page.GooglePO;


public class GoogleTest extends BaseTest {

    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararTestes(){
        driver.get("https://www.google.com/");
        googlePage = new GooglePO(driver);
    }

    @Test
    public void TC001_devePesquisarNoGoogleoTextoBatataFrita(){
       //WebElement inputPesquisa = driver.findElement(By.name("q"));
       googlePage.inputPesquisa.clear();
       googlePage.inputPesquisa.sendKeys("Batata frita" + Keys.ENTER);
       //inputPesquisa.sendKeys("Batata frita" + Keys.ENTER);
      // String resultado = driver.findElement(By.id("result-stats")).getText();
      String resultado = googlePage.divResultadoPesquisa.getText();
       assertTrue(resultado, resultado.contains("Aproximadamente"));  
    }

    /**
     * Metodo mais profissional com separaçaõ de métodos
     */
    @Test
    public void TC002_devePesquisarNoGoogleOTextofritas(){
       googlePage.inputPesquisa.clear();
       googlePage.pesquisar("fritas");
       String resultado = googlePage.retornaResultadoDaPesquisa();
       assertTrue(resultado, resultado.contains("resultados"));  
    }
}
