/**
 * La classe TernePitagoriche legge da riga di comando un intero soglia e stampa
 * tutte le terne pitagoriche con a, b e c inferiori a soglia.
 * 
 * REQUIRES: Un numero intero soglia > 0 passato da riga di comando.
 * MODIFIES: System.out
 * EFFECTS: Stampa tutte le terne pitagoriche con a, b e c < soglia.
 */
public class TernePitagoriche {
    public static void main(String[] args) {
        // Controllo che sia passato esattamente un argomento
        if (args.length != 1) {
            System.err.println("Errore: è necessario passare un numero intero come soglia.");
            System.exit(1);
        }

        try {
            int soglia = Integer.parseInt(args[0]);

            // Controllo che la soglia sia positiva
            if (soglia <= 0) {
                System.err.println("Errore: la soglia deve essere maggiore di zero.");
                return;
            }

            System.out.println("Terne pitagoriche:");
            boolean found = false; // Variabile per controllare se sono state trovate terne

            // Ciclo attraverso tutti i valori di a, b e c
            for (int a = 1; a < soglia; a++) {
                for (int b = a; b < soglia; b++) {
                    for (int c = b; c < soglia; c++) {
                        if (ternaPitagorica(a, b, c)) {
                            System.out.printf("(%d, %d, %d)%n", a, b, c);
                            found = true; // Terna trovata
                        }
                    }
                }
            }

            if (!found) {
                System.out.println("Nessuna terna pitagorica trovata.");
            }

        } catch (NumberFormatException e) {
            System.err.println("Errore: l'argomento deve essere un numero intero.");
            System.exit(1);
        }
    }

    /**
     * Verifica se a, b e c formano una terna pitagorica.
     * 
     * @param a Il primo numero della terna.
     * @param b Il secondo numero della terna.
     * @param c Il terzo numero della terna.
     * @return true se c^2 è uguale a a^2 + b^2, false altrimenti.
     */
    public static boolean ternaPitagorica(int a, int b, int c) {
        return (c * c) == (a * a + b * b); // Controllo della condizione di Pitagora
    }
}