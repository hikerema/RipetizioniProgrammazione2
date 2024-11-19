import java.util.Iterator;

public class Primi implements Iterator<Integer> {
//OVERVIEW: Iteratore Primi che ad ogni chiamata di next() restituisca un successivo numero primo 
    private int current;

    // Costruttore di default: inizia da 2 (il primo numero primo)
    public Primi() {
        this.current = 2;
    }

    // Metodo hasNext: restituisce sempre true, poiché i numeri primi sono infiniti
    @Override
    public boolean hasNext() {
        return true;
    }

    // Metodo next: trova e restituisce il prossimo numero primo
    @Override
    public Integer next() {
        int nextPrime = current;
        current = findNextPrime(current + 1);
        return nextPrime;
    }

    // Metodo helper per trovare il prossimo numero primo
    private int findNextPrime(int start) {
        int candidate = start;
        while (!isPrime(candidate)) {
            candidate++;
        }
        return candidate;
    }

    // Metodo helper per verificare se un numero è primo
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

    // Metodo main per il testing
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Errore: specificare un numero intero n come argomento.");
            return;
        }

        try {
            int n = Integer.parseInt(args[0]);
            if (n <= 0) {
                System.err.println("Errore: il numero n deve essere maggiore di zero.");
                return;
            }

            Primi iteratore = new Primi();
            for (int i = 0; i < n; i++) {
                System.out.println(iteratore.next() + " ");
            }
        } catch (NumberFormatException e) {
            System.err.println("Errore: l'argomento deve essere un numero intero.");
        }
    }
}








































/*import java.util.Iterator;

public class Primi implements Iterator<Integer>{
//OVERVIEW: Iteratore Primi che ad ogni chiamata di next() restituisca un successivo numero primo   

    private int n;

    public Primi() {
        this.n = 2;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        if(p1 == 0)
            return ++p1;
        int sum = p1 + p2;

        this.p2 = this.p1;
        this.p1 = sum;

        return sum;
    }

    public boolean èPrimo(int n) {
        if ()
    }

    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]); //legge un numero da riga di comando

        Primi p = new Primi(); 
        for (int i = 0; i < n; i++) {
            System.out.println(p.next());
        }
    }
}*/