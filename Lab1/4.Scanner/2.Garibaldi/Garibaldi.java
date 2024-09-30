import java.util.Scanner;

/**
 * La classe Garibaldi legge un testo da standard input e ristampa il testo
 * sostituendo tutte le vocali con delle 'u'.
 * 
 * REQUIRES: Un testo su più righe da standard input, terminato con EOF.
 * MODIFIES: System.out
 * EFFECTS: Stampa il testo trasformato.
 */
public class Garibaldi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder testo = new StringBuilder();
        
        System.out.println("Inserisci un testo su più righe (termina con riga vuota):");
        
        // Leggi l'input fino all'EOF
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            // Termina la lettura se la riga è vuota
            if (linea.isEmpty()) {
                break;
            }
            testo.append(linea).append("\n");
        }

        // Chiudi lo scanner
        scanner.close();
        
        // Trasforma il testo
        String testoTrasformato = sostituisciVocali(testo.toString());
        
        // Stampa il risultato
        System.out.println("Risultato trasformazione:");
        System.out.print(testoTrasformato);
    }

    /**
     * Sostituisce tutte le vocali nel testo con 'u'.
     * 
     * @param testo Il testo da trasformare.
     * @return Il testo con le vocali sostituite.
     */
    private static String sostituisciVocali(String testo) {
        // Usa una StringBuilder per costruire il nuovo testo
        StringBuilder risultato = new StringBuilder();
        
        for (char c : testo.toCharArray()) {
            // Sostituisce le vocali con 'u'
            if ("aeiouAEIOU".indexOf(c) != -1) {
                risultato.append('u');
            } else {
                risultato.append(c);
            }
        }
        
        return risultato.toString(); // Restituisce il testo trasformato
    }
}