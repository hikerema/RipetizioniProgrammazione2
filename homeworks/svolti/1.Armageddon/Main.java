
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
//OVERVIEW: la classe legge da riga di comando un valore soglia
//          Le forze gravitazionali superiori alla soglia indicano asteroidi pericolosi per la terra
//          Leggere da standard input, fino a quando non viene premuto CTRL+D,
//          una serie di coppie di valori <massa> <distanza> che rappresenteranno gli asteroidi osservati
//          Al termine della lettura segnalare gli asteroidi pericolosi.
    public static void main(String[] args) {
        double soglia = Double.parseDouble(args[0]);
        Scanner scanner = new Scanner(System.in);
        ArrayList<Asteroide> asteroidi = new ArrayList<Asteroide>();

        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split(" ");
            double massa = Double.parseDouble(line[0]);
            double distanza = Double.parseDouble(line[1]);
            try {
                Asteroide asteroide = new Asteroide(massa, distanza);
                asteroidi.add(asteroide);
            } catch (IllegalAsteroideException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
        for (Asteroide a : asteroidi) {
            if (a.forzaGravitazionale() > soglia)
                System.out.println("Asteroide pericoloso a distanza " + a.getDistanza() + " km del peso di " + a.getMassa() + " kg");
        }
    }
}