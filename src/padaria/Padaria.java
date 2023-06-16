package padaria;
import java.util.ArrayList;
import java.util.Scanner;
import personas.*;
import excep.*;
import estoque.*;

public class Padaria {
    private String nome;
    private String cnpj;
    private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Padaria(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public Padaria(String nome, String cnpj, ArrayList<Funcionario> funcionarios, ArrayList<Cliente> clientes) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.funcionarios = funcionarios;
        this.clientes = clientes;
    }

    public boolean procurarCpf(String cpf){
        for(Cliente cliente: this.clientes){
            if(cliente.getCpf().equals(cpf)){
                return true;
            }
        }
        for(Funcionario funcionario: this.funcionarios){
            if(funcionario.getCpf().equals(cpf)){
                return true;
            }
        }
        return false;
    }
    
    public void exibirMenuPadaria(){
        String opcao = null;
        boolean sair = false;
        Scanner scanner = new Scanner(System.in);
        while(!sair){
            System.out.println("\n--------------------");
            System.out.println("Sistema Padaria: " + this.nome);
            System.out.println("1 - Gerenciar Funcionários");
            System.out.println("2 - Gerenciar Clientes");
            System.out.println("3 - Gerenciar Estoque");
            System.out.println("--------------------");
            System.out.println("Para sair do programa, digite '0'");
            System.out.println("--------------------");

            boolean opcaoValida = false;

            while(!opcaoValida){
                try{
                    System.out.print("Digite a opção desejada: ");
                    opcao = scanner.nextLine();
                    opcaoValida = true;
                }catch(Exception e){
                    System.out.println("Opção inválida!");
                }
            }

            switch (opcao) {
                case "1":
                    exibirMenuFuncionarios(scanner);
                    break;
                case "2":
                    exibirMenuCliente(scanner);;
                    break;
                case "3":
                    exibirMenuEstoque(scanner);
                    break;
                case "0":
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    public void exibirMenuFuncionarios(Scanner scanner){
        String opcao = null;
        boolean sair = false;

        while(!sair){
            System.out.println("\n--------------------");
            System.out.println("Gerenciar Funcionários");
            System.out.println("1 - Adicionar Funcionário");
            System.out.println("2 - Remover Funcionário");
            System.out.println("3 - Exibir Funcionários");
            System.out.println("--------------------");
            System.out.println("Para voltar ao menu principal, digite '0'");
            System.out.println("--------------------");

            boolean opcao_valida = false;

            while(!opcao_valida){
                try{
                    System.out.print("Digite a opção desejada: ");
                    opcao = scanner.nextLine();
                    opcao_valida = true;
                }catch(Exception e){
                    System.out.println("Opção inválida!");
                }
            }

            switch (opcao) {
                case "1":
                    this.adicionarFuncionario(scanner);
                    break;
            
                case "2":
                    try{
                        this.removerFuncionario(scanner);
                    }catch(NoCpfInDatabaseException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case "3":
                    exibirFuncionários();
                    break;

                case "0":
                    System.out.println("Voltando ao menu principal...");
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    public void adicionarFuncionario(Scanner scanner){
        String opcao = null;
        boolean sair = false;

        while(!sair){
            System.out.println("\n--------------------");
            System.out.println("Digite o tipo de funcionário que deseja adicionar: ");
            System.out.println("1 - Atendente");
            System.out.println("--------------------");
            System.out.println("Para voltar, digite '0'");
            System.out.println("--------------------");

            boolean opcao_valida = false;

            while(!opcao_valida){
                try{
                    System.out.print("Digite a opção desejada: ");
                    opcao = scanner.nextLine();
                    opcao_valida = true;
                }catch(Exception e){
                    System.out.println("Opção inválida!");
                }
            }

            switch (opcao) {
                case "1":
                    this.adicionarAtendente(scanner);
                    break;
            
                case "0":
                    System.out.println("Voltando ao menu anterior...");
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    public void adicionarAtendente(Scanner scanner){
        String nome = null;
        String cpf = null;
        String sexo = null;
        int idade = 0;
        double salario = 0;
        String turno = null;

        System.out.println("\n--------------------");
        System.out.println("Adicionar Atendente");
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

        boolean cpfValido = false;
        while(!cpfValido){
            try{
                System.out.print("Digite o CPF do atendente: ");
                cpf = scanner.nextLine();
            }catch(Exception e){
                System.out.println("CPF inválido!");
            }

            if(cpf.equals("0")){
                System.out.println("Cancelando...");
                return;
            }

            if(cpf.length() != 11){
                System.out.println("CPF inválido!");
            }else if(this.procurarCpf(cpf)){
                System.out.println("CPF já cadastrado!");
                return;
            }
            else{
                cpfValido = true;
            }
        }

        boolean sexoValido = false;
        ArrayList<String> sexos = new ArrayList<String>(){
            {
                add("M");
                add("F");
            }
        };
        while(!sexoValido){
            try{
                System.out.print("Digite o sexo do atendente (M / F): ");
                sexo = scanner.nextLine();
            }catch(Exception e){
                System.out.println("Sexo inválido!");
            }

            if(sexo.equals("0")){
                System.out.println("Cancelando...");
                return;
            }

            if(!sexos.contains(sexo)){
                System.out.println("Sexo inválido, digite 'M' ou 'F'!");
            }else{
                sexoValido = true;
            }
        }

        boolean idadeValida = false;
        while(!idadeValida){
            try{
                System.out.print("Digite a idade do atendente: ");
                idade = scanner.nextInt();
            }catch(Exception e){
                System.out.println("Idade inválida!");
            }

            if(idade == 0){
                System.out.println("Cancelando...");
                return;
            }
            
            if(idade < 0){
                System.out.println("Idade inválida!");
            }else{
                idadeValida = true;
            }
        }

        boolean salarioValido = false;
        while(!salarioValido){
            try{
                System.out.print("Digite o salário do atendente: ");
                salario = scanner.nextDouble();
            }catch(Exception e){
                System.out.println("Salário inválido!");
            }

            if(salario == 0){
                System.out.println("Cancelando...");
                return;
            }

            if(salario < 1200){
                System.out.println("Salário abaixo do mínimo (R$1200,00)");
            }else{
                salarioValido = true;
            }
        }

        boolean turnoValido = false;
        ArrayList<String> turnos = new ArrayList<String>(){
            {
                add("Manha");
                add("Tarde");
                add("Noite");
            }
        };

        while(!turnoValido){
            try{
                System.out.print("Digite o turno do atendente: ");
                turno = scanner.nextLine();
            }catch(Exception e){
                System.out.println("Turno inválido!");
            }

            if(turno.equals("0")){
                System.out.println("Cancelando...");
                return;
            }

            if(!turnos.contains(turno)){
                System.out.println("Digite 'Manha', 'Tarde' ou 'Noite'!");
            }else{
                turnoValido = true;
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

        this.funcionarios.add(new Atendente(nome, cpf, sexo, idade, salario, turno, 0));
        System.out.println("Atendente adicionado com sucesso!");
        return;
    }

    public void removerFuncionario(Scanner scanner) throws NoCpfInDatabaseException{

        if(this.funcionarios.size() == 0){
            System.out.println("Não há funcionários cadastrados!");
            return;
        }

        boolean cpfValido = false;
        boolean cpfEncontrado = false;
        String cpf = null;
        while(!cpfValido){
            try{
                System.out.println("--------------------");
                System.out.print("Remoção de Funcionário: ");
                System.out.println("Para cancelar, digite '0'");
                System.out.println("--------------------");
                System.out.print("Digite o CPF do funcionário que deseja remover: ");
                cpf = scanner.nextLine();
            }catch(Exception e){
                System.out.println("CPF inválido!");
            }

            if(cpf.equals("0")){
                System.out.println("Cancelando...");
                return;
            }

            if(cpf.length() != 11){
                System.out.println("CPF inválido!");
            }else{
                cpfValido = true;
            }
        }

        for(int i = 0; i < this.funcionarios.size(); i++){
            if(this.funcionarios.get(i).getCpf().equals(cpf)){
                boolean opValida = false;
                String op = null;
                ArrayList<String> opcoes = new ArrayList<String>(){
                    {
                        add("S");
                        add("N");
                    }
                };
                while(!opValida){
                    try{
                        System.out.print("Funcionário: " + this.funcionarios.get(i).getNome() + " encontrado!\n Função: " + this.funcionarios.get(i).getFuncao() + "\nDeseja remover? (S / N): ");
                        op = scanner.nextLine();
                    }catch(Exception e){
                        System.out.println("Opção inválida!");
                    }

                    if(!opcoes.contains(op)){
                        System.out.println("Opção inválida, digite 'S' ou 'N'! ");
                    }else{
                        opValida = true;
                    }
                }
                
                if(op.equals("S")){
                    this.funcionarios.remove(i);
                    cpfEncontrado = true;
                    break;
                }else{
                    System.out.println("Cancelando...");
                    return;
                }
            }
        }

        if(cpfEncontrado){
            System.out.println("Funcionário removido com sucesso!");
        }else{
            throw new NoCpfInDatabaseException("CPF não encontrado no banco de dados!", cpf);
        }
    }

    public void exibirFuncionários(){
        System.out.println("Funcionários: ");
        if(this.funcionarios.size() == 0){
            System.out.println("Não há funcionários cadastrados!");
        }else{
            for(int i = 0; i < this.funcionarios.size(); i++){
                System.out.println("Funcionário " + (i+1) + ": ");
                this.funcionarios.get(i).exibirDados();
            }
        }
    }

    public void exibirMenuCliente(Scanner scanner){
        String opcao = null;
        boolean sair = false;

        while(!sair){
            System.out.println("\n--------------------");
            System.out.println("Gerenciar Clientes");
            System.out.println("1 - Adicionar Cliente");
            System.out.println("2 - Remover Cliente");
            System.out.println("3 - Exibir Clientes");
            System.out.println("--------------------");
            System.out.println("Para voltar ao menu principal, digite '0'");
            System.out.println("--------------------");

            boolean opcao_valida = false;

            while(!opcao_valida){
                try{
                    System.out.print("Digite a opção desejada: ");
                    opcao = scanner.nextLine();
                    opcao_valida = true;
                }catch(Exception e){
                    System.out.println("Opção inválida!");
                }
            }

            switch (opcao) {
                case "1":
                    this.adicionarCliente(scanner);
                    break;
            
                case "2":
                    try{
                        this.removerCliente(scanner);
                    }catch(NoCpfInDatabaseException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    exibirClientes();
                    break;

                case "0":
                    System.out.println("Voltando ao menu principal...");
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
    

    public void adicionarCliente(Scanner scanner){
        //Verificar cpf duplicado posteriormente
        String nome = null;
        String cpf = null;
        String sexo = null;
        int idade = 0;
        String endereco = null;
        String telefone = null;

        System.out.println("\n--------------------");
        System.out.println("Adicionar Cliente");
        System.out.println("Caso deseja cancelar, digite '0' em qualquer campo.");
        System.out.println("--------------------");

        boolean nomeValido = false;
        while(!nomeValido){
            try{
                System.out.print("Digite o nome do Cliente: ");
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

        boolean cpfValido = false;
        while(!cpfValido){
            try{
                System.out.print("Digite o CPF do Cliente: ");
                cpf = scanner.nextLine();
            }catch(Exception e){
                System.out.println("CPF inválido!");
            }

            if(cpf.equals("0")){
                System.out.println("Cancelando...");
                return;
            }

            if(cpf.length() != 11){
                System.out.println("CPF inválido!");
            }else if(this.procurarCpf(cpf)){
                System.out.println("CPF já cadastrado!");
                return;
            }
            else{
                cpfValido = true;
            }
        }

        boolean sexoValido = false;
        ArrayList<String> sexos = new ArrayList<String>(){
            {
                add("M");
                add("F");
            }
        };
        while(!sexoValido){
            try{
                System.out.print("Digite o sexo do cliente (M / F): ");
                sexo = scanner.nextLine();
            }catch(Exception e){
                System.out.println("Sexo inválido!");
            }

            if(sexo.equals("0")){
                System.out.println("Cancelando...");
                return;
            }

            if(!sexos.contains(sexo)){
                System.out.println("Sexo inválido, digite 'M' ou 'F'!");
            }else{
                sexoValido = true;
            }
        }

        boolean idadeValida = false;
        while(!idadeValida){
            try{
                System.out.print("Digite a idade do cliente: ");
                idade = scanner.nextInt();
            }catch(Exception e){
                System.out.println("Idade inválida!");
            }

            if(idade == 0){
                System.out.println("Cancelando...");
                return;
            }

            if(idade < 0){
                System.out.println("Idade inválida!");
            }else{
                idadeValida = true;
            }
        }

        boolean enderecoValido = false;
        while(!enderecoValido){
            try{
                System.out.print("Digite o endereço do cliente: ");
                endereco = scanner.nextLine();
            }catch(Exception e){
                System.out.println("Endereço inválido!");
            }

            if(endereco.equals("0")){
                System.out.println("Cancelando...");
                return;
            }

            if(endereco.length() == 0){
                System.out.println("Endereço inválido!");
            }else{
                enderecoValido = true;
            }
        }

        boolean telefoneValido = false;
        while(!telefoneValido){
            try{
                System.out.print("Digite o telefone do cliente: ");
                telefone = scanner.nextLine();
            }catch(Exception e){
                System.out.println("Telefone inválido!");
            }

            if(telefone.equals("0")){
                System.out.println("Cancelando...");
                return;
            }

            if(telefone.length() != 11){
                System.out.println("Telefone inválido!");
            }else{
                telefoneValido = true;
            }
        }

        this.clientes.add(new Cliente(nome, cpf, sexo, idade, endereco, telefone, 0));
        System.out.println("Cliente adicionado com sucesso!");
        return;
    }

    public void removerCliente(Scanner scanner) throws NoCpfInDatabaseException{
        if(this.clientes.size() == 0){
            System.out.println("Não há clientes cadastrados!");
            return;
        }

        boolean cpfValido = false;
        boolean cpfEncontrado = false;
        String cpf = null;
        while(!cpfValido){
            try{
                System.out.print("Digite o CPF do cliente que deseja remover: ");
                cpf = scanner.nextLine();
            }catch(Exception e){
                System.out.println("CPF inválido!");
            }
            if(cpf.length() != 11){
                System.out.println("CPF inválido!");
            }else{
                cpfValido = true;
            }
        }

        for(int i = 0; i < this.clientes.size(); i++){
            if(this.clientes.get(i).getCpf().equals(cpf)){
                this.clientes.remove(i);
                cpfEncontrado = true;
                break;
            }
        }

        if(cpfEncontrado){
            System.out.println("Cliente removido com sucesso!");
        }else{
            throw new NoCpfInDatabaseException("CPF não encontrado no banco de dados!", cpf);
        }
    }
    

    public void exibirClientes(){
        System.out.println("Clientes: ");
        if(this.clientes.size() == 0){
            System.out.println("Não há clientes cadastrados!");
        }else{
            for(int i = 0; i < this.clientes.size(); i++){
                System.out.println("Cliente " + (i+1) + ": ");
                this.clientes.get(i).exibirDados();
            }
        }
    }




    
    public void exibirMenuEstoque(Scanner scanner){
        String opcao = null;
        boolean sair = false;

        while(!sair){
            System.out.println("\n--------------------");
            System.out.println("Gerenciar Estoque");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Remover Produto");
            System.out.println("3 - Exibir Produtos");
            System.out.println("--------------------");
            System.out.println("Para voltar ao menu principal, digite '0'");
            System.out.println("--------------------");

            boolean opcao_valida = false;

            while(!opcao_valida){
                try{
                    System.out.print("Digite a opção desejada: ");
                    opcao = scanner.nextLine();
                    opcao_valida = true;
                }catch(Exception e){
                    System.out.println("Opção inválida!");
                }
            }

            switch (opcao) {
                case "1":
                    this.exibirMenuAdicionar(scanner);
                    break;
            
                case "2":
                    this.exibirMenuRemover(scanner);
                    break;
                case "3":
                    this.exibirMenuExibirProdutos(scanner);
                    break;

                case "0":
                    System.out.println("Voltando ao menu principal...");
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    public void exibirMenuAdicionar(Scanner scanner){
        String opcao = null;
        boolean sair = false;

        while(!sair){
            System.out.println("\n--------------------");
            System.out.println("1 - Adicionar produto industrializado");
            System.out.println("2 - Adicionar produto produzido");
            System.out.println("3 - Adicionar ingrediente");
            System.out.println("0 - Voltar");
            System.out.println("\n--------------------");
            
            boolean opcao_valida = false;

            while(!opcao_valida){
                try{
                    System.out.print("Digite a opção desejada: ");
                    opcao = scanner.nextLine();
                    opcao_valida = true;
                }catch(Exception e){
                    System.out.println("Opção inválida!");
                }
            }

            switch(opcao){
                case "1":
                    adicionarProdutoIndustrializado();
                    break;
                case "2":
                    adicionarProdutoProduzido();
                    break;
                case "3":
                    adicionarIngrediente();
                    break;
                case "0":
                    System.out.println("Voltando ao menu principal...");
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        }
    }

    public void exibirMenuRemover(Scanner scanner){
        String opcao = null;
        boolean sair = false;

        while(!sair){
            System.out.println("1 - Remover produto industrializado");
            System.out.println("2 - Remover produto produzido");
            System.out.println("3 - Remover ingrediente");
            System.out.println("4 - Voltar");
            boolean opcao_valida = false;

            while(!opcao_valida){
                try{
                    System.out.print("Digite a opção desejada: ");
                    opcao = scanner.nextLine();
                    opcao_valida = true;
                }catch(Exception e){
                    System.out.println("Opção inválida!");
                }
            }

            switch(opcao){
                case "1":
                    removerProdutoIndustrializado();
                    break;
                case "2":
                    removerProdutoProduzido();
                    break;
                case "3":
                    removerIngrediente();
                    break;
                case "0":
                    System.out.println("Voltando ao menu principal...");
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
    
    public void exibirMenuExibirProdutos(Scanner scanner){
        String opcao = null;
        boolean sair = false;

        while(!sair){
            System.out.println("\n--------------------");
            System.out.println("1 - Exibir produtos industrializados");
            System.out.println("2 - Exibir produtos produzidos");
            System.out.println("3 - Exibir ingredientes");
            System.out.println("0 - Voltar");
            System.out.println("\n--------------------");
            boolean opcao_valida = false;

            while(!opcao_valida){
                try{
                    System.out.print("Digite a opção desejada: ");
                    opcao = scanner.nextLine();
                    opcao_valida = true;
                }catch(Exception e){
                    System.out.println("Opção inválida!");
                }
            }

            switch(opcao){
                case "1":
                    exibirProdutosIndustrializados();
                    break;
                case "2":
                    exibirProdutosProduzidos();
                    break;
                case "3":
                    exibirIngredientes();
                    break;
                case "0":
                    System.out.println("Voltando ao menu principal...");
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
