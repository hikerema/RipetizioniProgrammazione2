import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Lavanderia implements Iterable<Macchina>{
//OVERVIEW: Lavanderia contiene diverse Macchine e tiene traccia del credito inserito

//attributes
    public double creditoTot = 0;
    ArrayList<Macchina> macchine = new ArrayList<>();

//methods
    public double addCredito(double credito) throws IllegalArgumentException{
    //MODIFIES: this
    //EFFECTS: aggiunge credito a credito totale
    //         se credito <= 0 lancia IllegalArgumentException
        if(credito <= 0)
            throw new IllegalArgumentException("Credito non valido");
        
        return this.creditoTot + credito;
    }

    public int installa(Macchina m) throws NoSuchElementException{
    //MODIFIES: this
    //EFFECTS: installa una nuova macchina m
    //         se m null lancia NoSuchElementExcpetion
        if(m == null)
            throw new NoSuchElementException("macchina null");
        
        macchine.add((Macchina)m.clone());
        return macchine.indexOf(m);
    }

    public void rimuovi(int id) throws IllegalArgumentException {
    //MODIFIES: this
    //EFFECT: rimuove id da macchine
    //        se id <= 0 lancia IllegalArgumentException

        if(id < 0)
            throw new IllegalArgumentException("id <= 0");
        
        macchine.remove(id);
    }

    public double lava(int id) throws IllegalArgumentException, UnsupportedOperationException, CreditException {
    //MODIFIES: credito
        if(id < 0)
            throw new IllegalArgumentException("id <= 0");
        
        if(macchine.get(id).getClass() != Lavatrice.class)
            throw new UnsupportedOperationException("non è una lavatrice");
        Lavatrice m = (Lavatrice)macchine.get(id);
        if(m.costo > creditoTot)
            throw new CreditException("credito insufficiente");
        
        m.locked();
        return creditoTot -= m.costo;

    }

    public double asciuga(int id) throws IllegalArgumentException, UnsupportedOperationException, CreditException {
    //MODIFIES: credito
        if(id < 0)
            throw new IllegalArgumentException("id <= 0");
            
        if(macchine.get(id).getClass() != Lavatrice.class)
            throw new UnsupportedOperationException("non è un'asciugatrice");
        Asciugatrice m = (Asciugatrice)macchine.get(id);
        if(m.costo > creditoTot)
            throw new CreditException("credito insufficiente");
        
        m.locked();
        return creditoTot -= m.costo;
    
    }

    @Override
    public Iterator<Macchina> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
