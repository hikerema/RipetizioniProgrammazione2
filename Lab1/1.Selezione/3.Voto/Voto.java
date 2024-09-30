/**
 * La classe Voto legge da riga di comando un voto e stampa la relativa valutazione.
 * 
 * REQUIRES: Un numero intero v compreso tra 0 e 100 passato da riga di comando.
 * MODIFIES: System.out
 * EFFECTS: Stampa la valutazione in base al voto:
 *          - 'Insufficiente' se v < 60
 *          - 'Sufficiente' se 60 <= v < 70
 *          - 'Buono' se 70 <= v < 80
 *          - 'Distinto' se 80 <= v < 90
 *          - 'Ottimo' se 90 <= v <= 100
 *          - 'Errore' se v < 0 o v > 100
 */
public class Voto {
    public static void main(String[] args) {
        // Controllo che sia passato esattamente un argomento
        if (args.length != 1) {
            System.err.println("Errore: è necessario passare un solo voto intero.");
            System.exit(1);
        }

        try {
            int v = Integer.parseInt(args[0]);

            if (v < 0 || v > 100) {
                System.out.println("Errore");
            } else if (v < 60) {
                System.out.println("Insufficiente");
            } else if (v < 70) {
                System.out.println("Sufficiente");
            } else if (v < 80) {
                System.out.println("Buono");
            } else if (v < 90) {
                System.out.println("Distinto");
            } else {
                System.out.println("Ottimo");
            }
        } catch (NumberFormatException e) {
            System.err.println("Errore: l'argomento deve essere un numero intero.");
            System.exit(1);
        }
    }
}