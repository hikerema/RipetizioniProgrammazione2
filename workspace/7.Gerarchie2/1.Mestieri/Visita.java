import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Visita {
//OVERVIEW: classe che definisce una visita a un Paziente da un Dottore
    private String nomeDottore;
    private String codicePaziente;

    public Visita(String nomeDottore, String codicePaziente) {
        this.nomeDottore = nomeDottore;
        this.codicePaziente = codicePaziente;
    }

    public String getNomeDottore() {
        return this.nomeDottore;
    }

    public static void main(String[] args) {
        System.out.println("Inserisci medici nel formato `nome specializzazione parcella` (termina con linea vuota)"); //cambiato il messaggio per descrivere all'utente come si interrompe l'inserimento
        ArrayList<Dottore> medici = new ArrayList<Dottore>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break; // se la riga è vuota termina l'inserimento ed esce dal ciclo
            String[] valori = line.split(" ");
            Dottore medico = new Dottore(valori[0], valori[1], Double.parseDouble(valori[2]));
            medici.add(medico);
        }
        //scanner.close(); lo chiudo alla fine del programma

        System.out.println("Inserisci i pazienti nel formato `nome codice` (termina con linea vuota)");
        ArrayList<Paziente> pazienti = new ArrayList<Paziente>();
        //Scanner scanner1 = new Scanner(System.in); ho deciso di optare per una soluzione che usa un solo scanner
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break; // se la riga è vuota termina l'inserimento ed esce dal ciclo
            String[] valori = line.split(" ");
            Paziente paziente = new Paziente(valori[0], valori[1]);
            pazienti.add(paziente);
        }

        System.out.println("Inserisci visite nel formato `nomeDottore codicePaziente` (termina con linea vuota)");
        ArrayList<Visita> visite = new ArrayList<Visita>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break; // se la riga è vuota termina l'inserimento ed esce dal ciclo
            String[] valori = line.split(" ");
            Visita visita = new Visita(valori[0], valori[1]);
            visite.add(visita);
        }
        scanner.close();

        HashMap<String, Integer> map = new HashMap<>();

        System.out.println("I guadagni del mese sono: ");
        for (Visita v : visite) {
            map.put(v.getNomeDottore(), map.getOrDefault(v.getNomeDottore(), 0) + 1);
        }
        
        double guadagno = 0;
        for (String key : map.keySet()) {
            for (Dottore d : medici) {
                if (d.getNome().equals(key)) {
                    guadagno += d.getParcella() * map.get(key);
                    System.out.println(d.getNome() + guadagno);
                }
            }
        }
    }
}