/**
 * La classe Segno legge da riga di comando un numero intero e lo stampa con il segno.
 * 
 * MODIFIES: System.out
 * EFFECTS: Stampa il numero intero n, preceduto dal segno '+' se n è positivo,
 *          senza segno se n è 0, e con il segno '-' se n è negativo.
 */
public class Segno {
    public static void main(String[] args) {
        // Controllo che sia passato un solo argomento
        if (args.length != 1) {
            System.err.println("Errore: è necessario passare un solo numero intero.");
            System.exit(1);
        }

        try {
            int n = Integer.parseInt(args[0]);

            if (n > 0) {
                System.out.println("+" + n);
            } else {
                System.out.println(n);
            }
        } catch (NumberFormatException e) {
            System.err.println("Errore: l'argomento deve essere un numero intero.");
            System.exit(1);
        }
    }
}