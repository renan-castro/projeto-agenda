package classes;

import java.time.LocalDate;

public class Contato {

  private String nome;
  
  private Endereco endereco;

  private LocalDate dtNascimento;

  private TipoContato tipoContato;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public LocalDate getDtNascimento() {
    return dtNascimento;
  }

  public TipoContato getTipoContato() {
    return tipoContato;
  }

  public void setDtNascimento(LocalDate dtNascimento) {
    this.dtNascimento = dtNascimento;
  }

  public void setTipoContato(TipoContato tipoContato) {
    this.tipoContato = tipoContato;
  }

  @Override
  public String toString() {
    return this.getNome()+";"+this.getTipoContato().getDescricao();
  }

}
