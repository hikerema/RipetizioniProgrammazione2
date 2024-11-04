/**
 * Perfetti
 */
public class Perfetti {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Errore");
            System.exit(1);
        }
        int n = Integer.parseInt(args[0]);
        if (Perfetto(n))
            System.out.println(n + " e' perfetto");
        else
            System.out.println(n + " non e' perfetto");
    }
    public static int SommaDivisoriPropri(int n) {
        int somma = 0;
        if (n > 0) {
            for (int i = 1; i <= n/2; i++) {
                if (n % i == 0)
                    somma += i;
            }
           
        }
        return somma;
    }
    public static boolean Perfetto(int n) {
        int somma = SommaDivisoriPropri(n);
        if (somma == n && somma != 0)
            return true;
        return false;
    }
}