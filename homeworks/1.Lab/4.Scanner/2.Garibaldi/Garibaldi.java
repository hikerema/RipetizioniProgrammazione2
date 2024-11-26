
import java.util.ArrayList;
import java.util.Scanner;

public class Garibaldi {
//OVERVIEW: legge da standard input un testo su più righe terminando la lettura con Ctrl+Z
//          ogni vocale viene sostituita con u

    public static String SostituisciVocali(String parola) {
    //EFFECTS: restitusce la parola con tutte le vocali sostituite con la vocale u
        
        for(int i = 0; i < parola.length(); i++) {
            if(parola.charAt(i) == 'a' || parola.charAt(i) =='e' || parola.charAt(i) == 'i' || parola.charAt(i) =='o') {
                parola = parola.replace((char)parola.charAt(i), 'u');
            }
        }
        return parola;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> testo = new ArrayList<>();

        System.out.println("Inserisci un testo su più righe (termina con riga vuota):");
        while(scanner.hasNextLine()) {
            String riga = (scanner.nextLine());
            testo.add(riga);
        }

        String testoModificato;
        System.out.println("Risultato trasformazione: ");
        for(String t : testo) {
            testoModificato = SostituisciVocali(t);
            System.out.println(testoModificato);
        }
        
    }
}
