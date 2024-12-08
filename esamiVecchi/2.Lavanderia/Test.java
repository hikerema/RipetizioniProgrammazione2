
import java.util.Scanner;

public class Test {
//OVERVIEW: testa Lavanderia

    public static void main(String[] args) {
        Lavanderia lav = new Lavanderia();
        Scanner scanner = new Scanner(System.in);
        int id = 0;

        System.out.println("Inserisci i comandi (Ctrl+D termina)");
        System.out.println("installa <lavatrice/asciugatrice> <costo> ");
        System.out.println("lava/asciuga/rimuovi/apri <id> ");
        System.out.println("aggiungi <credito>");
        System.out.println("status");

        while(scanner.hasNextLine()) {
            String[] comando = scanner.nextLine().split(" ");
            switch (comando[0]) {
                case "installa":
                    if(comando[1].equals("lavatrice"))
                        System.out.println("\tinstalla lavatrice: " + lav.installa(new Lavatrice(Double.parseDouble(comando[2]))));
                    else if(comando[1].equals("asciugatrice"))
                        System.out.println("\tinstalla asciugatrice: " + lav.installa(new Asciugatrice(Double.parseDouble(comando[2]))));

                    break;
                
                default:
                    break;
            }
        }
    }

}
