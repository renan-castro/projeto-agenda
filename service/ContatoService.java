package service;

import classes.Contato;
import repository.ContatoRepository;

public class ContatoService {

  private ContatoRepository contatoRepository;

  public ContatoRepository getContatoRepository() {
    if(contatoRepository == null){
      contatoRepository = new ContatoRepository();
    }
    return contatoRepository;
  }
  
  public void gravarContato(Contato c){

    if(c.getNome() == null || c.getNome().equals("")){
      System.out.println("Nome obrigatório.");
      return;
    }

    getContatoRepository().gravarContato(c);

  }

  public void listarContatos(){
    getContatoRepository().listarContatos();
  }

}
