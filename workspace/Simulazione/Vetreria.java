
import java.util.ArrayList;
import java.util.Iterator;

public class Vetreria {
//OVERVIEW: Una Vetreria è un insieme di contenitori di un laboratorio ed espone le seguenti funzionalità:

    public ArrayList<Contenitore> contenitori;

    public Vetreria() {
        this.contenitori = new ArrayList<>();
    }

    public void aggiungiContenitore(Contenitore c) {
    //EFFECTS: aggiunge un nuovo Contenitore alla vetreria
        this.contenitori.add(c);
    }

    public Vetreria estraiContenitore(String liquidoEstratto) {
    //EFFECTS: estrae dalla lista di contenitori, tutti i contenitori con all'interno liquidoEstratto
    //         e li mette in una nuova vetreria eliminandoli da quella originale
        Vetreria nuovaVetreria = new Vetreria();
        for (Contenitore contenitore : contenitori) {
            if(contenitore.nomeLiquido.equals(liquidoEstratto)) {
                nuovaVetreria.aggiungiContenitore(contenitore);
                contenitori.remove(contenitore);
            }
        }
        return nuovaVetreria;
    }

    public Iterator<Contenitore> iteratore() {
    //EFFECTS: restituire un iteratore ai contenitori presenti, ordinati in base al loro ordine naturale
        return contenitori.iterator();
    }

    public void sort() {
    //EFFECTS: restituisce la lista di contenitori ordinati in base alla capacità
        this.contenitori.sort(null);
    }

    public void ottimizzaDistribuzioneLiquidi() {
    //MODIFIES: this
    //EFFECTS: ottimizza la distribuzione dei liquidi, riempiendo fino al massimo quelli più capienti (con lo stesso liquido)
    //         e svuotando, se possibile, alcuni tra quelli meno capienti
        this.sort();
        int count = 0;
        for (Contenitore contenitore : contenitori) {
            double x = contenitore.getMaxCapienza() - contenitore.getVolumeLiquido();
            int cont = 0;
            while(x > 0) {
                this.contenitori.get(count).versa(this.contenitori.get(cont));
                cont++;
                x = this.contenitori.get(count).getMaxCapienza() - this.contenitori.get(count).getVolumeLiquido();
            }
            count++;
        }
    }

    public static void main(String[] args) {
        
    }
}
