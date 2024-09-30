import java.util.Scanner;

/**
 * La classe Farfallino legge un testo da standard input e lo trasforma
 * nel linguaggio farfallino.
 * 
 * REQUIRES: Un testo su più righe da standard input, terminato con EOF.
 * MODIFIES: System.out
 * EFFECTS: Stampa il testo trasformato in linguaggio farfallino.
 */
public class Farfallino {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder testo = new StringBuilder();
        
        System.out.println("Inserisci un testo su più righe (termina con CTRL+D):");
        
        // Leggi l'input fino all'EOF
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            testo.append(linea).append("\n");
        }

        // Chiudi lo scanner
        scanner.close();
        
        // Trasforma il testo in farfallino
        String testoFarfallino = farfallino(testo.toString());
        
        // Stampa il risultato
        System.out.println("Risultato:");
        System.out.print(testoFarfallino);
    }

    /**
     * Verifica se il carattere è una vocale.
     * 
     * @param c Il carattere da controllare.
     * @return true se c è una vocale, false altrimenti.
     */
    public static boolean isVocale(char c) {
        return "aeiouAEIOU".indexOf(c) != -1; // Restituisce true se c è una vocale
    }

    /**
     * Trasforma la stringa s in linguaggio farfallino.
     * 
     * @param s La stringa da trasformare.
     * @return La stringa trasformata in farfallino.
     */
    public static String farfallino(String s) {
        StringBuilder risultato = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (isVocale(c)) {
                // Aggiunge la sequenza farfallino per la vocale
                risultato.append(c).append('f').append(c);
            } else {
                risultato.append(c); // Mantiene il carattere non vocale
            }
        }
        
        return risultato.toString(); // Restituisce il testo trasformato
    }
}