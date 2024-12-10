
import java.util.NoSuchElementException;

public abstract class Contenuto implements Comparable<Contenuto>{
//OVERVIEW: classe astratta Contenuto definita da nome e dimensione

//atributes
    private final String name;
    public int dimensione;

//costructors
    public Contenuto(String name, int dimensione) throws NoSuchElementException, IllegalArgumentException {
    //MODIFIES: this
    //EFFECTS: inizializza Contenuto con name e dimensione
    //         se name == null lancia NoSuchElementException
    //         se name == "" lancia IllegalArgumentException
    //         se dimensione <= 0 lancia IllegalArgumentException
        if(name == null)
            throw new NoSuchElementException("\tnome null");
        
        if(name.equals(""))
            throw new IllegalArgumentException("\tnome non può essere vuoto");
    
        if(dimensione <= 0)
            throw new IllegalArgumentException("\tdimensione <= 0");
        
        this.name = name;
        this.dimensione = dimensione;
    }

//methods
    public String getName() {
    //EFFECTS: restituisce this.name
        assert repOk();
        return this.name;
    }

    public int getDimensione() {
    //EFFECTS: restituisce this.dimensione
        assert repOk();
        return this.dimensione;
    }

    public boolean uguale(Contenuto c) {
    //EFFECTS: restituisce true se this.name è uguale a c.name, altrimenti false
        if(this.name.equals(c.getName()))
            return true;
        return false;
    }

    public boolean repOk() {
        if(this.name == null)
            return false;
        
        if(this.name.equals(""))
            return false;
    
        if(this.dimensione <= 0)
            return false;
        
        return true;
    }

    @Override
    public int compareTo(Contenuto c) {
        if(this.dimensione > c.getDimensione())
            return 1;
        else if(this.dimensione < c.getDimensione())
            return -1;
        return 0;
    }


    @Override
    public String toString() {
        return "\tContenuto: nome " + this.name + " dimensione: " + this.dimensione;
    }

}