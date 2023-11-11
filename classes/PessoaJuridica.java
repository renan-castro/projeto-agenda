package classes;

public class PessoaJuridica extends Pessoa {
  
  private String cnpj;

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public void retornaInformacao(){
    System.out.printf("PJ - O nome é %s e seu telefone é %s",getNome(),getTelefone());
  }

}
