/**
 * Tabellina
 */
public class Tabellina {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Errore");
            System.exit(1);
        }
        int num = Integer.parseInt(args[0]);
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " x " + num + " = " + (num * i));
        }
    }
}