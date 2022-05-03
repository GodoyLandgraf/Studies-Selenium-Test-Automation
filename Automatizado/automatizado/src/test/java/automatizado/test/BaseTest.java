package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Clase base que serve de herança para todas as classes de teste
 */
public abstract class BaseTest {
    
    /*** Driver do navegador da pagina atual */
        protected static WebDriver driver;

        //MUDAR A URL BASE CONFORME O TESTE QUE QUER
        /**Caminho base da URL do sistema a ser testado */
        private static final String URL_BASE = "file:///C:/Users/mathe/Desktop/sistema/login.html";
        /**Caminho relativo do driver ao projeto referente ao path */
        private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver100.0.4896.exe"; 


        /**
         * Método para iniciar o driver do navegador antes de qualquer classe de teste
         */
        @BeforeClass   
        public static void iniciar(){
            System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(URL_BASE);
            }
/**
         * Método finalizar o driver do navegador depois de qualquer classe de teste
         */
        @AfterClass
        public static void finalizar(){
            driver.quit();
        }
}
