package produtos;

public class produtoProduzido extends Produto{
  
  public produtoProduzido(String nome, double preco, String descricao, String fabricante, String dataDeFabricacao, String dataDeValidade){
    super(nome, preco, descricao, fabricante, dataDeFabricacao, dataDeValidade);
  }

  @Override
  public void exibirPrateleira(){
    System.out.println("--------------------");
    System.out.println("Produtos Produzidos na Prateleira");
    System.out.println("Nome: " + this.nome);
    System.out.println("Preço: " + this.preco);
    System.out.println("Descrição: " + this.descricao);
    System.out.println("Fabricante: " + this.fabricante);
    System.out.println("Data de Fabricação: " + this.dataDeFabricacao);
    System.out.println("Data de Validade: " + this.dataDeValidade);
    System.out.println("--------------------");
  }
}
