package personas;

public abstract class Funcionario extends Pessoa{
    protected double salario;
    protected String turno;

    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public String getTurno() {
        return this.turno;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Funcionario(String nome, String cpf, String sexo, int idade, double salario, String turno) {
        super(nome, cpf, sexo, idade);
        this.salario = salario;
        this.turno = turno;
    }
}
