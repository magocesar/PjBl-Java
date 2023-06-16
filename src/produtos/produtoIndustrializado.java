package produtos;

public class produtoIndustrializado extends Produto {
  
  public produtoIndustrializado(int id, String nome, double preco, String descricao, String fabricante, String dataDeFabricacao, String dataDeValidade){
    super(id, nome, preco, descricao, fabricante, dataDeFabricacao, dataDeValidade);
  }

  @Override
  public void exibirPrateleira(){
    System.out.println("--------------------");
    System.out.println("Produtos Industrializados na Prateleira");
    System.out.println("Id: " + this.id);
    System.out.println("Nome: " + this.nome);
    System.out.println("Preço: " + this.preco);
    System.out.println("Descrição: " + this.descricao);
    System.out.println("Fabricante: " + this.fabricante);
    System.out.println("Data de Fabricação: " + this.dataDeFabricacao);
    System.out.println("Data de Validade: " + this.dataDeValidade);
    System.out.println("--------------------");
  }
}
