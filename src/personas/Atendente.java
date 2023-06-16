package personas;

public class Atendente extends Funcionario{
    private int vendas_realizadas;

    public int getVendas_realizadas() {
        return vendas_realizadas;
    }

    public void setVendas_realizadas(int vendas_realizadas) {
        this.vendas_realizadas = vendas_realizadas;
    }

    public void adicionarNovaVenda(){
        this.vendas_realizadas++;
    }

    public Atendente(String nome, String cpf, String sexo, int idade, double salario, String turno, int vendas_realizadas) {
        super(nome, cpf, sexo, idade, salario, turno);
        this.vendas_realizadas = vendas_realizadas;
    }

    @Override
    public String getFuncao(){
        return "Atendente";
    }

    @Override
    public void exibirDados(){
        System.out.println("--------------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Sexo: " + this.sexo);
        System.out.println("Idade: " + this.idade);
        System.out.println("Função: Atendente");
        System.out.println("Salário: " + this.salario);
        System.out.println("Turno: " + this.turno);
        System.out.println("Vendas realizadas: " + this.vendas_realizadas);
        System.out.println("--------------------");
    }

    
}
