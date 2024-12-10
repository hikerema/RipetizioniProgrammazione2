public abstract class Macchina implements Comparable<Macchina>{
//OVERVIEW: modella Macchina astratta

//attributes
    public final double costo;
    private boolean stato = false; //false = chiuso

//costructors
    public Macchina(double costo) throws IllegalArgumentException {
    //MODIFIES: this
    //EFFECTS: inizializza this
    //         se costo <= 0 lancia IllegalArgumentException
        if(costo <= 0)
            throw new IllegalArgumentException("\tcosto <= 0");
        this.costo = costo;
    }

//methods
    public void lock() throws LockException {
    //MODIFIES: this
    //EFFECTS: this.stato == false (chiuso)
    //         se this.stato è già false lancia LockException
        if(this.stato == false)
            throw new LockException("\tgià chiusa");
        
        this.stato = false;

    }

    public void unlock() throws LockException {
    //MODIFIES: this
    //EFFECTS: this.stato == true (aperto)
    //         se this.stato è già true lancia LockException
        if(this.stato == true)
            throw new LockException("\tgià aperta");
            
        this.stato = true;
    
    }
    
    public boolean verificaStato() {
    //EFFECTS: restituisce lo stato della macchina
        return this.stato;    
    }

    @Override
    public int compareTo(Macchina m) {
        if(this.costo > m.costo)
            return 1;
        else if(this.costo < m.costo)
            return -1;
        
        return 0;
    }

    @Override
    public String toString() {
        if(this.stato == true)
            return " costo: " + this.costo + " aperta";
        else
            return " costo: " + this.costo + " chiusa";
    }
}