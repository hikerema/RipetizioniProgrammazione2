import java.util.ArrayList;
import java.util.Scanner;

public class Dipendente extends Persona {
//OVERVIEW: classe che estende Persona, i cui oggetti rappresentano
//          le schede dei dipendenti di un’azienda.
//          Oltre alle caratteristiche di Persona, un Dipendente possiede
//          una retribuzione annuale (double), un anno di assunzione (int)
//          e un codice identificativo (String)
    private double retribuzione;
    private int anno;
    private String codice;

    public Dipendente(String nome, String codice, int anno, double retribuzione) {
        super(nome); //chiama il costruttore della classe superiore
        this.retribuzione = retribuzione;
        this.anno = anno;
        this.codice = codice;
    }

    public int getAnno() {
        return this.anno;
    }

    public static void main(String[] args) {
        int annoInput = Integer.parseInt(args[0]);
        ArrayList<Dipendente> dipendenti = new ArrayList<Dipendente>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] valori = line.split(" ");
            Dipendente dipendente = new Dipendente(valori[0], valori[1], Integer.parseInt(valori[2]), Double.parseDouble(valori[3]));
            dipendenti.add(dipendente);
        }
        scanner.close();
        System.out.println("Dipendenti assunti prima del " + annoInput);
        for (Dipendente dip : dipendenti) {
            if (dip.getAnno() <= annoInput) {
                System.out.println(dip.getNome());
            }
        }
    }
}