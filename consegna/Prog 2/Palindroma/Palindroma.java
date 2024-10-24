/**
 * Palindroma
 */
public class Palindroma {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Errore");
            System.exit(1);
        }
        String s = args[0];
        if (isPalindroma(s))
            System.out.println("e' Palindroma");
        else
            System.out.println("non e' Palindroma");
    }
    private static boolean isPalindroma(String s) {
        int l = s.length();
        for (int i = 0; i < l/2; i++) {
            if (s.charAt(i) != s.charAt(l-1-i))
                return false;
        }
        return true;
    }
}