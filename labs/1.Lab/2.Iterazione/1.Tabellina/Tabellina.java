/**
 * La classe Tabellina legge da riga di comando un numero intero n e stampa la tabellina del numero fino a 10.
 * 
 * REQUIRES: Un numero intero n passato da riga di comando.
 * MODIFIES: System.out
 * EFFECTS: Stampa la tabellina del numero n da 1 a 10.
 */
public class Tabellina {
    public static void main(String[] args) {
        // Controllo che sia passato esattamente un argomento
        if (args.length != 1) {
            System.err.println("Errore: è necessario passare un solo numero intero.");
            System.exit(1);
        }

        try {
            int n = Integer.parseInt(args[0]);

            // Stampa della tabellina del numero n
            for (int i = 1; i <= 10; i++) {
                System.out.println(i + " x " + n + " = " + (i * n));
            }
        } catch (NumberFormatException e) {
            System.err.println("Errore: l'argomento deve essere un numero intero.");
            System.exit(1);
        }
    }
}