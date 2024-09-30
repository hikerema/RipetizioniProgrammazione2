/**
 * La classe Multiplo legge due numeri interi da riga di comando e verifica se il primo è multiplo del secondo.
 * 
 * REQUIRES: Due numeri interi passati come argomenti da riga di comando.
 * MODIFIES: System.out
 * EFFECTS: Stampa se il primo numero è multiplo del secondo, altrimenti stampa che non lo è.
 */
public class Multiplo {
    public static void main(String[] args) {
        // Controllo che siano passati esattamente due argomenti
        if (args.length != 2) {
            System.err.println("Errore: è necessario passare due numeri interi.");
            System.exit(1);
        }

        try {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);

            if (num2 == 0) {
                System.err.println("Errore: il secondo numero non può essere zero.");
                System.exit(1);
            }

            if (num1 % num2 == 0) {
                System.out.println(num1 + " è multiplo di " + num2);
            } else {
                System.out.println(num1 + " non è multiplo di " + num2);
            }
        } catch (NumberFormatException e) {
            System.err.println("Errore: entrambi gli argomenti devono essere numeri interi.");
            System.exit(1);
        }
    }
}