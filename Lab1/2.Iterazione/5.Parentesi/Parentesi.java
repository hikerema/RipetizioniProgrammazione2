/**
 * La classe Parentesi legge da riga di comando una stringa composta da parentesi quadre
 * e verifica se sono bilanciate.
 * 
 * REQUIRES: Una stringa di parentesi quadre passata da riga di comando.
 * MODIFIES: System.out
 * EFFECTS: Stampa 'Bilanciate' se le parentesi sono bilanciate, 'Non bilanciate' altrimenti.
 */
public class Parentesi {
    public static void main(String[] args) {
        // Controllo che sia passato esattamente un argomento
        if (args.length != 1) {
            System.err.println("Errore: è necessario passare una stringa di parentesi.");
            System.exit(1);
        }

        String parentesi = args[0];

        // Verifica se le parentesi sono bilanciate
        if (areBilanciate(parentesi)) {
            System.out.println("Bilanciate");
        } else {
            System.out.println("Non bilanciate");
        }
    }

    /**
     * Verifica se le parentesi quadre nella stringa sono bilanciate.
     * 
     * @param str La stringa da verificare.
     * @return true se le parentesi sono bilanciate, false altrimenti.
     */
    private static boolean areBilanciate(String str) {
        int count = 0; // Contatore per le parentesi aperte

        for (char c : str.toCharArray()) {
            if (c == '[') {
                count++; // Incrementa per ogni parentesi aperta
            } else if (c == ']') {
                count--; // Decrementa per ogni parentesi chiusa
            }

            // Se il contatore è negativo, ci sono più parentesi chiuse
            if (count < 0) {
                return false;
            }
        }

        // Se il contatore è zero, le parentesi sono bilanciate
        return count == 0;
    }
}