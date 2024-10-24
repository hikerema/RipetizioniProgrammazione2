/**
 * Terne
 */
public class Terne {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Errore");
            System.exit(1);
        }

        int soglia = Integer.parseInt(args[0]);
        System.out.println("Terne pitagoriche: ");
        for (int i = 1; i < soglia; i++) {
            for (int j = i; j < soglia; j++) {
                for (int l = j; l < soglia; l++) {
                    if (ternaPitagorica(i, j, l)) {
                        System.out.println("(" + i + ", " + j + ", " + l + ")");
                    }
                }
            }
        }
    }

    public static boolean ternaPitagorica(int a, int b, int c) {
        if ((c*c) == (a*a) + (b*b)) 
            return true;
        return false;
    }
}