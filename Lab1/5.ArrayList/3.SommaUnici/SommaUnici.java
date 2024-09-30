import java.util.ArrayList;
import java.util.Scanner;

public class SommaUnici {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Integer> numeri = new ArrayList<>();

            // Leggiamo i valori fino all'indicatore EOF
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    numeri.add(scanner.nextInt());
                } else {
                    scanner.next(); // Ignoriamo gli input non interi
                }
            }
            
            // Calcoliamo la somma dei numeri unici
            int somma = 0;
            for (int numero : numeri) {
                if (occorrenze(numeri, numero) == 1) {
                    somma += numero;
                }
            }
            
            System.out.println(somma);
        }
    }

    public static int occorrenze(ArrayList<Integer> numeri, int n) {
        int count = 0;
        for (int numero : numeri) {
            if (numero == n) {
                count++;
            }
        }
        return count;
    }
}