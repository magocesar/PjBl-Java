package estoque;

import java.util.ArrayList;
import java.util.Scanner;
import excep.NoIdInDatabaseException;
import persistencia.persistencia;

import java.io.*;


import produtos.*;
import personas.*;
import vendas.*;

public class estoque implements Serializable {
    private int id;
    private ArrayList<produtoIndustrializado> produtoIndustrializado = new ArrayList<produtoIndustrializado>();
    private ArrayList<produtoProduzido> produtoProduzido = new ArrayList<produtoProduzido>();

    public estoque() throws FileNotFoundException, ClassNotFoundException, IOException{
        this.id = persistencia.LerUltimoID();
        this.produtoIndustrializado = persistencia.LerIndustrializados();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<produtoIndustrializado> getProdutoIndustrializado() {
        return produtoIndustrializado;
    }

    public void setProdutoIndustrializado(ArrayList<produtoIndustrializado> produtoIndustrializado) {
        this.produtoIndustrializado = produtoIndustrializado;
    }

    public ArrayList<produtoProduzido> getProdutoProduzido() {
        return produtoProduzido;
    }

    public void setProdutoProduzido(ArrayList<produtoProduzido> produtoProduzido) {
        this.produtoProduzido = produtoProduzido;
    }

    public void exibirEstoque(){
        System.out.println("--------------------");
        System.out.println("Produtos Industrializados");
        if(this.produtoIndustrializado.size() == 0){
            System.out.println("Nenhum produto industrializado cadastrado.");
        }else{
            for(produtoIndustrializado produto : this.produtoIndustrializado){
                produto.exibirPrateleira();
            }
        }
        System.out.println("Produtos Produzidos");
        if(this.produtoProduzido.size() == 0){
            System.out.println("Nenhum produto produzido cadastrado.");
        }else{
            for(produtoProduzido produto : this.produtoProduzido){
                produto.exibirPrateleira();
            }
        }
    }

    public void adicionarProdutoIndustrializado(Scanner scanner) throws FileNotFoundException, IOException{
        String nome = null; 
        double preco = 0;
        String descricao = null;
        String fabricante = null; 
        String dataDeFabricacao = null; 
        String dataDeValidade = null;
        int quantidade = 0;

        System.out.println("\n--------------------");
        System.out.println("Adicionar Produto Industrializado");
        System.out.println("Caso deseja cancelar, digite '0' em qualquer campo.");
        System.out.println("--------------------");

        boolean nomeValido = false;
        while(!nomeValido){
            try{
                System.out.print("Digite o nome do Produto: ");
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
                scanner.nextLine();
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

        boolean quantidadeValida = false;
        while(!quantidadeValida){
            try{
                System.out.print("Digite a quantidade do produto: ");
                quantidade = scanner.nextInt();
            }catch(Exception e){
                System.out.println("Quantidade inválida!");
            }

            if(quantidade == 0){
                System.out.println("Cancelando...");
                return;
            }

            if(quantidade < 0){
                System.out.println("Quantidade inválida!");
            }else{	
                quantidadeValida = true;
            }
        }

        System.out.println("--------------------");
        System.out.println("Resumo dos dados inseridos: ");
        System.out.println("Id: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Preço: " + preco);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Descrição: " + descricao);
        System.out.println("Fabricante: " + fabricante);
        System.out.println("Data de fabricação: " + dataDeFabricacao);
        System.out.println("Data de validade: " + dataDeValidade);
        System.out.println("Quantidade : " + quantidade);
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
                scanner.nextLine();
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

        this.produtoIndustrializado.add(new produtoIndustrializado(this.id, nome, preco, descricao, fabricante, dataDeFabricacao, dataDeValidade, quantidade));
        this.id++;
        persistencia.SalvaUltimoID(id);
        persistencia.SalvaIndustrializados(produtoIndustrializado);
        System.out.println("Produto Industrializado adicionado com sucesso!");
    }

    public void adicionarProdutoProduzido(Scanner scanner){
        String nome = null; 
        double preco = 0;
        String descricao = null;
        String fabricante = null; 
        String dataDeFabricacao = null; 
        String dataDeValidade = null;
        int quantidade = 0;

        System.out.println("\n--------------------");
        System.out.println("Adicionar Produto Produzido");
        System.out.println("Caso deseja cancelar, digite '0' em qualquer campo.");
        System.out.println("--------------------");

        boolean nomeValido = false;
        while(!nomeValido){
            try{
                System.out.print("Digite o nome do Produto: ");
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
                scanner.nextLine();
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

        boolean quantidadeValida = false;
        while(!quantidadeValida){
            try{
                System.out.print("Digite a quantidade do produto: ");
                quantidade = scanner.nextInt();
            }catch(Exception e){
                System.out.println("Quantidade inválida!");
            }

            if(quantidade == 0){
                System.out.println("Cancelando...");
                return;
            }

            if(quantidade < 0){
                System.out.println("Quantidade inválida!");
            }else{	
                quantidadeValida = true;
            }
        }

        System.out.println("--------------------");
        System.out.println("Resumo dos dados inseridos: ");
        System.out.println("Id: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Preço: " + preco);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Descrição: " + descricao);
        System.out.println("Fabricante: " + fabricante);
        System.out.println("Data de Fabricação: " + dataDeFabricacao);
        System.out.println("Data de Validade: " + dataDeValidade);
        System.out.println("Quantidade : " + quantidade);
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
                scanner.nextLine();
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

        this.produtoProduzido.add(new produtoProduzido(this.id, nome, preco, descricao, fabricante, dataDeFabricacao, dataDeValidade, quantidade));
        this.id++;
        System.out.println("Produto Produzido adicionado com sucesso!");
    }

    public void removerProdutoIndustrializado(Scanner scanner) throws NoIdInDatabaseException{

        if(this.produtoIndustrializado.size() == 0){
            System.out.println("Não há produtos industrializados cadastrados!");
            return;
        }

        boolean idValido = false;
        boolean idEncontrado = false;
        int id = 0; 

        while(!idValido){
            try{
                System.out.println("--------------------");
                System.out.print("Remoção de Produto Industrializado: ");
                System.out.println("\nPara cancelar, digite '0'");
                System.out.println("--------------------");
                System.out.print("Digite o id do produto industrializado: ");
                id = scanner.nextInt();
                scanner.nextLine();
            }catch(Exception e){
                System.out.println("Id inválido!");
            }

            if(id == 0){
                System.out.println("Cancelando...");
                return;
            }

            if(id < 0){
                System.out.println("Id inválido!");
            }else{
                idValido = true;
            }
        }

        for(int i = 0; i < this.produtoIndustrializado.size(); i++){
            if(this.produtoIndustrializado.get(i).getId() == id){
{
                boolean opValida = false;
                String op = null;
                ArrayList<String> ops = new ArrayList<String>(){
                    {
                        add("S");
                        add("N");
                    }
                };
                while(!opValida){
                    try{
                        System.out.print("Confirma a remoção do produto " + this.produtoIndustrializado.get(i).getNome() + "? (S / N): ");
                        op = scanner.nextLine();
                    }catch(Exception e){
                        System.out.println("Opção inválida!");
                    }

                    if(!ops.contains(op)){
                        System.out.println("Opção inválida, digite 'S' ou 'N'!");
                    }else{
                        opValida = true;
                    }
                }

                if(op.equals("N")){
                    System.out.println("Cancelando...");
                    return;
                }

                this.produtoIndustrializado.remove(i);
                idEncontrado = true;
                break;
            }
        }

        if(idEncontrado){
            System.out.println("Produto removido com sucesso!");
        }else{
            throw new NoIdInDatabaseException("Id não encontrado no banco de dados!", id);
        }
        }
    }

    public void removerProdutoProduzido(Scanner scanner) throws NoIdInDatabaseException{
        if(this.produtoProduzido.size() == 0){
            System.out.println("Não há Produtos Produzidos cadastrados!");
            return;
        }

        boolean idValido = false;
        boolean idEncontrado = false;
        int id = 0; 

        while(!idValido){
            try{
                System.out.println("--------------------");
                System.out.print("Remoção de Produto Industrializado: ");
                System.out.println("\nPara cancelar, digite '0'");
                System.out.println("--------------------");
                System.out.print("Digite o id do produto industrializado: ");
                id = scanner.nextInt();
                scanner.nextLine();
            }catch(Exception e){
                System.out.println("Id inválido!");
            }

            if(id == 0){
                System.out.println("Cancelando...");
                return;
            }

            if(id < 0){
                System.out.println("Id inválido!");
            }else{
                idValido = true;
            }
        }

        for(int i = 0; i < this.produtoProduzido.size(); i++){
            if(this.produtoProduzido.get(i).getId() == id){
                boolean opValida = false;
                String op = null;
                ArrayList<String> ops = new ArrayList<String>(){
                    {
                        add("S");
                        add("N");
                    }
                };
                while(!opValida){
                    try{
                        System.out.print("Confirma a remoção do produto " + this.produtoProduzido.get(i).getNome() + "? (S / N): ");
                        op = scanner.nextLine();
                    }catch(Exception e){
                        System.out.println("Opção inválida!");
                    }

                    if(!ops.contains(op)){
                        System.out.println("Opção inválida, digite 'S' ou 'N'!");
                    }else{
                        opValida = true;
                    }
                }

                if(op.equals("N")){
                    System.out.println("Cancelando...");
                    return;
                }

                this.produtoProduzido.remove(i);
                idEncontrado = true;
                break;
            }
        }

        if(idEncontrado){
            System.out.println("Produto removido com sucesso!");
        }else{
            throw new NoIdInDatabaseException("Id não encontrado no banco de dados!", id);
        }
    }

    public void exibirProdutosIndustrializados() throws FileNotFoundException, ClassNotFoundException, IOException{
        System.out.println("Produtos industrializados: ");
        if(this.produtoIndustrializado.size() == 0){
            System.out.println("Não há produtoIndustrializado cadastrados!");
        }else{
            for(int i = 0; i < this.produtoIndustrializado.size(); i++){
                System.out.println("Produto Industrializado " + (i+1) + ": ");
                this.produtoIndustrializado.get(i).exibirPrateleira();
            }
        }
    }

    public void exibirProdutosProduzidos(){
        System.out.println("Produtos Produzidos: ");
        if(this.produtoProduzido.size() == 0){
            System.out.println("Não há Produtos Produzidos cadastrados!");
        }else{
            for(int i = 0; i < this.produtoProduzido.size(); i++){
                System.out.println("Cliente " + (i+1) + ": ");
                this.produtoProduzido.get(i).exibirPrateleira();
            }
        }
    }

    public pedido novaVenda(Scanner scanner, Atendente atendente, Cliente cliente){
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        
        ArrayList<produtoIndustrializado> CopiaprodutosIndustrializados = new ArrayList<produtoIndustrializado>();
        for(int i = 0; i < this.produtoIndustrializado.size(); i++){
            CopiaprodutosIndustrializados.add(this.produtoIndustrializado.get(i));
        }
        
        ArrayList<produtoProduzido> CopiaprodutosProduzidos = new ArrayList<produtoProduzido>();
        for(int i = 0; i < this.produtoProduzido.size(); i++){
            CopiaprodutosProduzidos.add(this.produtoProduzido.get(i));
        }
        
        ArrayList<String> ops = new ArrayList<String>(){
            {
                add("S");
                add("N");
            }
        };

        boolean sair = false;
        String op = null;
        while(!sair){
            boolean opValida = false;
            while(!opValida){

                //Exibir produtos
                this.exibirEstoque();

                //Exibir produtos no carrinho
                System.out.println("--------------------");
                System.out.println("Produtos no carrinho: ");
                if(produtos.size() == 0){
                    System.out.println("Não há produtos no carrinho!");
                }else{
                    for(int i = 0; i < produtos.size(); i++){
                        System.out.println("Produto " + (i+1) + ": ");
                        produtos.get(i).exibirProdutoCarrinho();
                    }
                }

                try{
                    System.out.println("--------------------");
                    System.out.println("Para cancelar, digite '0'");
                    System.out.print("Deseja adicionar um produto? (S / N): ");
                    op = scanner.nextLine();
                }catch(Exception e){
                    System.out.println("Opção inválida!");
                }

                if(op.equals("0")){
                    System.out.println("Cancelando...");
                    return null;
                }

                if(!ops.contains(op)){
                    System.out.println("Opção inválida, digite 'S' ou 'N'!");
                }else{
                    opValida = true;
                }
            }

            if(op.equals("N")){
                sair = true;
            }else{
                boolean idValido = false;
                int id = 0;
                int quantidade = 0;
                while(!idValido){
                    try{
                        System.out.print("Digite o id do produto: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite a quantidade: ");
                        quantidade = scanner.nextInt();
                    }catch(Exception e){
                        System.out.println("Id inválido!");
                    }

                    if(id < 0){
                        System.out.println("Id inválido!");
                    }else if(quantidade < 0){
                        System.out.println("Quantidade inválida!");
                    }else{
                        idValido = true;
                    }
                }

                boolean idEncontrado = false;
                for(int i = 0; i < CopiaprodutosIndustrializados.size(); i++){
                    if(CopiaprodutosIndustrializados.get(i).getId() == id){
                        if(CopiaprodutosIndustrializados.get(i).getQuantidade() == 0){
                            System.out.println("Produto sem estoque!");
                            idEncontrado = true;
                            break;
                        }else{
                            if(CopiaprodutosIndustrializados.get(i).getQuantidade() < quantidade){
                                System.out.println("Quantidade indisponível!");
                                idEncontrado = true;
                                break;
                            }

                            produtoIndustrializado produtoClasse = CopiaprodutosIndustrializados.get(i);

                            produtoIndustrializado produtoAux = new produtoIndustrializado(produtoClasse.getId(), produtoClasse.getNome(), produtoClasse.getPreco(), produtoClasse.getDescricao(), produtoClasse.getFabricante(), produtoClasse.getDataDeFabricacao(), produtoClasse.getDataDeValidade(), quantidade);

                            produtos.add(produtoAux);
                            
                            CopiaprodutosIndustrializados.get(i).setQuantidade(this.produtoIndustrializado.get(i).getQuantidade() - quantidade);
                            idEncontrado = true;
                            break;
                        }
                    }
                }

                if(!idEncontrado){
                    for(int i = 0; i < CopiaprodutosProduzidos.size(); i++){
                        if(CopiaprodutosProduzidos.get(i).getId() == id){
                            if(CopiaprodutosProduzidos.get(i).getQuantidade() == 0){
                                System.out.println("Produto sem estoque!");
                                idEncontrado = true;
                                break;
                            }else{
                                if(CopiaprodutosProduzidos.get(i).getQuantidade() < quantidade){
                                    System.out.println("Quantidade indisponível!");
                                    idEncontrado = true;
                                    break;
                                }

                                produtoProduzido produtoClasse = this.produtoProduzido.get(i);

                                produtoProduzido produtoAux = new produtoProduzido(produtoClasse.getId(), produtoClasse.getNome(), produtoClasse.getPreco(), produtoClasse.getDescricao(), produtoClasse.getFabricante(), produtoClasse.getDataDeFabricacao(), produtoClasse.getDataDeValidade(), quantidade);

                                produtos.add(produtoAux);
                                
                                CopiaprodutosProduzidos.get(i).setQuantidade(this.produtoProduzido.get(i).getQuantidade() - quantidade);
                                idEncontrado = true;
                                break;
                            }
                        }
                    }
                }

                if(!idEncontrado){
                    System.out.println("Id não encontrado!");
                }
            }
        }

        pedido pedido = this.confirmarPedido(scanner, atendente, cliente, produtos, CopiaprodutosIndustrializados, CopiaprodutosProduzidos);

        return pedido;
    }    

    public pedido confirmarPedido(Scanner scanner, Atendente atendente, Cliente cliente, ArrayList<Produto> produtos, ArrayList<produtoIndustrializado> CopiaprodutosIndustrializados, ArrayList<produtoProduzido> CopiaprodutosProduzidos){
        boolean opValida = false;
        String op = null;
        ArrayList<String> ops = new ArrayList<String>(){
            {
                add("S");
                add("N");
            }
        };
        while(!opValida){
            try{
                //Exibir produtos selecionados
                System.out.println("Produtos selecionados: ");
                for(int i = 0; i < produtos.size(); i++){
                    System.out.println("Produto " + (i+1) + ": ");
                    produtos.get(i).exibirProdutoCarrinho();
                }
                System.out.println("Valor total: " + this.calcularValorPedido(produtos));
                System.out.println("------------------------------------");
                System.out.print("Deseja confirmar a venda? (S / N): ");
                op = scanner.nextLine();
            }catch(Exception e){
                System.out.println("Opção inválida!");
            }

            if(!ops.contains(op)){
                System.out.println("Opção inválida, digite 'S' ou 'N'!");
            }else{
                opValida = true;
            }
        }

        if(op.equals("N")){
            System.out.println("Cancelando...");
            return null;
        }

        this.produtoIndustrializado = CopiaprodutosIndustrializados;
        this.produtoProduzido = CopiaprodutosProduzidos;

        pedido pedido = new pedido(atendente, cliente, produtos);

        return pedido;
    }

    public double calcularValorPedido(ArrayList<Produto> produtos){
        double valorTotal = 0;
        for(int i = 0; i < produtos.size(); i++){
            valorTotal += produtos.get(i).getPreco() * produtos.get(i).getQuantidade();
        }

        return valorTotal;
    }
}


