/**
 * Cerchio
 */
public class Cerchio {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Errore");
            System.exit(1);
        }
        double raggio = Double.parseDouble(args[0]);
        double area = CalcolaArea(raggio);
        double circonferenza = CalcolaCirconferenza(raggio);
        System.out.println("Area cerchio:" + area);
        System.out.println("Circonferenza cerchio:" + circonferenza);
    }
    public static double CalcolaArea(double raggio) {
        return Math.PI * raggio * raggio;
    }
    public static double CalcolaCirconferenza(double raggio) {
        return 2 * Math.PI * raggio;
    }
}