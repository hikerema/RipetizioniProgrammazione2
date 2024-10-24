/**
 * Radice
 */

public class Radice {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Errore");
            System.exit(1);
        }

        double n = Double.parseDouble(args[0]);
        if (n <= 0) {
            System.out.println("Il valore inserito non appartiene al dominio della funzione");
        } else {
            n = radiceQuadrata(n);
            //tronco n alla parte intera -> i
            int i = (int)n;
            if (n % i == 0)
                System.out.printf("Radice quadrata: %.0f%n", n);
            else
                System.out.printf("Radice quadrata: %.2f%n", n);
        }
    }

    public static double radiceQuadrata(double numero) {
        return java.lang.Math.sqrt(numero);
    }
}