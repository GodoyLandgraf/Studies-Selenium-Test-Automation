package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{

    @FindBy(id= "email")
    public WebElement inputEmail;

    @FindBy(id= "senha")
    public WebElement inputSenha;

    @FindBy(id= "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(id= "mensagem")
    public WebElement spanMensagem;


    /**
     * Construtor padrão para a criação de uma nova Instancia da página de Login
     * @param driver Driver da página de Login
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public String obterMensagem(){
        return spanMensagem.getText();
    }


    public void executarAcaoDeLogar(String email, String senha){
        escrever(inputEmail,email); //com o método de escrever
        escrever(inputSenha,senha);
        buttonEntrar.click();
    }

 
}
