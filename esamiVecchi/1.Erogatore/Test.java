
import java.util.Scanner;

public class Test {
//OVERVIEW: testa la classe Erogatore
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Erogatore erogatore = new Erogatore();

        System.out.println("Inserisci comandi (Ctrl + z termina)");
        System.out.println("\tCarica <nome> <prezzo> [etàMin] <qty>");
        System.out.println("\tEroga <nome>");
        System.out.println("\tAggiungi <credito>");
        System.out.println("\tValida <età>");


        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(" ");
            switch (parts[0]) {
                case "Carica":
                    if(parts.length == 5)
                        erogatore.carica(new ProdottoControllato(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3])), Integer.parseInt(parts[4]));
                    else if(parts.length == 4)
                        erogatore.carica(new Prodotto(parts[1], Double.parseDouble(parts[2])), Integer.parseInt(parts[3]));
                    break;
                case "valida":
                    erogatore.validaEta(Integer.parseInt(parts[1]));
                    break;
                case "Aggiungi":
                    System.out.println("\t Credito: " + erogatore.addCredito(Double.parseDouble(parts[1])));
                    break;
                    case "Eroga":
					try {
						System.out.println("\tProdotto: " + erogatore.eroga(parts[1]));
					} catch(Exception e) {
						System.out.println("\t" + e.getMessage());
					}
					break;
            }
            
        }
        scanner.close();
        System.out.println("\n" + erogatore);
    }
}
