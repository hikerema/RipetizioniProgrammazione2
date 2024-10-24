/**
 * Mesi
 */
public class Mesi {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Errore");
            System.exit(1);
        }
        
        String mese = args[0];

        switch (mese) {
            case "febbraio":
                System.out.println("28");
                break;
            case "gennaio":
            case "marzo":
            case "maggio":
            case "luglio":
            case "agosto":
            case "dicembre":
                System.out.println("31");
                break;
            case "aprile":
            case "giugno":
            case "settembre":
            case "novembre":
                System.out.println("30");
                break;
            default:
                System.err.println("Errore");
                break;
        }
    }
}