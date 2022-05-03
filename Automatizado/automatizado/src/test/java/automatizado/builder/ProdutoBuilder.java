package automatizado.builder;

import org.openqa.selenium.WebDriver;

import automatizado.page.ControleDeProdutoPO;
/**
 * Classe que sabe construir um adicionar um produto na tela
 */
public class ProdutoBuilder {

    private String codigo = "00001";
    private String nome = "Produto Padrão";
    private Integer quantidade = 1;
    private Double valor = 1.0;
    private String data = "09/12/1997";

    private ControleDeProdutoPO controleDeProdutoPO;
    
    /**Construturo do ProdutoBuilder que recebe a página de controle do produto */
    public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO){
        this.controleDeProdutoPO = controleDeProdutoPO;
    }

    /**
     * Método que sabe adicionar um código ao builder
     * @param codigo Código que será adicionado
     * @return Retorna a própria classe ProdutoBuilder
     */
    public ProdutoBuilder adcionarCodigo(String  codigo){
        this.codigo = codigo;
        return this;
    }
    /**
     * Método que sabe adicionar um código ao builder
     * @param nome Nome que será adicionado
     * @return Retorna a própria classe ProdutoBuilder
     */
    public ProdutoBuilder adcionarNome(String  nome){
        this.nome = nome;
        return this;
    }

    public ProdutoBuilder adcionarQuantidade(Integer  quantidade){
        this.quantidade = quantidade;
        return this;
    }

    public ProdutoBuilder adcionarValor(Double valor){
        this.valor = valor;
        return this;
    }

    public ProdutoBuilder adcionarData(String  data){
        this.data = data;
        return this;
    }
/**Método que constroi o produto, ou seja, adiciona o produto pela tela de cadastro de produto */
    public void builder(){
        controleDeProdutoPO.inputCodigo.clear();
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, codigo);
        controleDeProdutoPO.inputNome.clear();
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
        controleDeProdutoPO.inputQuantidade.clear();
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, (quantidade != null) ? quantidade.toString() : "");
        controleDeProdutoPO.inputValor.clear();
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, (valor != null) ? valor.toString() : "");
        controleDeProdutoPO.inputData.clear();
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);
        controleDeProdutoPO.buttonSalvar.click();
    }
}
