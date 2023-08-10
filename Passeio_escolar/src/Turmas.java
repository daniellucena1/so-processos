import java.util.ArrayList;

public class Turmas extends Thread {
  private String nome;
  private boolean fim = false;
  private int i = 0;
  private ArrayList<Parques> parques;

  public Turmas(String nome, ArrayList<Parques> parques) {
    this.nome = nome;
    this.parques = parques;
  }

  public void run() {
    while(!fim) {
      try{
        System.out.println(">> " + nome + " chegou ao parque " + parques.get(i).getNome());
        parques.get(i).passeio();
        i++;
      } catch (Exception e) { 
        System.out.println(">> A " + nome + " chegou ao fim do passeio");
        fim = true;
      }
    }
  }
}