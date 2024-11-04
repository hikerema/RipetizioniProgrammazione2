/**
 * La classe Radice legge da riga di comando un numero reale n e calcola
 * la radice quadrata di n se n è maggiore di zero.
 * 
 * REQUIRES: Un numero reale n passato da riga di comando.
 * MODIFIES: System.out
 * EFFECTS: Stampa la radice quadrata di n se n > 0, altrimenti stampa un messaggio di errore.
 */
public class Radice {
    public static void main(String[] args) {
        // Controllo che sia passato esattamente un argomento
        if (args.length != 1) {
            System.err.println("Errore: è necessario passare un numero reale.");
            System.exit(1);
        }

        try {
            double n = Double.parseDouble(args[0]);

            // Controllo se n è maggiore di zero
            if (n > 0) {
                double radice = radiceQuadrata(n);
                System.out.println("Radice quadrata: " + radice);
            } else {
                System.out.println("Il valore inserito non appartiene al dominio della funzione");
            }
        } catch (NumberFormatException e) {
            System.err.println("Errore: l'argomento deve essere un numero reale.");
            System.exit(1);
        }
    }

    /**
     * Calcola la radice quadrata di un numero se è maggiore di zero.
     * 
     * @param numero Il numero da cui calcolare la radice quadrata.
     * @return La radice quadrata di numero se numero > 0, altrimenti 0.
     */
    public static double radiceQuadrata(double numero) {
        return (numero > 0) ? Math.sqrt(numero) : 0;
    }
}