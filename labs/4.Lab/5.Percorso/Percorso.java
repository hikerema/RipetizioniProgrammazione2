import java.util.ArrayList;
import java.util.Scanner;

public class Percorso {
//OVERVIEW: Gestisce l'aggiunta di Punti in coda alla sequenza,
//          può rimuovere l'ultimo Punto in coda alla sequenza,
//          calcola la lunghezza totale del percorso.
    
    private ArrayList<Punto> punti = new ArrayList<>(); // io sono quello che c'è scritto qua

    public Percorso(ArrayList[] punti) { //costruttore
    //MODIFIES: this.
    //EFFECTS: creo un nuovo percorso con i punti.    
        this.punti = punti;
    }

    public void AggiungiPunto(Punto p) {
    //MODIFIES: this.
    //EFFECTS: aggiunge un punto in coda al percorso.
        punti.add(p);
    }

    public void RimuoviUltimo() {
    //MODIFIES: this.
    //EFFECTS: riminuove l'ultimo punto in coda al percorso.
        punti.remove(punti.size() - 1);
    }

    public double DistanzaTotale() {
    //EFFECTS: calcola la distanza totale del percorso
        double dTot = 0;
        for (int i = 0; i < this.punti.length - 1; i++) {
            dTot += this.punti.get(i).distanza(this.punti.get(i+1));
        }
        return dTot;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci le coordinate di un punto per riga nel formato <x y> (termina con CTRL+D)");
        ArrayList<Punto> nuoviPunti = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] coordinate = line.split(" ");
            double x = Double.parseDouble(coordinate[0]);
            double y = Double.parseDouble(coordinate[1]);
            Punto p = new Punto(x, y);
            nuoviPunti.add(p);
        }
        scanner.close();

        Percorso percorso = new Percorso(nuoviPunti);
        System.out.println("Totale: " + percorso.DistanzaTotale());
    }
}