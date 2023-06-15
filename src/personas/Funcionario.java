package personas;

public abstract class Funcionario extends Pessoa{
    protected double salario;
    protected double comissao_mensal_adquirida;

    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public double getComissao_mensal_adquirida() {
        return comissao_mensal_adquirida;
    }
    public void setComissao_mensal_adquirida(double comissao_mensal_adquirida) {
        this.comissao_mensal_adquirida = comissao_mensal_adquirida;
    }

    public Funcionario(String nome, String cpf, String sexo, int idade, double salario, double comissao_mensal_adquirida) {
        super(nome, cpf, sexo, idade);
        this.salario = salario;
        this.comissao_mensal_adquirida = comissao_mensal_adquirida;
    }
}
