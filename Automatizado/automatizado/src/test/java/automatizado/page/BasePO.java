package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
  * Classe base para criação das novas  PagesObjects.
  Todas as pages devem ser herdadas dessa classe
  */
  
  public abstract class BasePO {

    /** Driver base que será usado pelas pages */
    protected WebDriver driver;
    private WebElement input;
    private String texto;


    /**
     * Contrutor base para criação da fábrica de elementos (Page Factory)
     * @param driver (Driver da página atual)
     */
    protected BasePO (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
/**
 * Método que retorna o título da página atual
 * @return
 */
    public String obterTituloPagina(){
      return driver.getTitle();
  }
/**
 * Metodo que sabe escrever quem qualquer WeElement do tipo input e um TAB ao final
 * @param input Input a qual será escrito
 * @param texto Texto que será escrito no input
 */
  public void escrever(WebElement input, String texto){
    this.input = input;
    this.texto = texto;
    input.clear();
    input.sendKeys(texto + Keys.TAB);
}

}

