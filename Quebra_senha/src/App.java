public class App {
    public static void main(String[] args) throws Exception {
        String senha_original = "9164236099";
        char[] possiveis_carac = {'0','1','2','3','4','5','6','7','8','9',};
        boolean senha_encontrada = false;
        String senha_teste = "0000000000";
        
        for(int i = 0; i < 10; i++) {
            new Butcher(senha_original, possiveis_carac, senha_teste, senha_encontrada, i).start();
        }
    }
}