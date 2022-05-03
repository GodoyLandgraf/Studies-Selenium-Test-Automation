package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //executa cada código por ordem de nome

public class LoginTest extends BaseTest {

        private static LoginPO loginPage;
    
        //   Coloquei esse metodo dentro do LoginPO
        //   private void executarAcaoDeLogar(String email, String ///senha){
        //   loginPage.escrever(loginPage.inputEmail,email); //com o    método de escrever
        //   loginPage.inputSenha.sendKeys(senha);
        //   loginPage.buttonEntrar.click();
        //}


        @BeforeClass
        public static void prepararTestes(){
            loginPage = new LoginPO(driver);
        }

        @Test
        public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios(){
            // loginPage.escrever(loginPage.inputEmail, ""); //com o método de escrever
          //  loginPage.inputSenha.sendKeys("");
          //  loginPage.buttonEntrar.click();
            loginPage.executarAcaoDeLogar("", "");
            String mensagemObtida = loginPage.obterMensagem();
            String msgInformadaCorretamente = "Informe usuário e senha, os campos não podem ser brancos.";
            assertEquals(mensagemObtida, msgInformadaCorretamente);
        }

        @Test
        public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia(){
            loginPage.executarAcaoDeLogar("teste", "");
            String mensagemObtida = loginPage.obterMensagem();
            String msgInformadaCorretamente = "Informe usuário e senha, os campos não podem ser brancos.";
            assertEquals(mensagemObtida, msgInformadaCorretamente);
        }

        @Test
        public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta(){
            loginPage.executarAcaoDeLogar("", "teste");
            String mensagemObtida = loginPage.obterMensagem();
            String msgInformadaCorretamente = "Informe usuário e senha, os campos não podem ser brancos.";
            assertEquals(mensagemObtida, msgInformadaCorretamente);
        }

        @Test
        public void TC004_deveLogarNoSistemaComEmailESenhaCorretos(){
            loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
            String tituloObtido = loginPage.obterTituloPagina();
            String tituloInformadoCorretamente = "Controle de Produtos";
            assertEquals(tituloObtido, tituloInformadoCorretamente);
        }
           
}
