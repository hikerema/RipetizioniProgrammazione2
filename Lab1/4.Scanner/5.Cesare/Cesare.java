import java.util.Scanner;

public class Cesare {
    public static void main(String[] args) {
        int chiave = Integer.parseInt(args[0]);
        String testo = leggiTesto();
        String testoCifrato = cifraTesto(testo, chiave);
        System.out.println("Testo cifrato:");
        System.out.print(testoCifrato);
    }

    public static String leggiTesto() {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        return sb.toString();
    }

    public static char cifraCarattere(char c, int chiave) {
        if (Character.isLetter(c)) {
            char base = Character.isLowerCase(c) ? 'a' : 'A';
            return (char) ((c - base + chiave + 26) % 26 + base);
        }
        return c;
    }

    public static String cifraTesto(String s, int chiave) {
        StringBuilder risultato = new StringBuilder();
        for (char c : s.toCharArray()) {
            risultato.append(cifraCarattere(c, chiave));
        }
        return risultato.toString();
    }
}