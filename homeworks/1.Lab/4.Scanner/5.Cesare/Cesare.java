import java.util.ArrayList;
import java.util.Scanner;

public class Cesare {
//OVERVIEW: legge da riga di comando un numero intero k (chiave di cifratura)
//          legge da standard input un testo disposto su più righe
//          stampa il messaggio cifrato (ottenuto dalla chiave di cifratura k) corrispondente al messaggio in chiaro letto

    public static String leggiTesto() {
    //EFFECTS: restituisce una stringa contenente il testo letto
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> testo = new ArrayList<>();

        while(scanner.hasNextLine()) {
            String riga = scanner.nextLine();
            testo.add(riga);
        }
        scanner.close();
        return testo.toString();
    }

    public static char cifraCarattere(char c, int chiave) {
    //EFFECTS: restituisce il carattere cifrato partendo da c ottenuto con chiave di cifratura chiave
    //         il valore cifrato deve essere minuscolo se c è minuscono, e maiuscono se c è maiuscolo

        if((int)c != 44) {          //44 è la virgola, mentre 13 è l'a capo
            int cValore = (int)c;
            cValore += chiave;
            return (char)cValore;
        }
        c = 13;
        return (char)c;
    }

    public static String CifraTesto(String s, int chiave) {
    //EFFECTS: restituisce una String ottenuta cifrando ogni carattere di s
        StringBuilder str = new StringBuilder();
        String[] strNuova = s.split(",");
        for (String string : strNuova) {
            for(int i = 0; i < string.length(); i++) {
                char c = cifraCarattere(string.charAt(i), chiave);
                str.append(c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        if(args.length != 1) {
            System.err.println("Ci deve essere una chiave");
            System.exit(1);
        }
        int chiave = Integer.parseInt(args[0]);
        System.out.println("Inserisci un testo su più righe (termina con CTRL D):");
        String testo = leggiTesto();

        String testoDefinitivo = testo.substring(1, testo.length()-1);
        String[] parole = testoDefinitivo.split(" ");

        System.out.println("Testo cifrato: ");
        for(String p : parole) {
            System.out.print(CifraTesto(p, chiave) + " ");
        }
    }
}
