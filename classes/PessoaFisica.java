package classes;

public class PessoaFisica extends Pessoa {
  
  private String cpf;

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void retornaInformacao(){
    System.out.printf("PF - O nome é %s e seu telefone é %s com cpf %s",getNome(),getTelefone(),getCpf());
  }

}
