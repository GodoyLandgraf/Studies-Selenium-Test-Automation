package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutosTest extends BaseTest {

    private static LoginPO loginPage;
    private static ControleDeProdutoPO controleProdutoPage;

    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        controleProdutoPage = new ControleDeProdutoPO(driver);
        assertEquals(controleProdutoPage.obterTituloPagina(), "Controle de Produtos");
    }

    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar(){
        controleProdutoPage.buttonAdicionar.click();
        //TODO: Remover esse clique assim que o sistema estiver corrigido  
        controleProdutoPage.buttonAdicionar.click();       
        String tituloModal = controleProdutoPage.tituloModal.getText();
        assertEquals("Produto", tituloModal);
        controleProdutoPage.buttonSair.click();
        //TODO: Remover esse clique assim que o sistema estiver corrigido  
        controleProdutoPage.buttonSair.click();
    }

  //  @Test
   // public void TC002_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
   //     controleProdutoPage.buttonAdicionar.click();
   //     controleProdutoPage.cadastrarProduto("codigo1", "", 10, 15.8, "11/12/2021");
   //     controleProdutoPage.buttonSalvar.click();
   //     String msg = controleProdutoPage.spanMensagem.getText();
   //     assertEquals("Todos os campos são obrigatórios para o cadastro!", msg);
   // }

    @Test
    public void TC003_deveSerPossivelCadastrarUmProdutoPreencheendoTodosOsCampos(){
        controleProdutoPage.buttonAdicionar.click();
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);
        produtoBuilder.builder();
        controleProdutoPage.buttonSair.click();
        String msgEditar = controleProdutoPage.buttonEditar.getText();
        assertEquals("Editar", msgEditar);
    }


    /**
     * Teste utilizando metedo dentro do Controle de Produto PO.
     * Nao precisa de construir o buil
     */

     //   @Test
     //   public void TC004_naoDeveSerPossivelCadastrarUmProdutoNaoPreencheendoTodosOsCampos(){
     //     
     //    controleProdutoPage.buttonAdicionar.click();
     //    ProdutoBuilder produtoBuilder = new ProdutoBuilder();
     //   produtoBuilder.nome = "";
     //     controleProdutoPage.cadastrarProduto(produtoBuilder);
     //     String msg = controleProdutoPage.spanMensagem.getText();
     //      assertEquals("Todos os campos são obrigatórios para o cadastro!", msg);
     //  }

    @Test
    public void TC004_naoDeveSerPossivelCadastrarUmProdutoNaoPreencheendoTodosOsCampos(){
        
        controleProdutoPage.buttonAdicionar.click();
        String msgEsperada = "Todos os campos são obrigatórios para o cadastro!";
        
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);
        produtoBuilder
        .adcionarNome("")
        .adcionarCodigo("0002");
        produtoBuilder.builder();
        assertEquals(msgEsperada, controleProdutoPage.spanMensagem.getText());

        produtoBuilder
        .adcionarNome("Matheus")
        .adcionarCodigo("0003")
        .adcionarQuantidade(null);
        produtoBuilder.builder();
        assertEquals(msgEsperada, controleProdutoPage.spanMensagem.getText());

        produtoBuilder
        .adcionarNome("Carlos")
        .adcionarCodigo("0003")
        .adcionarData("");
        produtoBuilder.builder();
        assertEquals(msgEsperada, controleProdutoPage.spanMensagem.getText());

    }




}
