package personas;

public class Cliente extends Pessoa{
    private String endereco;
    private String telefone;
    private int numero_de_compras;

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public int getNumero_de_compras() {
        return numero_de_compras;
    }
    public void setNumero_de_compras(int numero_de_compras) {
        this.numero_de_compras = numero_de_compras;
    }

    public void adicionarNovaCompra(){
        this.numero_de_compras++;
    }

    public Cliente(String nome, String cpf, String sexo, int idade, String endereco, String telefone, int numero_de_compras) {
        super(nome, cpf, sexo, idade);
        this.endereco = endereco;
        this.telefone = telefone;
        this.numero_de_compras = numero_de_compras;
    }

    @Override
    public void exibirDados(){
        System.out.println("--------------------");
        System.out.println("Dados do cliente: ");
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Sexo: " + this.sexo);
        System.out.println("Idade: " + this.idade);
        System.out.println("Endereço: " + this.endereco);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("Número de compras: " + this.numero_de_compras);
        System.out.println("--------------------");
    }

    
}
