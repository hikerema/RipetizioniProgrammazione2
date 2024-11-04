/**
 * Sottostringa
 */
public class Sottostringa {
//OVERVIEW: sottostringa
    public static boolean sottoStringa(String testo, String parola) {
    //EFFECTS: controlla se testo è sottostringa di parola
        return testo.contains(parola);
    }
    public static void main(String[] args) {
        String s1 = args[0];
        String s2 = args[1];

        if (sottoStringa(s1, s2))
            System.out.println(s2 + " è sottostringa di " + s1);
        else
            System.out.println(s2 + " non è sottostringa di " + s1);
    }
}