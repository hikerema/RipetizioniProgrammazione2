/**
 * La classe Perfetti legge da riga di comando un numero intero n
 * e verifica se n è un numero perfetto.
 * 
 * REQUIRES: Un numero intero n passato da riga di comando.
 * MODIFIES: System.out
 * EFFECTS: Stampa se n è perfetto oppure no.
 */
public class Perfetti {
    public static void main(String[] args) {
        // Controllo che sia stato passato un argomento
        if (args.length != 1) {
            System.err.println("Errore: è necessario passare un numero intero.");
            System.exit(1);
        }

        try {
            int n = Integer.parseInt(args[0]);

            if (perfetto(n)) {
                System.out.println(n + " è perfetto");
            } else {
                System.out.println(n + " non è perfetto");
            }

        } catch (NumberFormatException e) {
            System.err.println("Errore: l'argomento deve essere un numero intero.");
            System.exit(1);
        }
    }

    /**
     * Calcola la somma dei divisori propri di n.
     * 
     * @param n Il numero di cui calcolare i divisori propri.
     * @return La somma dei divisori propri di n.
     */
    public static int sommaDivisoriPropri(int n) {
        if (n <= 1) return 0; // Nessun divisore proprio per 0 e 1

        int somma = 0;

        // Ciclo per trovare i divisori propri
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                somma += i; // Aggiungi il divisore
            }
        }
        return somma; // Restituisci la somma
    }

    /**
     * Verifica se n è un numero perfetto.
     * 
     * @param n Il numero da verificare.
     * @return true se n è perfetto, false altrimenti.
     */
    public static boolean perfetto(int n) {
        return n == sommaDivisoriPropri(n); // Controlla se n è uguale alla somma dei suoi divisori propri
    }
}