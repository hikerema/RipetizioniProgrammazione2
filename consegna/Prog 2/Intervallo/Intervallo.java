/**
 * Intervallo
 */
public class Intervallo {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Errore");
            System.exit(1);
        }

        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);

        System.out.println("Somma = " + Somma(n1, n2));
    }
    public static int Somma(int n1, int n2) {
        int count = 0;
        for (int i = n1+1; i < n2; i++) {
            if (i % 2 == 0)
                count += i;
        }
        return count;
    }
}