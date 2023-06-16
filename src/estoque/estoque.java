package estoque;
import java.util.ArrayList;
import java.util.Scanner;
import produtos.*;
import padaria.*;

public class estoque {
    private ArrayList<produtoIndustrializado> produtoIndustrializados = new ArrayList<produtoIndustrializado>();

    private ArrayList<produtoProduzido> produtoProduzido = new ArrayList<produtoProduzido>();

    private ArrayList<ingrediente> ingredientes = new ArrayList<ingrediente>();


    public void adicionarProdutoIndustrializado(Scanner scanner){
        String nome = null; 
        double preco = 0;
        String descricao = null;
        String fabricante = null; 
        String dataDeFabricacao = null; 
        String dataDeValidade = null;

        System.out.println("\n--------------------");
        System.out.println("Adicionar Produto Industrializado");
        System.out.println("Caso deseja cancelar, digite '0' em qualquer campo.");
        System.out.println("--------------------");

        boolean nomeValido = false;
        while(!nomeValido){
            try{
                System.out.print("Digite o nome do atendente: ");
                nome = scanner.nextLine();
            }catch(Exception e){
                System.out.println("Nome inválido!");
            }

            if(nome.equals("0")){
                System.out.println("Cancelando...");
                return;
            }

            if(nome.length() == 0){
                System.out.println("Nome inválido!");
            }else{	
                nomeValido = true;
            }
        }

        boolean precoValido = false;
        while(!precoValido){
            try{
                System.out.print("Digite o preço do produto: ");
                preco = scanner.nextDouble();
            }catch(Exception e){
                System.out.println("Preço inválido!");
            }

            if(preco == 0){
                System.out.println("Cancelando...");
                return;
            }

            if(preco < 0){
                System.out.println("Preço inválido!");
            }else{	
                precoValido = true;
            }
        }

        boolean descricaoValida = false;
        while(!descricaoValida){
            try{
                System.out.print("Digite a descrição do produto: ");
                descricao = scanner.nextLine();
            }catch(Exception e){
                System.out.println("Descrição inválida!");
            }

            if(descricao.equals("0")){
                System.out.println("Cancelando...");
                return;
            }

            if(descricao.length() == 0){
                System.out.println("Descrição inválida!");
            }else{	
                descricaoValida = true;
            }
        }

        boolean fabricanteValido = false;
        while(!fabricanteValido){
            try{
                System.out.print("Digite o fabricante do produto: ");
                fabricante = scanner.nextLine();
            }catch(Exception e){
                System.out.println("Fabricante inválido!");
            }

            if(fabricante.equals("0")){
                System.out.println("Cancelando...");
                return;
            }

            if(fabricante.length() == 0){
                System.out.println("Fabricante inválido!");
            }else{	
                fabricanteValido = true;
            }
        }

        boolean dataDeFabricacaoValida = false;
        while(!dataDeFabricacaoValida){
            try{
                System.out.print("Digite a data de fabricação do produto: ");
                dataDeFabricacao = scanner.nextLine();
            }catch(Exception e){
                System.out.println("Data de fabricação inválida!");
            }

            if(dataDeFabricacao.equals("0")){
                System.out.println("Cancelando...");
                return;
            }

            if(dataDeFabricacao.length() == 0){
                System.out.println("Data de fabricação inválida!");
            }else{	
                dataDeFabricacaoValida = true;
            }
        }

        boolean dataDeValidadeValida = false;
        while(!dataDeValidadeValida){
            try{
                System.out.print("Digite a data de validade do produto: ");
                dataDeValidade = scanner.nextLine();
            }catch(Exception e){
                System.out.println("Data de validade inválida!");
            }

            if(dataDeValidade.equals("0")){
                System.out.println("Cancelando...");
                return;
            }

            if(dataDeValidade.length() == 0){
                System.out.println("Data de validade inválida!");
            }else{	
                dataDeValidadeValida = true;
            }
        }

        System.out.println("--------------------");
        System.out.println("Resumo dos dados inseridos: ");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Sexo: " + sexo);
        System.out.println("Idade: " + idade);
        System.out.println("Função: Atendente");
        System.out.println("Salário: " + salario);
        System.out.println("Turno: " + turno);
        System.out.println("--------------------");

        boolean opcaoValida = false;
        String op = null;
        ArrayList<String> opcoes = new ArrayList<String>(){
            {
                add("S");
                add("N");
            }
        };

        while(!opcaoValida){
            try{
                System.out.print("Confirmar? (S / N): ");
                op = scanner.nextLine();
            }catch(Exception e){
                System.out.println("Opção inválida!");
            }

            if(!opcoes.contains(op)){
                System.out.println("Opção inválida, digite 'S' ou 'N'!");
            }else{
                opcaoValida = true;
            }
        }

        if(op.equals("N")){
            System.out.println("Cancelando...");
            return;
        }

        this.produtoIndustrializados.add(new produtoIndustrializado(nome, preco, descricao, fabricante, dataDeFabricacao, dataDeValidade));
    }
}
