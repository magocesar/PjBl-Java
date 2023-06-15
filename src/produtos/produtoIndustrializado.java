package produtos;

public class produtoIndustrializado extends Produto {
  
  public produtoIndustrializado(String nome, double preco, String descricao, String fabricante, String dataDeFabricacao, String dataDeValidade){
    super(nome, preco, descricao, fabricante, dataDeFabricacao, dataDeValidade);
  }

  @Override
  public void exibirPrateleira(){
    System.out.println("Nome: " + this.nome + "\nPreço: " + this.preco + "\nDescrição: " + this.descricao + "\nFabricante: " + this.fabricante + "\nData de Fabricação: " + this.dataDeFabricacao + "\nData de Validade: " + this.dataDeValidade + "\nFabricante: " + this.fabricante); 
  }
}
