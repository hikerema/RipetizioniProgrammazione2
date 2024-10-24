public class Angoli {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Errore");
            System.exit(1);
        }

        int angolo1 = Integer.parseInt(args[0]);
        int angolo2 = Integer.parseInt(args[1]);

        int somma = angolo1 + angolo2;
        if (somma > 180) {
            System.out.println("I due angoli non appartengono ad un triangolo");
        } else {
            System.out.println("Ampiezza terzo angolo = " + Ampiezza(somma) + "°");
        }
    }

    public static int Ampiezza(int somma) {
        return 180 - somma;
    }
}