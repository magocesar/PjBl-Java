package padaria;
import java.util.ArrayList;

import personas.*;
import produtos.*;

public class venda {
    private int id;
    private String data;
    private Atendente atendente;
    private Cliente cliente;
    private ArrayList<Produto> produtos;

    public venda(int id, String data, double valorTotal, Atendente atendente, Cliente cliente, ArrayList<Produto> produtos){
        this.id = id;
        this.data = data;
        this.atendente = atendente;
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public double calcularValorTotal(){
        double valorTotal = 0;
        for(Produto produto : produtos){
            valorTotal += produto.getPreco();
        }
        return valorTotal;
    }

    public void imprimirVenda(){
        System.out.println("Id: " + this.id);
        System.out.println("Data: " + this.data);
        System.out.println("CPF do Atendente: " + this.atendente.getCpf());
        System.out.println("CPF do Cliente: " + this.cliente.getCpf());
        System.out.println("Itens: ");
        for(Produto produto : produtos){
            System.out.println("Id: " + produto.getId() + "Nome: " + produto.getNome() + "Preço: " + produto.getPreco());
        }
        System.out.println("Valor Total: " + this.calcularValorTotal());
    }
}