
import java.util.ArrayList;


public class Fattoriale {
//OVERVIEW: fattoriale
    
    public static int fattoriale(int n) {
    //EFFECTS: restituisce il fattoriale di n
        if (n == 0 || n == 1)
            return 1;
        return n * fattoriale(n-1);
    }

    public static List<Integer> listaFattoriale(int n) {
    //EFFECTS: restituisce una lista di fattoriali
        ArrayList lista = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lista.add(fattoriale(i));
        }
    }

    public static void stampaFattoriali(List<Integer> lista) {
    //EFFECTS: stampa la lista dei fattoriali di listaFattoriale
        System.out.println(lista);
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(listaFattoriale(n));
    }
    
}