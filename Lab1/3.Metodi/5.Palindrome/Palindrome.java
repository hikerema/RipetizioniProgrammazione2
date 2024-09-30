import java.util.HashSet;
import java.util.Set;

/**
 * La classe Palindrome legge da riga di comando una stringa e stampa
 * tutte le sottostringhe palindrome della stringa.
 * 
 * REQUIRES: Una stringa senza spazi passata da riga di comando.
 * MODIFIES: System.out
 * EFFECTS: Stampa tutte le sottostringhe palindrome della stringa fornita.
 */
public class Palindrome {
    public static void main(String[] args) {
        // Controllo che sia stata passata una stringa come argomento
        if (args.length != 1) {
            System.err.println("Errore: è necessario passare una stringa senza spazi.");
            System.exit(1);
        }

        String input = args[0];
        Set<String> palindromi = new HashSet<>();

        // Trova tutte le sottostringhe e controlla se sono palindrome
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                String substr = input.substring(i, j);
                if (isPalindroma(substr)) {
                    palindromi.add(substr); // Aggiungi solo se è palindroma
                }
            }
        }

        // Stampa i risultati
        System.out.println(palindromi);
    }

    /**
     * Verifica se una stringa è palindroma.
     * 
     * @param s La stringa da verificare.
     * @return true se s è palindroma, false altrimenti.
     */
    private static boolean isPalindroma(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; // Non è palindroma
            }
            left++;
            right--;
        }
        return true; // È palindroma
    }
}