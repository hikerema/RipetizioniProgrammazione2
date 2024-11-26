

public class Palindrome {
//OVERVIEW: legge da riga di comando una stringa senza spazi
//          stampa tutte le sottostringhe palindrome della stringa

    private static boolean isPalidroma(String s) {
    //EFFECTS: restituisce true se s è palindroma, altrimenti false
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        if(args.length != 1) {
            System.err.println("Inserisci una sola stringa senza spazi");
            System.exit(1);
        }

        String s = args[0];

        System.out.print("[ ");
        for(int i = 0; i < s.length(); i++) {
            for(int j = i+1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if(str.length() >= 2) {
                    if(isPalidroma(str)) {
                        System.out.print(str + " ");
                    }
                }
            }
        }
        System.out.print("]");

    }
}
