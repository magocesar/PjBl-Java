package vendas;

import java.util.ArrayList;
import java.util.Scanner;
import personas.Atendente;
import personas.Cliente;
import produtos.Produto;

public class relatoriosVendas {
    
    public void vendas_por_atendente(ArrayList<pedido> vendas, Scanner scanner, Atendente atendente){
        String cpf = null;

        if (vendas.size() == 0) {
            System.out.println("Não há vendas registradas");
        }
        
        boolean cpfValido = false;
        boolean cpfEncontrado = false;

        while (!cpfValido) {
            try {
                System.out.println("--------------------");
                System.out.print("Buscar vendas por Atendente: ");
                System.out.println("\nPara cancelar, digite '0'");
                System.out.println("--------------------");
                System.out.print("Digite o CPF do atendente que realizou a venda: ");
                cpf = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("CPF inválido!");
                scanner.nextLine(); // Limpa o buffer do scanner após uma exceção
            }

            if (cpf.equals("0")) {
                System.out.println("Cancelando...");
                return;
            }

            if (cpf.length() != 11 ) {
                System.out.println("CPF inválido!");
            } else {
                cpfValido = true;
            }
        }

        for (pedido venda : vendas) {
            if (venda.getAtendente() == atendente) {
                cpfEncontrado = true;
                venda.exibirPedido();
            }
        }

        if (!cpfEncontrado) {
            System.out.println("Venda não encontrada");
        }
    }

    public void vendas_por_cliente(ArrayList<pedido> vendas, Scanner scanner, Cliente cliente){
        String cpf = null;

        if (vendas.size() == 0) {
            System.out.println("Não há vendas registradas");
        }
        
        boolean cpfValido = false;
        boolean cpfEncontrado = false;

        while (!cpfValido) {
            try {
                System.out.println("--------------------");
                System.out.print("Buscar vendas por Cliente: ");
                System.out.println("\nPara cancelar, digite '0'");
                System.out.println("--------------------");
                System.out.print("Digite o CPF do cliente que realizou a compra: ");
                cpf = scanner.nextLine();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("CPF inválido!");
                scanner.nextLine(); // Limpa o buffer do scanner após uma exceção
            }

            if (cpf.equals("0")) {
                System.out.println("Cancelando...");
                return;
            }

            if (cpf.length() != 11 ) {
                System.out.println("CPF inválido!");
            } else {
                cpfValido = true;
            }
        }

        for (pedido venda : vendas) {
            if (venda.getCliente() == cliente) {
                cpfEncontrado = true;
                venda.exibirPedido();
            }
        }

        if (!cpfEncontrado) {
            System.out.println("Venda não encontrada");
        }
    }

    public void vendas_por_produto(ArrayList<pedido> vendas,ArrayList<Produto> produtos, Scanner scanner){
        String nome = null;

        if (vendas.size() == 0) {
            System.out.println("Não há vendas registradas");
        }
        
        boolean nomeValido = false;
        boolean nomeEncontrado = false;

        while (!nomeValido) {
            try {
                System.out.println("--------------------");
                System.out.print("Buscar vendas por Produto: ");
                System.out.println("\nPara cancelar, digite '0'");
                System.out.println("--------------------");
                System.out.print("Digite o nome do produto que deseja buscar: ");
                nome = scanner.nextLine();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Nome inválido!");
                scanner.nextLine(); // Limpa o buffer do scanner após uma exceção
            }

            if (nome.equals("0")) {
                System.out.println("Cancelando...");
                return;
            }

            if (nome.length() == 0 ) {
                System.out.println("Nome inválido!");
            } else {
                nomeValido = true;
            }
        }

        for (pedido venda : vendas) {
            for (Produto produto : produtos) {
                if (produto.getNome().equals(nome)) {
                    nomeEncontrado = true;
                    venda.exibirPedido();
                }
            }
        }

        if (!nomeEncontrado) {
            System.out.println("Venda não encontrada");
        }

    }

    
}





