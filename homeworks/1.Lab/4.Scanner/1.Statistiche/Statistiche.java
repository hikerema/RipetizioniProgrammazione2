import java.util.ArrayList;
import java.util.Scanner;

public class Statistiche {
//OVERVIEW: legge da standard input un testo su più righe, termina la lettura con Ctrl + D
//          stampa il numero di linee, il numero di parole presenti nel testo
//          e la lunghezza media delle parole presenti nel testo

    public static int ContaParole(String testo) {
    //EFFECTS: restituisce il numero di parole presenti in una linea
        int parole = 0;
        String[] riga = testo.split(" ");
        for (String p : riga) {
            parole++;
        }
        return parole;
    }

    public static Double LunghezzaMedia(ArrayList<String> linea) {
    //EFFECTS: restituisce la lunghezza media delle parole presenti nel testo
        
        
        ArrayList<Integer> lenParole = new ArrayList<>();
        for(String riga : linea) {
            String[] parole = riga.split(" ");
            for(String p : parole) {
                lenParole.add(p.length());
            }
        }

        int somma = 0;
        for (Integer l : lenParole) {
            somma += l;
        }
        return (double)somma/(double)(lenParole.size());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> parole = new ArrayList<>();
        
        System.out.println("Inserisci testo su più righe");

        int countRighe = 0;
        int countParole = 0;
        double mediaParole;

        while(scanner.hasNextLine()) {
            countRighe++;
            String testo = scanner.nextLine();
            //nextLine -> restuisce una stringa che rappresenta la riga, con lo split tolgo gli spazi e diventa un array di stringhe
            countParole += ContaParole(testo);
            parole.add(testo);
        }
        scanner.close();
        mediaParole = LunghezzaMedia(parole);

        System.out.println("Numero linee: " + countRighe);
        System.out.println("Numero parole: " + countParole);
        System.out.println("Lunghezza media: " + mediaParole);
    
    }
}