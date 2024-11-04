/**
 * Conversioni
 */
public class Conversioni {

    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        String da = args[1];
        String a = args[3];

        double convertito = num;

        switch (da) {
            case "secondi":
                convertito /= 60;
                break;
            case "minuti":
                convertito /= 60;
                break;
            case "ore":
                convertito /= 60;
                break;
            case "giorni":
                convertito /= 24;
                break;
            case "mesi":
                convertito /= 30;
                break;
            case "anni":
                convertito /= 12;
                break;
            default:
                break;
        }

        switch (a) {
            case "secondi":
                convertito /= 60;
                break;
            case "minuti":
                convertito /= 60;
                break;
            case "ore":
                convertito /= 60;
                break;
            case "giorni":
                convertito /= 24;
                break;
            case "mesi":
                convertito /= 30;
                break;
            case "anni":
                convertito /= 12;
                break;
            default:
                break;
        }

        System.out.println(num + " " + da + " corrispondono a " + convertito + " " + a);
    }
}