import java.util.Scanner;

public class MinMaxAvg {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Si prega di fornire un numero intero.");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int[] numeri = new int[n];
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Inserisci i " + n + " numeri:");
            for (int i = 0; i < n; i++) {
                numeri[i] = scanner.nextInt();
            }
        }

        System.out.println("Minimo: " + minimo(numeri));
        System.out.println("Massimo: " + massimo(numeri));
        System.out.printf("Valore medio: %.1f%n", media(numeri));
    }

    public static int minimo(int[] in) {
        int min = in[0];
        for (int i : in) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    public static int massimo(int[] in) {
        int max = in[0];
        for (int i : in) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static float media(int[] in) {
        int somma = 0;
        for (int i : in) {
            somma += i;
        }
        return (float) somma / in.length;
    }
}