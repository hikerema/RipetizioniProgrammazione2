import java.util.Scanner;

/**
 * Garibaldi
 */
public class Garibaldi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder testo = new StringBuilder();
        System.out.println("Inserisci il testo su piu' righe:");
        while (scanner.hasNextLine()) {
            testo.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        System.out.println(Vocali(testo.toString()));
  
    }
    public static String Vocali(String testo) {
        String[] p = testo.trim().split("\\s+");
        StringBuilder paroleComplete = new StringBuilder();
        for (String s : p) {
            //converto la parola s in un array di char
            s = s.toLowerCase();
            int i = 0;
            char[] lettere = s.toCharArray();
            for (char l : lettere) {
                if (l == 'a' || l == 'e' || l == 'i' || l == 'o')
                    lettere[i] = 'u';
                    i++;
            }
            s = lettere.toString();
            paroleComplete.append(s);
        }
        return paroleComplete.toString();
    }
}