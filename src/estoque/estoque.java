package estoque;
import java.util.ArrayList;
import java.util.Scanner;
import excep.NoIdInDatabaseException;
import produtos.*;
import personas.*;
import vendas.*;

public class estoque {
    private int id = 1;
    private ArrayList<produtoIndustrializado> produtoIndustrializado = new ArrayList<produtoIndustrializado>();

    private ArrayList<produtoProduzido> produtoProduzido = new ArrayList<produtoProduzido>();

    public void adicionarProdutoIndustrializado(Scanner scanner){
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

    public void exibirProdutosIndustrializados(){
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

    public void novaVenda(Scanner scanner, Atendente atendente, Cliente cliente){
        ArrayList<Produto> produtos = new ArrayList<Produto>();
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
                System.out.println("Produtos industrializados: ");
                if(this.produtoIndustrializado.size() == 0){
                    System.out.println("Não há produtoIndustrializado cadastrados!");
                }else{
                    for(int i = 0; i < this.produtoIndustrializado.size(); i++){
                        System.out.println("Produto Industrializado " + (i+1) + ": ");
                        this.produtoIndustrializado.get(i).exibirPrateleira();
                    }
                }

                System.out.println("Produtos Produzidos: ");
                if(this.produtoProduzido.size() == 0){
                    System.out.println("Não há Produtos Produzidos cadastrados!");
                }else{
                    for(int i = 0; i < this.produtoProduzido.size(); i++){
                        System.out.println("Cliente " + (i+1) + ": ");
                        this.produtoProduzido.get(i).exibirPrateleira();
                    }
                }

                try{
                    System.out.print("Deseja adicionar um produto? (S / N): ");
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
                sair = true;
            }else{
                boolean idValido = false;
                int id = 0;
                while(!idValido){
                    try{
                        System.out.print("Digite o id do produto: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                    }catch(Exception e){
                        System.out.println("Id inválido!");
                    }

                    if(id < 0){
                        System.out.println("Id inválido!");
                    }else{
                        idValido = true;
                    }
                }

                boolean idEncontrado = false;
                for(int i = 0; i < this.produtoIndustrializado.size(); i++){
                    if(this.produtoIndustrializado.get(i).getId() == id){
                        produtos.add(this.produtoIndustrializado.get(i));
                        idEncontrado = true;
                        break;
                    }
                }

                if(!idEncontrado){
                    for(int i = 0; i < this.produtoProduzido.size(); i++){
                        if(this.produtoProduzido.get(i).getId() == id){
                            produtos.add(this.produtoProduzido.get(i));
                            idEncontrado = true;
                            break;
                        }
                    }
                }

                if(!idEncontrado){
                    System.out.println("Id não encontrado!");
                }
            }
        }

        this.confirmarPedido(scanner, atendente, cliente, produtos);
    }    

    public pedido confirmarPedido(Scanner scanner, Atendente atendente, Cliente cliente, ArrayList<Produto> produtos){
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

        pedido pedido = new pedido(atendente, cliente, produtos);

        return pedido;
    }
}


