package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO {

    @FindBy(name = "q")
    public WebElement inputPesquisa;

    @FindBy(id = "result-stats")
    public WebElement divResultadoPesquisa;
    


    /**
     * Contrutor para criaçao da página do Google
     * @param driver Driver da página do Google
     */
    public GooglePO(WebDriver driver) {
        super(driver);
    }

    public void pesquisar(String texto){
        inputPesquisa.sendKeys(texto + Keys.ENTER);
    }

    public String retornaResultadoDaPesquisa(){
        return divResultadoPesquisa.getText();
    }
    
}
