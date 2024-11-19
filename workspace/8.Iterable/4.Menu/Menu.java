
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Mac;

public class Menu extends Piatto implements Iterator<Piatto>{
//OVERVIEW: la classe contiene una serie di piatti
//          definisce una serie di metodi per aggiungere, togliere e modificare i piatti del menu
//          Se il metodo viene chiamato con un parametro tipo, l'iteratore dovrà generare solamente i piatti di quel tipo.
    private List<Piatto> piatti;
    
    public Menu() {
        this.piatti = new ArrayList<>();
    }

    public void aggiungiPiatto(Piatto piatto) {
        piatti.add = piatto;
    }

    public boolean rimuoviPiatto(String nome) {
        boolean removed = false;

        Iterator<Piatto> iterator = piatti.iterator();
        while (iterator.hasNext()) {
            Piatto piatto = iterator.next();
            
            if (piatto.getNome().equalsIgnoreCase(nome)) {
                iterator.remove();
                removed = true;
            }
        }
        
        return removed;
    }
    
    public boolean modificaPiatto(String nome, String nuovoNome, String nuovoTipo, double nuovoCosto) {
        for (Piatto p : piatti) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                p.setNome(nuovoNome);
                p.setTipo(nuovoTipo);
                p.setCosto(nuovoCosto);
                return true;
            }
        }
        return false;
    }
}