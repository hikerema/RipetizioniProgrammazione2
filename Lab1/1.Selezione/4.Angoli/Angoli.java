/**
 * La classe Angoli legge da riga di comando le ampiezze di due angoli di un triangolo
 * e calcola l'ampiezza del terzo angolo, se possibile.
 * 
 * REQUIRES: Due numeri interi che rappresentano le ampiezze di due angoli di un triangolo.
 * MODIFIES: System.out
 * EFFECTS: Stampa l'ampiezza del terzo angolo se la somma dei due angoli è minore di 180°.
 *          Altrimenti, stampa che i due angoli non appartengono ad un triangolo.
 */
public class Angoli {
    public static void main(String[] args) {
        // Controllo che siano passati esattamente due argomenti
        if (args.length != 2) {
            System.err.println("Errore: è necessario passare due angoli interi.");
            System.exit(1);
        }

        try {
            int angolo1 = Integer.parseInt(args[0]);
            int angolo2 = Integer.parseInt(args[1]);

            // Verifico che i due angoli siano validi per formare un triangolo
            if (angolo1 <= 0 || angolo2 <= 0 || angolo1 + angolo2 >= 180) {
                System.out.println("I due angoli non appartengono ad un triangolo");
            } else {
                int terzoAngolo = 180 - (angolo1 + angolo2);
                System.out.println("Ampiezza terzo angolo = " + terzoAngolo + "°");
            }
        } catch (NumberFormatException e) {
            System.err.println("Errore: entrambi gli argomenti devono essere numeri interi.");
            System.exit(1);
        }
    }
}