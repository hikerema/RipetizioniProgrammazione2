import java.util.ArrayList;
import java.util.Scanner;

public class MinMaxAvg {
    public static void main(String[] args) {
        ArrayList<Integer> numeri = leggiNumeri();
        
        if (numeri.isEmpty()) {
            System.out.println("Nessun numero inserito.");
            return;
        }
        
        System.out.println("Minimo: " + minimo(numeri));
        System.out.println("Massimo: " + massimo(numeri));
        System.out.printf("Valore medio: %.1f%n", media(numeri));
    }

    public static ArrayList<Integer> leggiNumeri() {
        ArrayList<Integer> numeri = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Inserisci i numeri (Ctrl+D per terminare):");

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    numeri.add(scanner.nextInt());
                } else {
                    scanner.next(); // Ignora input non valido
                }
            }
        }
        return numeri;
    }

    public static int minimo(ArrayList<Integer> in) {
        int min = in.get(0);
        for (int num : in) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int massimo(ArrayList<Integer> in) {
        int max = in.get(0);
        for (int num : in) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static float media(ArrayList<Integer> in) {
        int somma = 0;
        for (int num : in) {
            somma += num;
        }
        return (float) somma / in.size();
    }
}