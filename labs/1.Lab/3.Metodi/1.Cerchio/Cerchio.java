/**
 * La classe Cerchio legge da riga di comando un numero reale raggio e calcola
 * l'area e la circonferenza di un cerchio di quel raggio.
 * 
 * REQUIRES: Un numero reale raggio passato da riga di comando.
 * MODIFIES: System.out
 * EFFECTS: Stampa l'area e la circonferenza del cerchio di raggio raggio.
 */
public class Cerchio {
    public static void main(String[] args) {
        // Controllo che sia passato esattamente un argomento
        if (args.length != 1) {
            System.err.println("Errore: è necessario passare un numero reale per il raggio.");
            System.exit(1);
        }

        try {
            double raggio = Double.parseDouble(args[0]);

            // Calcolo dell'area e della circonferenza
            double area = CalcolaArea(raggio);
            double circonferenza = CalcolaCirconferenza(raggio);

            // Stampa dei risultati
            System.out.println("Area del cerchio: " + area);
            System.out.println("Circonferenza del cerchio: " + circonferenza);
        } catch (NumberFormatException e) {
            System.err.println("Errore: l'argomento deve essere un numero reale.");
            System.exit(1);
        }
    }

    /**
     * Calcola l'area di un cerchio dato il raggio.
     * 
     * @param raggio Il raggio del cerchio.
     * @return L'area del cerchio.
     */
    public static double CalcolaArea(double raggio) {
        return Math.PI * raggio * raggio; // Formula: π * r^2
    }

    /**
     * Calcola la circonferenza di un cerchio dato il raggio.
     * 
     * @param raggio Il raggio del cerchio.
     * @return La circonferenza del cerchio.
     */
    public static double CalcolaCirconferenza(double raggio) {
        return 2 * Math.PI * raggio; // Formula: 2 * π * r
    }
}