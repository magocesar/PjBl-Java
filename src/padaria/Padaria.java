package padaria;
import java.util.ArrayList;
import personas.*;

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
    
    public void adicionarFuncionario(Funcionario funcionario){
        //Verificar cpf duplicado posteriormente
        this.funcionarios.add(funcionario);
    }

    public void removerFuncionario(String cpf){
        for (Funcionario funcionario : funcionarios) {
            if(funcionario.getCpf().equals(cpf)){
                this.funcionarios.remove(funcionario);
                break;
            }
        }
    }

    public void adicionarCliente(Cliente cliente){
        //Verificar cpf duplicado posteriormente
        this.clientes.add(cliente);
    }

    public void removerCliente(String cpf){
        for (Cliente cliente : clientes) {
            if(cliente.getCpf().equals(cpf)){
                this.clientes.remove(cliente);
                break;
            }
        }
    }



    
}
