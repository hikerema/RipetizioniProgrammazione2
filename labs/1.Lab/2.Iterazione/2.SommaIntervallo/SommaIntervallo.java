/**
 * La classe SommaIntervallo legge da riga di comando due numeri interi a e b
 * e calcola la somma dei numeri pari compresi tra a e b (estremi esclusi).
 * 
 * REQUIRES: Due numeri interi a e b passati da riga di comando.
 * MODIFIES: System.out
 * EFFECTS: Stampa la somma dei numeri pari compresi tra a e b esclusi.
 */
public class SommaIntervallo {
    public static void main(String[] args) {
        // Controllo che siano passati esattamente due argomenti
        if (args.length != 2) {
            System.err.println("Errore: è necessario passare due numeri interi.");
            System.exit(1);
        }

        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);

            // Variabile per la somma dei numeri pari
            int somma = 0;

            // Troviamo il minore e il maggiore tra a e b
            int min = Math.min(a, b);
            int max = Math.max(a, b);

            // Sommiamo i numeri pari compresi tra min e max (estremi esclusi)
            for (int i = min + 1; i < max; i++) {
                if (i % 2 == 0) {
                    somma += i;
                }
            }

            System.out.println("Somma = " + somma);
        } catch (NumberFormatException e) {
            System.err.println("Errore: entrambi gli argomenti devono essere numeri interi.");
            System.exit(1);
        }
    }
}