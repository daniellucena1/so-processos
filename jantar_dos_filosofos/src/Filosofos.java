import java.util.concurrent.Semaphore;

class Filosofos extends Thread {
    private Semaphore garfo_da_esquerda;
    private Semaphore garfo_da_direita;
    private String nome;

    public Filosofos(String nome, Semaphore garfo_da_esquerda, Semaphore garfo_da_direita) {
        this.nome = nome;
        this.garfo_da_esquerda = garfo_da_esquerda;
        this.garfo_da_direita = garfo_da_direita;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Filósofo " + nome + " está pensando");
                Thread.sleep(1000);

                garfo_da_esquerda.acquire();
                System.out.println("Filósofo " + nome + " pegou o garfo da esquerda");
                
                garfo_da_direita.acquire();
                System.out.println("Filósofo " + nome + " pegou o garfo da direita e está comendo");
                
                Thread.sleep(2000);

                garfo_da_esquerda.release();
                System.out.println("Filósofo " + nome + " soltou o garfo da esquerda");
                
                garfo_da_direita.release();
                System.out.println("Filósofo " + nome + " soltou o garfo da direita");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}