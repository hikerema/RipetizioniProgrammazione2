/**
 * La classe Divisori legge da riga di comando un numero intero n e stampa i suoi divisori propri,
 * ovvero tutti i divisori escluso il numero stesso.
 * 
 * REQUIRES: Un numero intero n passato da riga di comando.
 * MODIFIES: System.out
 * EFFECTS: Stampa i divisori propri del numero n.
 */
public class Divisori {
    public static void main(String[] args) {
        // Controllo che sia passato esattamente un argomento
        if (args.length != 1) {
            System.err.println("Errore: è necessario passare un solo numero intero.");
            System.exit(1);
        }

        try {
            int n = Integer.parseInt(args[0]);

            // Controllo se n è positivo
            if (n <= 0) {
                System.err.println("Errore: il numero deve essere positivo.");
                System.exit(1);
            }

            System.out.print("Divisori di " + n + ": ");

            // Troviamo e stampiamo i divisori propri di n
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();

        } catch (NumberFormatException e) {
            System.err.println("Errore: l'argomento deve essere un numero intero.");
            System.exit(1);
        }
    }
}