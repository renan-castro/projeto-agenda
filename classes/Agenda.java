package classes;

import java.util.List;

public class Agenda {

  private List<Contato> contatos;

  private List<Evento> eventos;

  public List<Contato> getContatos() {
    return contatos;
  }

  public List<Evento> getEventos() {
    return eventos;
  }

  public void setContatos(List<Contato> contatos) {
    this.contatos = contatos;
  }

  public void setEventos(List<Evento> eventos) {
    this.eventos = eventos;
  }
  

}