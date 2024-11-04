/**
 * Parentesi
 */
public class Parentesi {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Errore");
            System.exit(1);
        }
        String s = args[0];
        if (isBilanciato(s))
            System.out.println("Bilanciato");
        else
            System.out.println("Non bilanciato");
    }
    private static boolean isBilanciato(String s) {
        int l = s.length();
        int count = 0;
        for (int i = 0; i < l; i++) {
            if (s.charAt(0) != '[')
                return false;
            else if (s.charAt(i) == '[')
                count++;
            else if (s.charAt(i) == ']')
                count--;
        }
        if (count == 0 && s.charAt(l-1) == ']')
            return true;
        else
            return false;
    }
}