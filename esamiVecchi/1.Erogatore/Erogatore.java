
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Erogatore implements Iterable<Prodotto> {
//OVERVIEW: un Erogatore può contenere diversi prodotti e per ciascuno memorizza la quantità contenuta
//          tiene traccia del credito inserito

//attributes
    public double credito = 0;
    public int etaVal = 0;
    public HashMap<Prodotto, Integer> prodotti = new HashMap<>();

//methods
    public void validaEta(int eta) throws IllegalArgumentException{
        //MODIFIES: this
        //EFFECTS: imposta etaVal = eta
        //         se eta <= 0 lancia IllegalArgumentException
        if(eta <= 0)
            throw new IllegalArgumentException("Età non può essere <= 0");
        
        etaVal = eta;
        assert repOk();
    }

    public double addCredito(double credito) throws IllegalArgumentException{
    //MODIFIES: credito
    //EFFECTS: restituisce il credito totale
        if(credito <= 0)
            throw new IllegalArgumentException("Credito <= 0");
        this.credito += credito;

        assert repOk();
        return this.credito;
    }

    public void carica(Prodotto p, int qty) throws IllegalArgumentException{
    //MODIFIES: prodotti
    //EFFECTS: aggiunge p a prodotti
    //         se p == null lancia IllegalArgumentException
        if(p == null)
            throw new IllegalArgumentException("p non può essere null");
        
        if(qty <= 0)
            throw new IllegalArgumentException("quantità non può essere <= 0");

        prodotti.put((Prodotto) p.clone(), qty+prodotti.getOrDefault(p, 0));
        assert repOk();
    }

    public Prodotto get(String s) throws NullPointerException, CloneNotSupportedException {
		if(s == null)
			throw new NullPointerException("s null");

		for(Prodotto p : prodotti.keySet())
			if(p.nome.equals(s))
				return (Prodotto) p.clone();

		return null;
	}

    public double eroga(String s) throws AgeException, CreditException, NoSuchElementException, NullPointerException, CloneNotSupportedException {
    //MODIFIES: this
    //EFFECTS: eroga prodotto, scala il credito e il numero di prodotti, e setta etaVal = 0
    //         se ProdottoControllato e etaVal < p.etaMin lancia AgeException
    //         se s null lancia NullPointerException
    //         se non contiene prodotto lancia NoSuchElementExcpetion
    //         se credito insufficiente lancia CreditoInsufficienteException
        Prodotto p = get(s);

        if(p == null)
            throw new NullPointerException(p + "p null");

        if(p.getPrezzo() > this.credito) 
            throw new CreditException("credito < " + p.getPrezzo());
        
        if(p.getClass().equals(ProdottoControllato.class)) {
            if(this.etaVal > ((ProdottoControllato)p).etaMin)
                throw new AgeException("età < min");
        }
        this.credito -= p.getPrezzo();
        
        if(prodotti.get(p) == 1)
            prodotti.remove(p);
        else
            prodotti.replace(p, prodotti.get(p)-1);
        
        etaVal = 0;
        assert repOk();
        return this.credito;
        
    }

    @Override
    public Iterator<Prodotto> iterator() {
        ArrayList<Prodotto> list = new ArrayList<>(prodotti.keySet());
        list.sort(null);

        return new Iterator<Prodotto>() {
            Iterator<Prodotto> i = list.iterator();
            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public Prodotto next() {
                return i.next();
            }

        };
        
    }

    public boolean repOk() {
        if(credito < 0)
            return false;
        if(etaVal < 0)
            return false;

        for (Prodotto p : prodotti.keySet()) {
            if(p == null)
                return false;
            else if(prodotti.get(p) <= 0)
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String ret = "Erogatore (età valida: " + etaVal + "):";
        for (Prodotto p : prodotti.keySet()){
            ret += "\n\t" + p + " qty: " + prodotti.keySet();
        }
        return ret;
    }

    

}
