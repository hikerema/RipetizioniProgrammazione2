import java.util.ArrayList;

public class Pitagorica {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        ArrayList<ArrayList<Integer>> tavola = creaTavolaPitagorica(n);
        
        for (ArrayList<Integer> riga : tavola) {
            for (int valore : riga) {
                System.out.printf("%4d", valore);
            }
            System.out.println();
        }
    }

    public static ArrayList<Integer> creaRigaPitagorica(int m, int n) {
        ArrayList<Integer> riga = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            riga.add((m + 1) * i);
        }
        return riga;
    }

    public static ArrayList<ArrayList<Integer>> creaTavolaPitagorica(int n) {
        ArrayList<ArrayList<Integer>> tavola = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tavola.add(creaRigaPitagorica(i, n));
        }
        return tavola;
    }
}