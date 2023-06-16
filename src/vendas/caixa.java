package vendas;

import java.util.ArrayList;

import produtos.Produto;

public class caixa {
  private ArrayList<pedido> pedidos = new ArrayList<pedido>();
  
  public ArrayList<pedido> getPedidos() {
    return pedidos;
  }

  public void setPedidos(ArrayList<pedido> pedidos) {
    this.pedidos = pedidos;
  }

  public void exibirCaixa(){
    System.out.println("--------------------");
    System.out.println("Caixa");
    System.out.println("Pedidos: " + this.pedidos.size());
    System.out.println("--------------------");
  }

  public void adicionarPedido(pedido pedido){
    this.pedidos.add(pedido);
  }

  public void removerPedido(pedido pedido){
    this.pedidos.remove(pedido);
  }

  public void exibirPedidos(){
    for (pedido pedido : this.pedidos) {
      pedido.exibirPedido();
    }
  }

  public void exibirPedidosPorCliente(String nome){
    for (pedido pedido : this.pedidos) {
      if(pedido.getCliente().getNome().equals(nome)){
        pedido.exibirPedido();
      }
    }
  }

  public void exibirPedidosPorAtendente(String nome){
    for (pedido pedido : this.pedidos) {
      if(pedido.getAtendente().getNome().equals(nome)){
        pedido.exibirPedido();
      }
    }
  }

  public void exibirPedidosPorData(String data){
    for (pedido pedido : this.pedidos) {
      if(pedido.getData().equals(data)){
        pedido.exibirPedido();
      }
    }
  }

  public void exibirPedidosPorProduto(String nome){
    for (pedido pedido : this.pedidos) {
      for (Produto produto : pedido.getProdutos()) {
        if(produto.getNome().equals(nome)){
          pedido.exibirPedido();
        }
      }
    }
  }
}
