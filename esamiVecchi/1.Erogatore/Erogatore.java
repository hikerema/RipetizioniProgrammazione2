
import java.util.HashMap;
import java.util.Iterator;

public class Erogatore implements Iterable<Prodotto> {
//OVERVIEW: un Erogatore può contenere diversi prodotti e per ciascuno memorizza la quantità contenuta
//          tiene traccia del credito inserito

//attributes
    public double credito;
    public int qty = 0;
    public int etaVal = 0;
    public HashMap<Prodotto, Integer> prodotti = new HashMap<>();

//methods
    public void validaEta(int eta) throws IllegalArgumentException{
        //MODIFIES: this
        //EFFECTS: imposta etaVal = eta
        //         se eta <= 0 lancia IllegalArgumentException
        if(eta <= 0)
            throw new IllegalArgumentException("Età non può essere <= 0");
        
    }

    public double addCredito(double c) {
    //MODIFIES: credito
    //EFFECTS: restituisce il credito totale
        return credito + c;
    }

    public void carica(ProdottoControllato p, int qty) throws IllegalArgumentException{
    //MODIFIES: prodotti
    //EFFECTS: aggiunge p a prodotti
    //         se p == null lancia IllegalArgumentException
        if(p == null)
            throw new IllegalArgumentException("p non può essere null");
        if(qty <= 0)
            throw new IllegalArgumentException("quantità non può essere <= 0");
        
        prodotti.put(p, (Integer)qty);
    }

    @Override
    public Iterator<Prodotto> iterator() {
    //SBAGLIATO: da vedere bene come funziona
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean repOk() {
    //incompleta
        if(credito < 0)
            return false;
        if(etaVal < 0)
            return false;

        return true;
    }
}
