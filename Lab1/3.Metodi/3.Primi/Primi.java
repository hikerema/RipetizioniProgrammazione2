/**
 * La classe Primi legge da riga di comando un numero intero soglia e stampa
 * tutti i numeri primi inferiori a soglia.
 * 
 * REQUIRES: Un numero intero soglia passato da riga di comando.
 * MODIFIES: System.out
 * EFFECTS: Stampa i numeri primi inferiori a soglia se soglia > 0, altrimenti stampa un messaggio di errore.
 */
public class Primi {
    public static void main(String[] args) {
        // Controllo che sia passato esattamente un argomento
        if (args.length != 1) {
            System.err.println("Errore: è necessario passare un numero intero come soglia.");
            System.exit(1);
        }

        try {
            int soglia = Integer.parseInt(args[0]);

            // Controllo se la soglia è positiva
            if (soglia <= 0) {
                System.out.println("La soglia inserita non è positiva");
                return;
            }

            System.out.println("Numeri primi inferiori a " + soglia);
            for (int i = 2; i < soglia; i++) {
                if (primo(i)) {
                    System.out.print(i + " ");
                }
            }
            System.out.println(); // Vai a capo dopo l'elenco dei numeri primi

        } catch (NumberFormatException e) {
            System.err.println("Errore: l'argomento deve essere un numero intero.");
            System.exit(1);
        }
    }

    /**
     * Verifica se un numero è primo.
     * 
     * @param n Il numero da verificare.
     * @return true se n è primo, false altrimenti.
     */
    public static boolean primo(int n) {
        if (n < 2) {
            return false; // I numeri inferiori a 2 non sono primi
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; // n è divisibile per i, quindi non è primo
            }
        }
        return true; // n è primo
    }
}