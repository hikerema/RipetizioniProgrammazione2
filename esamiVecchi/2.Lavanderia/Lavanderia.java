import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Lavanderia implements Iterable<Macchina> {
//OVERVIEW: contiene una insieme di Macchina (lavatrici o asciugatrici)

//attributes
    private double credito = 0;
    private ArrayList<Macchina> lav = new ArrayList<>();

//methods
    public double addCredito(double credito) throws IllegalArgumentException {
    //MODIFIES: this
    //EFFECTS: restituisce this incrementato di credito
    //         se credito <= 0 lancia IllegalArgumentException
        if(credito <= 0)
            throw new IllegalArgumentException("credito <= 0");
        
        this.credito += credito;
        assert repOk();

        return this.credito;
    }

    public int install(Macchina m) throws NoSuchElementException {
    //MODIFIES: this
    //EFFECTS: installa una macchina in lavanderia
    //         restituisce un identificatore della macchina (int)
    //         se macchina null lancia NoSuchElementException
        if(m == null)
            throw new NoSuchElementException("macchina null");
        
        lav.add(m);
        assert repOk();
        return lav.indexOf(m);
        
    }

    public void remove(int id) throws IllegalArgumentException, IndexOutOfBoundsException {
    //MODIFIES: this
    //EFFECTS: rimuove la macchina id da lav
    //         se id < 0 lancia IllegalArgumentException
    //         se id non presente in lav lancia IndexOutOfBoundsException
        if(id < 0)
            throw new IllegalArgumentException("id < 0");
        if(id > lav.size()-1)
            throw new IndexOutOfBoundsException("id non presente");

        lav.remove(id);
        assert repOk();
    }

    public double lava(int id) throws IllegalArgumentException, IndexOutOfBoundsException, LockException, CreditException, UnsupportedOperationException {
    //MODIFIES: this
    //EFFECTS: avvia lavatrice, chiudendola e scalando il credito
    //         se id invalido lancia IndexOutOfBoundsException
    //         se macchina non è lavatrice lancia UnsupportedOperationException
    //         se credito non sufficiente lancia CreditException
   
        if(id < 0)
            throw new IllegalArgumentException("\tid < 0");
        else if(id > lav.size()-1)
            throw new IndexOutOfBoundsException("\tid non presente");

        else if(lav.get(id).getClass() != Lavatrice.class)
            throw new UnsupportedOperationException("\tnon è una lavatrice");
        
        else if(lav.get(id).costo > this.credito) {
            System.out.println("costo: " + lav.get(id).costo + "credito: " + this.credito);
            throw new CreditException("\tcredito insufficiente");
        }
        
        this.credito -= lav.get(id).costo;
        //lav.get(id).lock();
        
        return this.credito;  
    }

    public double asciuga(int id) throws IllegalArgumentException, IndexOutOfBoundsException, LockException, CreditException, UnsupportedOperationException {
        //MODIFIES: this
        //EFFECTS: avvia asciugatrice, chiudendola e scalando il credito
        //         se id invalido lancia IndexOutOfBoundsException
        //         se macchina non è asciugatrice lancia UnsupportedOperationException
        //         se credito non sufficiente lancia CreditException
       
            if(id < 0)
                throw new IllegalArgumentException("\tid < 0");
            if(id > lav.size()-1)
                throw new IndexOutOfBoundsException("\tid non presente");
    
            if(lav.get(id).getClass() != Asciugatrice.class)
                throw new UnsupportedOperationException("\tnon è una asciugatrice");
            
            if(lav.get(id).costo > this.credito)
                throw new CreditException("\tcredito insufficiente");
            
        this.credito -= lav.get(id).costo;
        lav.get(id).lock();
            
        return this.credito;  
    }

    public void open(int id) throws IllegalArgumentException, IndexOutOfBoundsException, LockException {
    //MODIFIES: this
    //EFFECTS: apre la macchina id
    //         se id invalido lancia IndexOutOfBoundsException
        if(id < 0)
            throw new IllegalArgumentException("id < 0");
        if(id > lav.size()-1)
            throw new IndexOutOfBoundsException("id non presente");

        lav.get(id).unlock();

    }

    @Override
    public Iterator<Macchina> iterator() {
        return new Iterator<Macchina>() {
            Iterator<Macchina> i = lav.iterator();

            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public Macchina next() {
                return i.next();
            }
        };
    }

    @Override
    public String toString() {
        String ret = "\tLavanderia -> credito: " + this.credito + " macchine:\n";
        for (Macchina macchina : lav) {
            ret += "\t" + macchina.toString() + "\n";
        }
        return ret;
    }

    public boolean repOk() {
        if(credito <= 0)
            return false;

        for (Macchina m : lav) {
            if(m == null)
                return false;
        }
        return true;
    }
}
