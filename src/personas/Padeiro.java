package personas;

public class Padeiro extends Funcionario{
    private int numero_mercadorias_produzidas;

    public int getNumero_mercadorias_produzidas() {
        return numero_mercadorias_produzidas;
    }

    public void setNumero_mercadorias_produzidas(int numero_mercadorias_produzidas) {
        this.numero_mercadorias_produzidas = numero_mercadorias_produzidas;
    }

    public Padeiro(String nome, String cpf, String sexo, int idade, double salario, String turno, int numero_mercadorias_produzidas) {
        super(nome, cpf, sexo, idade, salario, turno);
        this.numero_mercadorias_produzidas = numero_mercadorias_produzidas;
    }

    @Override
    public String getFuncao(){
        return "Padeiro";
    }

    @Override
    public void exibirDados(){
        System.out.println("--------------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Sexo: " + this.sexo);
        System.out.println("Idade: " + this.idade);
        System.out.println("Função: Padeiro");
        System.out.println("Salário: " + this.salario);
        System.out.println("Turno: " + this.turno);
        System.out.println("Numero de mercadorias produzidas: " + this.numero_mercadorias_produzidas);
        System.out.println("--------------------");
    }
}
