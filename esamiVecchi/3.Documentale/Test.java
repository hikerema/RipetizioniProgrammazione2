import java.util.NoSuchElementException;
import java.util.Scanner;

public class Test {
//OVERVIEW: testa la classe Cartella

    public static void main(String[] args) {
        Cartella current = new Cartella(null, 0, null, null);
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()) {
            String[] comando = scanner.next().split(" ");
            switch (comando[0]) {
                case "crea":
                    try {
                        if(comando[1].equals("cartella")) 
                            System.out.println(new Cartella(comando[2],0, current, null));
                        if(comando[1].equals("documento"))
                            System.out.println(new Documento(comando[2], Integer.parseInt(comando[3])));
                    } catch (NoSuchElementException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "rimuovi":
                    try {
                        System.out.println();
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                default:
                    throw new AssertionError();
            }
        }

    }
}
