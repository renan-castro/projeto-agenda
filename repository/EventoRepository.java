package repository;

import java.io.File;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import classes.Evento;

public class EventoRepository {
 
  private static final String arquivo_evento = "C:\\Estudos\\Aulas\\Lógica com Java\\Maio\\git\\projeto_agenda\\arquivo\\evento.ag";

  public void gravarEvento(Evento e){

    File arq = new File(arquivo_evento);

    try {
      FileWriter fw = new FileWriter(arq, true);

      String nomeEvento = e.getNmEvento();
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
      String dtEvento = dtf.format(e.getDtEvento());
      
      fw.write(nomeEvento+";"+dtEvento);
      fw.write(System.lineSeparator());

      fw.close();
      
    } catch (Exception e1) {
      System.out.println("Erro ao gravar arquivo!!!");
    }

  }

  public void listarEventos(){

    File arqContato = new File(arquivo_evento);

    try {
      Scanner leitura = new Scanner(arqContato);

      while(leitura.hasNext()){
        String c = leitura.nextLine();
        String[] texto = c.split(";");

        System.out.printf("Nome Evento: %s\nData Evento: %s\n",texto[0],texto[1]);
      }

      leitura.close();
      
    } catch (Exception e) {
      System.out.println("Não foi possível ler do arquivo!!!");
    }

  }
  
}
