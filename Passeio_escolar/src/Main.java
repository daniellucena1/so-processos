import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    String[] parq = {"Ibirapuera", "Hyde Park", "Central Park", "Parque Farropilha", "Jardim Luxemburgo"};
    String[] turm = {"Turma 1", "Turma 2", "Turma 3", "Turma 4", "Turma 5"};
    ArrayList<Parques> parques = new ArrayList<Parques>();
    ArrayList<Turmas> turmas = new ArrayList<Turmas>();
    for (String parques2 : parq) {
      parques.add(new Parques(parques2, turm.length));
    }
    for(String turmas2 : turm) {
      turmas.add(new Turmas(turmas2, parques));
    }
    for (Turmas turmas2 : turmas) {
      turmas2.start();
    }
  }
}