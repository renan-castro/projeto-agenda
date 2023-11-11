package service;

import java.time.LocalDateTime;
import java.time.Period;

import classes.Evento;
import repository.EventoRepository;

public class EventoService {

  private EventoRepository eventoRepository;

  public EventoRepository getEventoRepository() {
    if(eventoRepository == null){
      eventoRepository = new EventoRepository();
    }
    return eventoRepository;
  }
  
  public void gravarEvento(Evento e){

    boolean verifica = false;

    if(e.getNmEvento() == null || e.getNmEvento().equals("")){
      System.out.println("O nome do evento é obrigatório!");
      verifica = true;
    }

    LocalDateTime dtAtual = LocalDateTime.now();

    if(e.getDtEvento().isBefore(dtAtual)){
      System.out.println("A data não pode ser inferior a data atual.");
      verifica = true;
    }

    if(verifica){
      return;
    }

    getEventoRepository().gravarEvento(e);
  }

  public void listarEventos(){
    getEventoRepository().listarEventos();
  }

}
