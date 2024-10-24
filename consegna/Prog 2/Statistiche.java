import java.util.Scanner;

/**
 * Statistiche
 */
public class Statistiche {

    public static void main(String[] args) {    
        /*
            scanner da standard input
        */   
        Scanner scanner = new Scanner(System.in);
        StringBuilder testo = new StringBuilder();
        System.out.println("Inserisci il testo su piu' righe:");
        while (scanner.hasNextLine()) {
            testo.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        int line = ContaLinee(testo.toString());
        int parole = ContaParole(testo.toString());
        double media = Media(testo.toString());
        System.out.println("num linee:" + line);
        System.out.println("num parole:" + parole);
        System.out.println("media:" + media);
    }
    public static int ContaLinee(String testo) {
        String[] p = testo.trim().split("\n");
        return p.length;
    }

    public static int ContaParole(String testo) {
        String[] p = testo.trim().split("\\s+");
        return p.length;
    }
    public static double Media(String testo) {
        String[] p = testo.trim().split("\\s+");
        int count = 0;
        for (String s : p) {
            count += s.length();
        }
        double media = (count/p.length);
        return media;
    }
}