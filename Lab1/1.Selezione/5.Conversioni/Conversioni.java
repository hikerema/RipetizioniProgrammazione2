/**
 * La classe Conversioni legge da riga di comando una quantità di tempo e la converte
 * dall'unità di misura specificata all'unità di misura di destinazione.
 * 
 * REQUIRES: Una quantità di tempo, l'unità di misura iniziale e quella finale.
 * MODIFIES: System.out
 * EFFECTS: Stampa il risultato della conversione temporale, se l'unità di misura è valida.
 *          Altrimenti, stampa un messaggio di errore.
 */
public class Conversioni {
    public static void main(String[] args) {
        // Controllo che siano passati esattamente quattro argomenti
        if (args.length != 4) {
            System.err.println("Errore: utilizzare la sintassi: <valore> <unità di partenza> in <unità di arrivo>");
            System.exit(1);
        }

        try {
            double valore = Double.parseDouble(args[0]);
            String unitaIniziale = args[1];
            String unitaFinale = args[3];  // args[2] è "in", quindi lo saltiamo

            // Conversioni in secondi
            double valoreInSecondi = convertiInSecondi(valore, unitaIniziale);

            if (valoreInSecondi == -1) {
                System.err.println("Errore: unità di misura di partenza non valida.");
                System.exit(1);
            }

            // Conversioni dall'unità in secondi a quella richiesta
            double risultato = convertiDaSecondi(valoreInSecondi, unitaFinale);

            if (risultato == -1) {
                System.err.println("Errore: unità di misura di arrivo non valida.");
                System.exit(1);
            }

            System.out.println(valore + " " + unitaIniziale + " corrispondono a " + risultato + " " + unitaFinale);
        } catch (NumberFormatException e) {
            System.err.println("Errore: il valore deve essere un numero.");
            System.exit(1);
        }
    }

    // Metodo per convertire una quantità temporale nell'equivalente in secondi
    private static double convertiInSecondi(double valore, String unita) {
        switch (unita.toLowerCase()) {
            case "secondi":
                return valore;
            case "minuti":
                return valore * 60;
            case "ore":
                return valore * 3600;
            case "giorni":
                return valore * 86400;
            case "mesi":
                return valore * 2592000;  // 30 giorni
            case "anni":
                return valore * 31536000;  // 365 giorni
            default:
                return -1;  // Unità non valida
        }
    }

    // Metodo per convertire una quantità di secondi nell'unità finale
    private static double convertiDaSecondi(double valoreInSecondi, String unita) {
        switch (unita.toLowerCase()) {
            case "secondi":
                return valoreInSecondi;
            case "minuti":
                return valoreInSecondi / 60;
            case "ore":
                return valoreInSecondi / 3600;
            case "giorni":
                return valoreInSecondi / 86400;
            case "mesi":
                return valoreInSecondi / 2592000;  // 30 giorni
            case "anni":
                return valoreInSecondi / 31536000;  // 365 giorni
            default:
                return -1;  // Unità non valida
        }
    }
}