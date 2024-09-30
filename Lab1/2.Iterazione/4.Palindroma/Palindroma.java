/**
 * La classe Palindroma legge da riga di comando una stringa e verifica se è palindroma.
 * 
 * REQUIRES: Una stringa senza spazi passata da riga di comando.
 * MODIFIES: System.out
 * EFFECTS: Stampa 'Palindroma' se la stringa è palindroma, 'Non palindroma' altrimenti.
 */
public class Palindroma {
    public static void main(String[] args) {
        // Controllo che sia passato esattamente un argomento
        if (args.length != 1) {
            System.err.println("Errore: è necessario passare una stringa.");
            System.exit(1);
        }

        String parola = args[0];

        // Verifica se la stringa è palindroma
        if (isPalindroma(parola)) {
            System.out.println("Palindroma");
        } else {
            System.out.println("Non palindroma");
        }
    }

    /**
     * Verifica se la stringa fornita è palindroma.
     * 
     * @param str La stringa da verificare.
     * @return true se la stringa è palindroma, false altrimenti.
     */
    private static boolean isPalindroma(String str) {
        int lunghezza = str.length();
        for (int i = 0; i < lunghezza / 2; i++) {
            if (str.charAt(i) != str.charAt(lunghezza - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}