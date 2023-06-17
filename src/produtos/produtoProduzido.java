package produtos;

import java.util.ArrayList;

public class produtoProduzido extends Produto{

  private ArrayList<ingrediente> ingredientes = new ArrayList<ingrediente>();
  
  public produtoProduzido(int id, String nome, double preco, int quantidade, String descricao, String fabricante, String dataDeFabricacao, String dataDeValidade, ArrayList<ingrediente> ingredientes){
    super(id, nome, preco, quantidade, descricao, fabricante, dataDeFabricacao, dataDeValidade);
    this.ingredientes = ingredientes;
  }

  @Override
  public void exibirPrateleira(){
    System.out.println("--------------------");
    System.out.println("Produtos Produzidos na Prateleira");
    System.out.println("Id: " + this.id);
    System.out.println("Nome: " + this.nome);
    System.out.println("Preço: " + this.preco);
    System.out.println("Quantidade: " + this.quantidade);
    System.out.println("Descrição: " + this.descricao);
    System.out.println("Fabricante: " + this.fabricante);
    System.out.println("Data de Fabricação: " + this.dataDeFabricacao);
    System.out.println("Data de Validade: " + this.dataDeValidade);
    System.out.println("--------------------");
  }
}
