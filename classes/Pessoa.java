package classes;

public class Pessoa {

  private String nome;

  private String telefone;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public void retornaInformacao(){
    System.out.printf("O nome é %s e seu telefone é %s",nome,telefone);
  }

}
