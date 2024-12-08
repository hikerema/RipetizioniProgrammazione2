public class Macchina {
//OVERVIEW: modella Macchina il cui stato può essere aperta o chiusa

//attributes
    public boolean lock = false;
    public double costo = 0;

//constructors
    public Macchina(double costo) throws IllegalArgumentException {
    //MODIFIES: this
    //EFFECTS: inizializzo lo stato della Macchina
    //         se credito <= 0 lancia IllegalArgumentException
        if(costo <= 0)
            throw new IllegalArgumentException("credito <= 0");

        assert repOk();
        this.costo = costo;

    }

//methods
    public void verificaStato() throws LockException{
    //EFFECTS: verifica lo stato della macchina
    //         se stato è già close lancia LockException
    
        if(lock = locked())
            throw new LockException("macchina già chiusa");
        
        lock = !locked();

    }

    public boolean locked() {
    //EFFECTS: stato viene inizializzato a true (open)
        return lock = true;
    }

    @Override
    public String toString() {
        if(locked())
            return "chiusa";
        return "aperta";
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }


    private boolean repOk() {
        if(costo <= 0)
            return false;
        return true;
    }
}