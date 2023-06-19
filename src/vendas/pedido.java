package vendas;

import java.io.Serializable;
import java.util.ArrayList;

import personas.Atendente;
import personas.Cliente;
import produtos.Produto;

public class pedido implements Serializable{
  private Atendente atendente; 
  private Cliente cliente; 

  private ArrayList<Produto> produtos = new ArrayList<Produto>(); 

  public Atendente getAtendente(){
    return atendente; 
  }

  public void setAtendente(Atendente atendente){
    this.atendente = atendente; 
  }

  public Cliente getCliente(){
    return cliente; 
  }

  public void setCliente(Cliente cliente){
    this.cliente = cliente; 
  }

  public ArrayList<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(ArrayList<Produto> produtos) {
    this.produtos = produtos;
  }
  
  public pedido(Atendente atendente, Cliente cliente, ArrayList<Produto> produtos){
    this.atendente = atendente; 
    this.cliente = cliente; 
    this.produtos = produtos; 
  }

  public void exibirPedido(){
    System.out.println("--------------------");
    System.out.println("Pedido");
    System.out.println("Atendente: " + this.atendente.getNome());
    System.out.println("Cliente: " + this.cliente.getNome());
    System.out.println("Produtos: ");
    for(Produto produto : this.produtos){
      System.out.println("Nome: " + produto.getNome());
      System.out.println("Preço: " + produto.getPreco());
      System.out.println("Descrição: " + produto.getDescricao());
      System.out.println("Fabricante: " + produto.getFabricante());
      System.out.println("Data de Fabricação: " + produto.getDataDeFabricacao());
      System.out.println("Data de Validade: " + produto.getDataDeValidade());
      System.out.println("Quantidade: " + produto.getQuantidade());
      System.out.println("--------------------");
    }
    System.out.println("Valor Total: " + this.calcularValor());
  }

  public double calcularValor(){
    double valor = 0; 
    for(Produto produto : this.produtos){
      valor += produto.getPreco(); 
    }
    return valor;
  }
}
