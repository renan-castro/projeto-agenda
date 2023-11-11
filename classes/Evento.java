package classes;

import java.time.LocalDateTime;

public class Evento {

  private String nmEvento;

  private LocalDateTime dtEvento;

  private String tipoEvento;

  public void setNmEvento(String nome){
    nmEvento = nome;
  }

  public String getNmEvento(){
    return nmEvento;
  }

  public LocalDateTime getDtEvento() {
    return dtEvento;
  }

  public void setDtEvento(LocalDateTime dtEvento) {
    this.dtEvento = dtEvento;
  }

  public String getTipoEvento() {
    return tipoEvento;
  }

  public void setTipoEvento(String tipoEvento) {
    this.tipoEvento = tipoEvento;
  }
  
}
