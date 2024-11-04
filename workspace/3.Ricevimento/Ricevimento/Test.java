import java.util.Arrays;
import java.util.Scanner;
public class Test {

    public static void main(String[] args) {
        String[] agenda = new String[6];
        Scanner scanner = new Scanner(System.in);

        while (Ricevimento.orariDisponibili(agenda).length != 0) {
            int[] orari = Ricevimento.orariDisponibili(agenda);
            System.out.println("Puoi prenotare un appuntamento alle: " + Arrays.toString(orari));
            System.out.println("Inserisci il nome: ");
            String nome = scanner.next();
            System.out.println(nome);
            System.out.println("Inserisci l'orario: ");
            int orario = scanner.nextInt();

            try {
                Ricevimento.prenota(agenda, orario, nome);
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            } catch (TimeBusyException | AlreadyBookedException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
            
        }
        scanner.close();
        for (String orarioArray : agenda) {
            System.out.println(orarioArray);
        }
        
    }
} 