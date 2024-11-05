
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Inserisci il raggio di una sfera: ");
        Scanner scanner = new Scanner(System.in);
        double r = scanner.nextDouble();
        Sfera sfera = new Sfera(r);

        System.out.println("Inserisci il raggio e altezza di un cono: ");
        r = scanner.nextDouble();
        double a = scanner.nextDouble();
        Cono cono = new Cono(r, a);

        if (sfera.compareTo(cono) == -1)
            System.out.println("La sfera ha un volume minore di cono");
        else if (sfera.compareTo(cono) == 0)
            System.out.println("La sfera ha lo stesso volume di cono");
        else
            System.out.println("La sfera ha un volume maggiore di cono");
    }
}