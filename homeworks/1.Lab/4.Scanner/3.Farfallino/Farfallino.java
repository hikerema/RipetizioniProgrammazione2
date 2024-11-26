
import java.util.ArrayList;
import java.util.Scanner;

public class Farfallino {
//OVERVIEW: legge un testo su più righe
//          ogni vocale è sostituita con la seguenza vocale-f-vocale
//          per esempio, a viene sostituita con afa, e con efe, e cosi via

    public static boolean isVocale(char c) {
    //EFFECTS: restituisce true se c è una vocale, altrimenti false
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' )
            return true;
        return false;
    }

    public static String farfallino(String s) {
    //EFFECTS: restituisce la stringa s trasformata in farfallino
        StringBuilder nuovaParola = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(isVocale(c)) {
                nuovaParola.append(c).append('f').append(c);
            } else {
                nuovaParola.append(c);
            }
        }
        return nuovaParola.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> testo = new ArrayList<>();

        System.out.println("Inserisci un testo su più righe (termina con CTRL+D):");
        while(scanner.hasNextLine()) {
            String riga = scanner.nextLine();
            testo.add(riga);
        }
        scanner.close();

        System.out.println("Risultato:");
        for (String t : testo) {
            System.out.println(farfallino(t));
        }
    }
}
