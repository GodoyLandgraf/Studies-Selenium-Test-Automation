package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automatizado.builder.ProdutoBuilder;

public class ControleDeProdutoPO extends BasePO {

    //#region Região dos WebElements
    @FindBy(id= "btn-adicionar")
    public WebElement buttonAdicionar;

    @FindBy(css ="ul>li>a.nav-link")
    public WebElement linkVoltar;

    @FindBy(css ="div.modal-header>h4")
    public WebElement tituloModal;

    @FindBy(id= "codigo")
    public WebElement inputCodigo;

    @FindBy(id= "nome")
    public WebElement inputNome;

    @FindBy(id= "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id= "valor")
    public WebElement inputValor;

    @FindBy(id= "data")
    public WebElement inputData;

    @FindBy(id= "btn-salvar")
    public WebElement buttonSalvar;

    @FindBy(id= "btn-sair")
    public WebElement buttonSair;

    @FindBy(id= "mensagem")
    public WebElement spanMensagem;

    @FindBy(css = "tr>td>button.btn.btn-link")
    public WebElement buttonEditar;
    //#endregion Região dos WebElements
    
    //#region Construtor
    public ControleDeProdutoPO(WebDriver driver) {
        super(driver);
    }
//#endregion Construtor
    
    //#regionMetodos Comentados

    //    public void cadastrarProduto(String codigo, String nome, Integer quantidade, Double valor, String data){
     //       inputCodigo.clear();
     //       escrever(inputCodigo, codigo);
     //      inputNome.clear();
     //      escrever(inputNome, nome);
     //      inputQuantidade.clear();
     //      escrever(inputQuantidade, quantidade.toString());
     //      inputValor.clear();
     //      escrever(inputValor, valor.toString());
     //      inputData.clear();
     //      escrever(inputData, data);
     //      buttonSalvar.click();
     //   }

     
     // public void cadastrarProduto(ProdutoBuilder produtoBuilder){
     //        inputCodigo.clear();
     //        inputCodigo.clear();
     //        escrever(inputCodigo, produtoBuilder.codigo);
      //       inputNome.clear();
     //        escrever(inputNome, produtoBuilder.nome);
     //        inputQuantidade.clear();
     //        escrever(inputQuantidade, produtoBuilder.quantidade.toString());
     //         inputValor.clear();
     //        escrever(inputValor, produtoBuilder.valor.toString());
     //        inputData.clear();
      //       escrever(inputData, produtoBuilder.data);
      //       buttonSalvar.click();
     // }

    //#endregion Métodos Comentados
}
