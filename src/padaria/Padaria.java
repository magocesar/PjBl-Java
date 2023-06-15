package padaria;
import java.util.ArrayList;
import java.util.Scanner;
import personas.*;
import excep.*;

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
    

    public void adicionarCliente(){
        //Verificar cpf duplicado posteriormente
    }

    public void removerCliente(String cpf) throws NoCpfInDatabaseException{

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

    public void exibirMenuPadaria(){
        String opcao = null;
        boolean sair = false;
        Scanner scanner = new Scanner(System.in);
        while(!sair){
            System.out.println("\n--------------------");
            System.out.println("Sistema Padaria: " + this.nome);
            System.out.println("1 - Gerenciar Funcionários");
            System.out.println("2 - Gerenciar Clientes");
            System.out.println("--------------------");
            System.out.println("Para sair do programa, digite '!'");
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
                    System.out.println("Gerenciar Clientes");
                    break;
                case "!":
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
            System.out.println("Para voltar ao menu principal, digite '!'");
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

                case "!":
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
            System.out.println("Para voltar, digite '!'");
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
            
                case "!":
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
        System.out.println("--------------------");

        boolean nomeValido = false;
        while(!nomeValido){
            try{
                System.out.print("Digite o nome do atendente: ");
                nome = scanner.nextLine();
            }catch(Exception e){
                System.out.println("Nome inválido!");
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

            if(cpf.length() != 11){
                System.out.println("CPF inválido!");
            }else{
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
            if(!turnos.contains(turno)){
                System.out.println("Digite 'Manha', 'Tarde' ou 'Noite'!");
            }else{
                turnoValido = true;
            }
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
                System.out.print("Digite o CPF do funcionário que deseja remover: ");
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

        for(int i = 0; i < this.funcionarios.size(); i++){
            if(this.funcionarios.get(i).getCpf().equals(cpf)){
                this.funcionarios.remove(i);
                cpfEncontrado = true;
                break;
            }
        }

        if(cpfEncontrado){
            System.out.println("Funcionário removido com sucesso!");
        }else{
            throw new NoCpfInDatabaseException("CPF não encontrado no banco de dados!", cpf);
        }
    }
}
