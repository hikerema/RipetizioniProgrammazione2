/**
 * Segno
 */
public class Segno {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Errore");
            System.exit(1);
        }
        int n = Integer.parseInt(args[0]);
        
        if (n > 0)
            System.out.println("+" + n);
        else
            System.out.println(n);
        

    }
}