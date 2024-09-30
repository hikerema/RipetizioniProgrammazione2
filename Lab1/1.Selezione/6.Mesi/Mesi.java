/**
 * La classe Mesi legge da riga di comando il nome di un mese e stampa il numero di giorni
 * corrispondenti, assumendo che l'anno non sia bisestile.
 * 
 * REQUIRES: Il nome di un mese in minuscolo.
 * MODIFIES: System.out
 * EFFECTS: Stampa il numero di giorni del mese, se il nome è valido.
 *          Altrimenti, stampa un messaggio di errore.
 */
public class Mesi {
    public static void main(String[] args) {
        // Controllo che sia passato esattamente un argomento
        if (args.length != 1) {
            System.err.println("Errore: è necessario passare il nome di un mese.");
            System.exit(1);
        }

        String mese = args[0].toLowerCase();
        int giorni = getGiorniDelMese(mese);

        if (giorni == -1) {
            System.out.println("Il nome del mese non è corretto.");
        } else {
            System.out.println("Il numero di giorni di " + mese + " è " + giorni);
        }
    }

    /**
     * Restituisce il numero di giorni del mese specificato.
     * 
     * @param mese Il nome del mese.
     * @return Il numero di giorni del mese, o -1 se il nome non è valido.
     */
    private static int getGiorniDelMese(String mese) {
        switch (mese) {
            case "gennaio":
            case "marzo":
            case "maggio":
            case "luglio":
            case "agosto":
            case "ottobre":
            case "dicembre":
                return 31;
            case "aprile":
            case "giugno":
            case "settembre":
            case "novembre":
                return 30;
            case "febbraio":
                return 28;  // Non bisestile
            default:
                return -1;  // Mese non valido
        }
    }
}