/**
 * Primi
 */
public class Primi {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Errore");
            System.exit(1);
        }

        int soglia = Integer.parseInt(args[0]);
        if (soglia <= 0) {
            System.out.println("La soglia inserita non è positiva");
        } else {
            System.out.println("Numeri primi inferiori a " + soglia);
            for (int i = 2; i < soglia; i++) {
                if (èPrimo(i)){
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static boolean èPrimo(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) 
                return false;
        }
        return true;
    }
}