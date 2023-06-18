package produtos; 

public abstract class Produto{
  protected int id;
  protected String nome; 
  protected double preco;
  protected String descricao;
  protected String fabricante; 
  protected String dataDeFabricacao; 
  protected String dataDeValidade; 
  protected int quantidade;

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public int getId() {
    return id;
  }

public void setId(int id) {
    this.id = id;
  }

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

  public Produto(int id, String nome, double preco, String descricao, String fabricante, String dataDeFabricacao, String dataDeValidade, int quantidade){
    this.id = id;
    this.nome = nome; 
    this.preco = preco; 
    this.quantidade = quantidade;
    this.descricao = descricao; 
    this.fabricante = fabricante;
    this.dataDeFabricacao = dataDeFabricacao; 
    this.dataDeValidade = dataDeValidade; 
    this.quantidade = quantidade;
  }

  abstract public void exibirPrateleira();

}
