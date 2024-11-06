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
        System.out.println("Inserisci medici nel formato `nome specializzazione parcella` (termina con CTRL+D)");
        ArrayList<Dottore> medici = new ArrayList<Dottore>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] valori = line.split(" ");
            Dottore medico = new Dottore(valori[0], valori[1], Double.parseDouble(valori[2]));
            medici.add(medico);
        }
        scanner.close();

        System.out.println("Inserisci i pazienti nel formato `nome codice` (termina con CTRL+D)");
        ArrayList<Paziente> pazienti = new ArrayList<Paziente>();
        Scanner scanner1 = new Scanner(System.in);
        while (scanner1.hasNextLine()) {
            String line = scanner1.nextLine();
            String[] valori = line.split(" ");
            Paziente paziente = new Paziente(valori[0], valori[1]);
            pazienti.add(paziente);
        }
        scanner1.close();

        System.out.println("Inserisci visite nel formato `nomeDottore codicePaziente` (termina con CTRL+D)");
        ArrayList<Visita> visite = new ArrayList<Visita>();
        Scanner scanner2 = new Scanner(System.in);
        while (scanner2.hasNextLine()) {
            String line = scanner2.nextLine();
            String[] valori = line.split(" ");
            Visita visita = new Visita(valori[0], valori[1]);
            visite.add(visita);
        }
        scanner2.close();

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