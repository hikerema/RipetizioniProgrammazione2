import java.util.ArrayList;
import java.util.Scanner;

public class Voti {
    public static void main(String[] args) {
        System.out.println("Inserisci i voti:");
        ArrayList<Integer> voti = leggiNumeri();

        ArrayList<Integer> votiSufficienti = filtraVotiSufficienti(voti);
        ArrayList<Integer> votiInsufficienti = filtraVotiInsufficienti(voti);

        System.out.println("Voti sufficienti: " + votiSufficienti);
        System.out.println("Voti insufficienti: " + votiInsufficienti);
    }

    public static ArrayList<Integer> leggiNumeri() {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Integer> numeri = new ArrayList<>();

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int numero = scanner.nextInt();
                    if (numero >= 0 && numero <= 100) {
                        numeri.add(numero);
                    }
                } else {
                    scanner.next(); // Ignoriamo gli input non interi
                }
            }
            
            return numeri;
        }
    }

    public static ArrayList<Integer> filtraVotiSufficienti(ArrayList<Integer> l) {
        ArrayList<Integer> sufficienti = new ArrayList<>();
        for (int voto : l) {
            if (voto > 60) {
                sufficienti.add(voto);
            }
        }
        return sufficienti;
    }

    public static ArrayList<Integer> filtraVotiInsufficienti(ArrayList<Integer> l) {
        ArrayList<Integer> insufficienti = new ArrayList<>();
        for (int voto : l) {
            if (voto <= 60) {
                insufficienti.add(voto);
            }
        }
        return insufficienti;
    }
}