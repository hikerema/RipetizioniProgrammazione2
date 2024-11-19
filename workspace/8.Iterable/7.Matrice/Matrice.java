import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Matrice implements Iterable<Integer>{
//OVERVIEW: modelli una matrice di interi di dimensione n * m
//          dove n ed m sono due valori interi passati al costruttore della classe
//          Definisce un metodo iterator() che dovrà restituire un Iterator<Iterator<Integer>>
    private int[][] matrice;

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Iterator<Integer>>() {
            int mRiga = 0;

            @Override
            public boolean hasNext() {
                if(mRiga > matrice.length)
                    return false;
                return true;
            }

            @Override
            public Iterator<Integer> next() {

                if(!hasNext())
                    throw new NoSuchElementException("C scassasti u cazz");
                int[] riga = matrice[mRiga++];
                return new Iterator<Integer>() {
                    int nColonna = 0;
                    @Override
                    public boolean hasNext() {
                        if(nColonna > riga.length)
                            return false;
                        return true;
                    }

                    @Override
                    public Integer next() {
                        if(!hasNext())
                            throw new NoSuchElementException("C scassasti u cazz");
                        return matrice[mRiga][nColonna++];
                    }
                };   
            } 
        };
    }

    public Matrice (int n, int m) {
       this.matrice = new int[n][m];
    }

    public int[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(int n, int m, int v) {
        matrice[n][m] = v;
    }

    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]);
        int m = Integer.valueOf(args[1]);

        Matrice matrice = new Matrice(n, m);
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        for (Iterator<Integer> riga : matrice) {
            System.out.print("Inserisci i" + n + " numeri (separati da spazio) della riga " + count + ": ");
            int v = scanner.nextInt();
            matrice.setMatrice(n, count, v);
            count++;
        }
        scanner.close();

        System.out.print("Matrice inserita: ");
        for (Iterator<Integer> riga : matrice) {
            for (Integer v : riga) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
