package repository;

import java.io.File;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import classes.Contato;
import classes.Endereco;
import classes.EnderecoComercial;
import classes.EnderecoResidencial;

public class ContatoRepository {
  
  private static final String arquivo_contato = "C:\\Estudos\\Aulas\\Lógica com Java\\Maio\\git\\projeto_agenda\\arquivo\\contato.ag";

  public void gravarContato(Contato c){

    File arq = new File(arquivo_contato);

    try {
      FileWriter fw = new FileWriter(arq, true);

      String nome = c.getNome();
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      String dtNascimento = dtf.format(c.getDtNascimento());
      String telefone = "";
      Endereco end = c.getEndereco();
      if(end instanceof EnderecoComercial){
        EnderecoComercial ec = (EnderecoComercial)end;
        telefone = ec.getTelefoneComercial();
      } else if (end instanceof EnderecoResidencial){
        EnderecoResidencial er = (EnderecoResidencial)end;
        telefone = er.getTelefoneResidencial();
      } else {
        System.out.println("Endereço não tipificado!!!");
      }
      String tpContato = c.getTipoContato().getDescricao();

      fw.write(nome+";"+dtNascimento+";"+telefone+";"+tpContato);
      fw.write(System.lineSeparator());

      fw.close();
      
    } catch (Exception e) {
      System.out.println("Erro ao gravar arquivo!!!");
    }


  }

  public void listarContatos(){

    File arqContato = new File(arquivo_contato);

    try {
      Scanner leitura = new Scanner(arqContato);

      while(leitura.hasNext()){
        String c = leitura.nextLine();
        String[] texto = c.split(";");

        System.out.printf("Nome: %s\nData Nascimento: %s\n",texto[0],texto[1]);
      }

      leitura.close();
      
    } catch (Exception e) {
      System.out.println("Não foi possível ler do arquivo!!!");
    }

  }

  public void mostrarContatos(List<Contato> listaContato){
    for(Contato c : listaContato){
      String nome = c.getNome();

      String telefone = "";

      Endereco end = c.getEndereco();
      if(end instanceof EnderecoComercial){
        EnderecoComercial ec = (EnderecoComercial)end;
        telefone = ec.getTelefoneComercial();
      } else if (end instanceof EnderecoResidencial){
        EnderecoResidencial er = (EnderecoResidencial)end;
        telefone = er.getTelefoneResidencial();
      } else {
        System.out.println("Endereço não tipificado!!!");
      }

      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      String data = c.getDtNascimento().format(dtf);

      System.out.printf("Nome: %s\nContato: %s\nTelefone: %s\nData Nascimento: %s\n", nome, c.getTipoContato().getDescricao(),
        telefone, data);
      System.out.println("%%%%%%%%%%%%%");

    }

  }

}
