import java.util.Scanner;

/**
 * La classe Statistiche legge un testo da standard input e calcola
 * il numero di linee, il numero di parole e la lunghezza media delle parole.
 * 
 * REQUIRES: Un testo su più righe da standard input, terminato con EOF.
 * MODIFIES: System.out
 * EFFECTS: Stampa le statistiche del testo letto.
 */
public class Statistiche {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder testo = new StringBuilder();
        
        System.out.println("Inserisci un testo su più righe (termina con Ctrl+D):");
        
        // Leggi l'input fino all'EOF
        while (scanner.hasNextLine()) {
            testo.append(scanner.nextLine()).append("\n");
        }

        // Chiudi lo scanner
        scanner.close();
        
        // Estrai il testo come stringa
        String input = testo.toString();
        
        // Calcola le statistiche
        int numeroLinee = contaLinee(input);
        int numeroParole = contaParole(input);
        double lunghezzaMedia = calcolaLunghezzaMedia(input, numeroParole);
        
        // Stampa le statistiche
        System.out.println("Statistiche:");
        System.out.println("Numero linee: " + numeroLinee);
        System.out.println("Numero parole: " + numeroParole);
        System.out.printf("Lunghezza media: %.3f\n", lunghezzaMedia);
    }

    /**
     * Conta il numero di linee nel testo.
     * 
     * @param testo Il testo da analizzare.
     * @return Il numero di linee nel testo.
     */
    private static int contaLinee(String testo) {
        // Dividi il testo in linee e restituisci la lunghezza dell'array
        return testo.split("\n").length;
    }

    /**
     * Conta il numero di parole nel testo.
     * 
     * @param testo Il testo da analizzare.
     * @return Il numero di parole nel testo.
     */
    private static int contaParole(String testo) {
        // Rimuovi gli spazi all'inizio e alla fine e dividi in parole
        String[] parole = testo.trim().split("\\s+");
        return parole.length == 1 && parole[0].isEmpty() ? 0 : parole.length;
    }

    /**
     * Calcola la lunghezza media delle parole nel testo.
     * 
     * @param testo Il testo da analizzare.
     * @param numeroParole Il numero di parole nel testo.
     * @return La lunghezza media delle parole.
     */
    private static double calcolaLunghezzaMedia(String testo, int numeroParole) {
        if (numeroParole == 0) return 0.0;

        String[] parole = testo.trim().split("\\s+");
        int sommaLunghezze = 0;

        for (String parola : parole) {
            sommaLunghezze += parola.length();
        }

        return (double) sommaLunghezze / numeroParole; // Calcola e restituisci la lunghezza media
    }
}