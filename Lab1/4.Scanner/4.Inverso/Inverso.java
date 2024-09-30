import java.util.Scanner;

public class Inverso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder testo = new StringBuilder();

        System.out.println("Inserisci un testo su più righe (termina con CTRL+D):");

        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            testo.append(linea).append("\n");
        }

        scanner.close();
        String testoInvertito = inverso(testo.toString());
        System.out.println("Testo invertito:");
        System.out.print(testoInvertito);
    }

    public static String inverso(String s) {
        StringBuilder risultato = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            risultato.append(s.charAt(i));
        }
        return risultato.toString();
    }
}