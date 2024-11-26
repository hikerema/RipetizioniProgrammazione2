
import java.util.ArrayList;
import java.util.Scanner;

public class Inverso {
//OVERVIEW: legge da standard input un testo fornato da un numero variabile di righe
//          termina la lettura con Ctrl+z
//          stampa il testo la ultimo al primo carattere

    public static String inverso(String s) {
    //EFFECTS: restituisce l'inverso della stringa
        StringBuilder parolaInvertita = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--) {
            parolaInvertita.append(s.charAt(i));
        }
        return parolaInvertita.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> testo = new ArrayList<>();


        System.out.println("Inserisci un testo su più righe (termina con riga vuota):");
        while(scanner.hasNextLine()) {
            String riga = scanner.nextLine();
            testo.add(riga);
        }
        scanner.close();
        
        System.out.println("Testo invertito:");
        for (int i = testo.size()-1; i >= 0; i--) {
            System.out.println(inverso(testo.get(i)));
        }    
    }
}
