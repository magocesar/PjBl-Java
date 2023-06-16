package produtos; 

public abstract class Produto{
  protected String nome; 
  protected double preco;
  protected String descricao;
  protected String fabricante; 
  protected String dataDeFabricacao; 
  protected String dataDeValidade; 

  public String getNome(){
    return nome; 
  }

  public void setNome(String nome){
    this.nome = nome; 
  }

  public double getPreco(){
    return preco; 
  }

  public void setPreco(double preco){
    this.preco = preco; 
  }

  public String getDescricao(){
    return descricao; 
  }

  public void setDescricao(String descricao){
    this.descricao = descricao; 
  }

  public String getFabricante(){
    return fabricante; 
  }

  public void setFabricante(String fabricante){
    this.fabricante = fabricante; 
  }

  public String getDataDeFabricacao(){
    return dataDeFabricacao; 
  }

  public void setDataDeFabricacao(String dataDeFabricacao){
    this.dataDeFabricacao = dataDeFabricacao; 
  }

  public String getDataDeValidade(){
    return dataDeValidade; 
  }

  public void setDataDeValidade(String dataDeValidade){
    this.dataDeValidade = dataDeValidade; 
  }

  public Produto(String nome, double preco, String descricao, String fabricante, String dataDeFabricacao, String dataDeValidade){
    this.nome = nome; 
    this.preco = preco; 
    this.descricao = descricao; 
    this.fabricante = fabricante;
    this.dataDeFabricacao = dataDeFabricacao; 
    this.dataDeValidade = dataDeValidade; 
  }

  abstract public void exibirPrateleira();

}
