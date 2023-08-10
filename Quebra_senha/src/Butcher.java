public class Butcher extends Thread{
    char[] senha_original;
    char[] possiveis_carac;
    boolean senha_encontrada;
    char[] senha_teste;
    int id;

    public Butcher(String senha_original, char[] possiveis_carac, String senha_teste, boolean senha_encontrada, int id) {
        this.senha_original = senha_original.toCharArray();
        this.possiveis_carac = possiveis_carac;
        this.senha_encontrada = senha_encontrada;
        this.senha_teste = senha_teste.toCharArray();
        this.id = id;
    }

    public StringBuilder to_s(char[] sequence){
        StringBuilder st = new StringBuilder();
        for (char c : sequence) {
            st.append(c);
        }
        return st;
    }

    public void run() {
        while(senha_encontrada == false) {
            synchronized(this){
                try {
                    for (char c : possiveis_carac) {
                        for(int j = 0; j < senha_original.length; j++) {
                            if(c == senha_original[j]){
                                senha_teste[j] = c;
                                System.out.println(">> Senha: " + to_s(senha_teste));
                            }
                        }
                    String teste = to_s(senha_teste).toString();
                    String original = to_s(senha_original).toString();
                    if(teste.equals(original)){
                        senha_encontrada = true;
                        System.out.println(">> Senha [" + to_s(senha_teste) + "] encontrada pela Thread #" + id);
                        
                    }else{
                        System.out.println(">> Senha incorreta");
                    }
                    }
                } catch (Exception e) {
    
                }
            }
        }
    }
}