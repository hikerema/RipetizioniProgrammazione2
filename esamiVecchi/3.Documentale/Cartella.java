import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Cartella extends Contenuto implements Iterable<Contenuto> {
//OVERVIEW: modella Cartella che implementa un Iterable<Contenuto>

//attributes
    public ArrayList<Contenuto> sottoCartelle = new ArrayList<>();
    private Cartella cartellaSup;
    
//costructors
    public Cartella(String name, int dimensione, Cartella cartellaSup, ArrayList<Contenuto> sottoCartelle) throws NoSuchElementException, IllegalArgumentException{
    //MODIFIES: this
    //EFFECTS: inizializza Cartella con sottoCartelle e cartellaSup
    //         se sottoCartelle è vuoto lancia NoSuchElementException
    //         se sottoCartelle è nullo lancia IllegalArgumentException
        super(name, dimensione);

        if(sottoCartelle == null)
            throw new IllegalArgumentException("sottocartelle null");            
        if(sottoCartelle.isEmpty())
            throw new NoSuchElementException("non ci sono sottocartelle");
        
        assert repOk();
        this.cartellaSup = cartellaSup;
        this.sottoCartelle = new ArrayList<>();
    }

//methods
    public int getDimensioneCartella() {
    //EFFECTS: restituisce la dimensione della cartella
        for (Contenuto contenuto : sottoCartelle) {
            this.dimensione += contenuto.getDimensione();
        }
        assert repOk();
        return this.dimensione;
    }

    public Cartella getCartellaSup() throws NoSuchElementException {
    //EFFECTS: resituisce la cartella superiore
    //         se non c'è una cartella superiore lancia NoSuchElementException    
        if(this.cartellaSup == null)
            throw new NoSuchElementException("Non ha una cartella superiore");
        
        return (Cartella)this.cartellaSup;
    }

    public Cartella getCartella(String name) throws NoSuchElementException, ElementExistsException, NoSuchDirException {
    //EFFECTS: restituisce una cartella contenuta dato il suo nome
    //         se nome non corrisponde a un contenuto lancia NoSuchElementException
    //         se nome corrisponde a un documento lancia NoSucDirException
        for (Contenuto contenuto : sottoCartelle) {
            if(contenuto.getName().equals(name)) {
                if(contenuto instanceof Cartella)
                    return (Cartella)contenuto;
                else
                    throw new NoSuchDirException(name + " corrisponde a un documento");
            } 
        }
        throw new NoSuchElementException("nome non trovato");
    }

    public void aggiungi(Contenuto c) throws ElementExistsException {
    //MODIFIES: this
    //EFFECTS: aggiunge un nuovo contenuto alla cartella
    //         se esiste già lancia ElementExistsException
    //         se contenuto è una cartella, this diventa cartellaSup
        if(sottoCartelle.contains(c))
            throw new ElementExistsException("già esistente");
        if(c instanceof Cartella)
            this.cartellaSup = (Cartella)c;
        sottoCartelle.add(c);
    }

    public void rimuovi(String name) throws NoSuchElementException {
    //MODIFIES: this
    //EFFECTS: rimuove c dato il suo nome
    //         se nome non corrisponde a un contenuto lancia NoSuchElementException
        for (Contenuto contenuto : sottoCartelle) {
            if(contenuto.getName().equals(name)) {
                sottoCartelle.remove(contenuto);
                return;
            }
        }
        throw new NoSuchElementException(name + "non trovato");
    }

    public boolean repOk() {
        if(this.sottoCartelle == null)
            return false;
        if(this.cartellaSup == null)
            return false;
        
        return true;
    }


    @Override
    public Iterator<Contenuto> iterator() {
        return new Iterator<Contenuto>() {

            Iterator<Contenuto> i = sottoCartelle.iterator();
            
            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public Contenuto next() {
                return i.next();
            }
            
        };
    }   
}
