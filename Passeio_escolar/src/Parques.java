public class Parques {
  private String nome;
  private int qtd_turmas;
  private int cont_turmas = 1;

  public Parques(String nome, int qtd_turmas) {
    this.qtd_turmas = qtd_turmas;
    this.nome = nome;
  }

  public String getNome(){
    return this.nome;
  }

  public void passeio() {
    synchronized (this) {
      try {
        System.out.println(">> Parque atual: " + nome);
        if (cont_turmas >= qtd_turmas) {
          System.out.println(">> Todas as turmas chegaram ao fim do parque: " + nome);
          Thread.sleep(5000);
          cont_turmas = 0;
          this.notifyAll();
        } else {
          System.out.println(">> Esperando as turmas chegarem juntas");
          cont_turmas += 1;
          this.wait();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}