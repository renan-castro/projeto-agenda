package classes;

public enum TipoContato {
  
  FAMILIA("Família"),
  AMIGOS("Amigos"),
  LOJAS("Comercial");

  private String descricao;

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  TipoContato(String desc){
    this.descricao = desc;
  }

}
