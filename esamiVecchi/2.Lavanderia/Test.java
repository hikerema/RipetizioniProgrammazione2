import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Lavanderia lav = new Lavanderia();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci comandi (Ctrl+D termina)");
        System.out.println("installa <lavatrice/asciugatrice> <costo>");
        System.out.println("lava/asciuga/rimuovi/apri <id>");
        System.out.println("aggiungi <credito>");
        System.out.println("status");

        while(scanner.hasNextLine()) {
            String[] comando = scanner.nextLine().split(" ");
            switch (comando[0]) {
                case "installa":
                    try {
                        if(comando[1].equals("lavatrice"))
                            System.out.println("\tinstallata lavatrice: " + lav.install(new Lavatrice(Double.parseDouble(comando[2]))));
                        else if (comando[1].equals("asciugatrice")) 
                            System.out.println("\tinstallata asciugatrice: " + lav.install(new Asciugatrice(Double.parseDouble(comando[2]))));
                    } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "lava":
                    try {
                        System.out.println("\tCredito: " + lav.lava(Integer.parseInt(comando[1])));
                        
                    } catch (CreditException | UnsupportedOperationException | LockException | IllegalArgumentException | IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "asciuga":
                    try {
                        System.out.println("\tCredito: " + lav.asciuga(Integer.parseInt(comando[1])));
                        
                    } catch (CreditException | UnsupportedOperationException | LockException | IllegalArgumentException | IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "rimuovi":
                    try {
                        lav.remove(Integer.parseInt(comando[1]));
                        
                    } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "apri":
                    try {
                        lav.open(Integer.parseInt(comando[1]));
                        
                    } catch (LockException | IllegalArgumentException | IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }   
                    break;
                case "aggiungi":
                    try {
                        System.out.println("\tCredito: " + lav.addCredito(Double.parseDouble(comando[1])));
                
                        
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "status":
                    try {
                        System.out.println("\t" + lav);
                        
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}
