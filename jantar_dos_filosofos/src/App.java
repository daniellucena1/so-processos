import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) {
        String[] fil = {"Sócrates", "Aristóteles", "Platão", "Descartes", "Popper"};
        int  qtd_filosofos = 5;
        Semaphore[] garfos = new Semaphore [qtd_filosofos];
        for (int i = 0; i <  qtd_filosofos; i++) {
            garfos[i] = new Semaphore(1);
        }

        Filosofos[] filosofos = new Filosofos [qtd_filosofos];
        for (int i = 0; i <  qtd_filosofos; i++) {
            filosofos[i] = new Filosofos(fil[i], garfos[i], garfos[(i + 1) %  qtd_filosofos]);
            filosofos[i].start();
        }
    }
}