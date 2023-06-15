package fornecedor;

public class Fornecedor {
  public String nome; 
  public int id; 
  public String cnpj;
  public String endereco;
  public String telefone;
  public String email;

  public String getNome(){
    return nome; 
  }

  public void setNome(String nome){
    this.nome = nome; 
  }

  public int getId(){
    return id; 
  }

  public void setId(int id){
    this.id = id; 
  }

  public String getCnpj(){
    return cnpj; 
  }

  public void setCnpj(String cnpj){
    this.cnpj = cnpj; 
  }

  public String getEndereco(){
    return endereco; 
  }

  public void setEndereco(String endereco){
    this.endereco = endereco; 
  }

  public String getTelefone(){
    return telefone; 
  }

  public void setTelefone(String telefone){
    this.telefone = telefone; 
  }

  public String getEmail(){
    return email; 
  }

  public void setEmail(String email){
    this.email = email; 
  }

  public Fornecedor(String nome, int id, String cnpj, String endereco, String telefone, String email){
    this.nome = nome; 
    this.id = id; 
    this.cnpj = cnpj; 
    this.endereco = endereco; 
    this.telefone = telefone; 
    this.email = email; 
  }

  public void exibirDados(){
    System.out.println("Nome: " + this.nome + "\nID: " + this.id + "\nCNPJ: " + this.cnpj + "\nEndereço: " + this.endereco + "\nTelefone: " + this.telefone + "\nEmail: " + this.email); 
  }
}
