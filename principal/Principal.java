package principal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import classes.Contato;
import classes.Endereco;
import classes.EnderecoComercial;
import classes.EnderecoResidencial;
import classes.Evento;
import classes.TipoContato;
import service.ContatoService;
import service.EventoService;

public class Principal {

  private static ContatoService contatoService;

  private static EventoService eventoService;

  public static ContatoService getContatoService() {
    if(contatoService == null){
      contatoService = new ContatoService();
    }
    return contatoService;
  }

  public static EventoService getEventoService() {
    if(eventoService == null){
      eventoService = new EventoService();
    }
    return eventoService;
  }
  
  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    
    Contato c;
    Evento e;

    boolean verifica = true;
    
    do{

      System.out.println("********************");
      System.out.println("        MENU        ");
      System.out.println("********************");
      System.out.println("1 - Cadastrar contato");
      System.out.println("2 - Cadastrar evento");
      System.out.println("3 - Mostrar contato");
      System.out.println("4 - Mostrar evento");
      System.out.println("99 - Sair");
      System.out.println("********************");
      System.out.print("Digite uma opção: ");
      int opcao = s.nextInt();

      switch(opcao){
        case 1:
          c = montarContato(s);
          getContatoService().gravarContato(c);
          break;
        case 2:
          e = montarEvento(s);
          getEventoService().gravarEvento(e);
          break;
        case 3:
          getContatoService().listarContatos();
          break;
        case 4:
          getEventoService().listarEventos();
          break;
        case 99:
          verifica = false;
          break;
        default:
        System.out.println("Opção de menu inválida!");
      }

    }while(verifica);


    s.close();

  }

  public static Contato montarContato(Scanner s){

    s.nextLine();

    System.out.print("Digite o nome do contato: ");
    String nome = s.nextLine();

    System.out.print("Digite o telefone do contato: ");
    String telefone = s.nextLine();

    System.out.print("Digite a data de nascimento do contato: ");
    String dtNascimento = s.nextLine();

    Contato c = new Contato();

    c.setNome(nome);

    System.out.println("Digite o tipo de endereço(R ou C): ");
    String end = s.nextLine();

    Endereco endereco = new Endereco();
    if(end.toUpperCase().equals("R")){
      EnderecoResidencial endRes = new EnderecoResidencial();
      endereco = endRes;
      endRes.setTelefoneResidencial(telefone);
    } else if(end.toUpperCase().equals("C")){
      EnderecoComercial endCom = new EnderecoComercial();
      endereco = endCom;
      endCom.setTelefoneComercial(telefone);
    }

    c.setEndereco(endereco);

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate ld = LocalDate.parse(dtNascimento, dtf);
    c.setDtNascimento(ld);

    c.setTipoContato(TipoContato.FAMILIA);

    return c;
  }

  public static Evento montarEvento(Scanner s){
    s.nextLine();
    
    System.out.print("Digite o nome do evento: ");
    String nmEvento = s.nextLine();

    System.out.print("Digite a data do evento(dd/MM/yyyy hh:mm): ");
    String strDtEvento = s.nextLine();

    Evento e = new Evento();
    e.setNmEvento(nmEvento);

    DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    LocalDateTime dtEvento = LocalDateTime.parse(strDtEvento, dtf);

    e.setDtEvento(dtEvento);

    return e;
  }

  

}
