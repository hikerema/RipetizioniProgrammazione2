public class Prodotto implements Comparable<Prodotto>, Cloneable {
//OVERVIEW: un Prodotto è definito da un nome e dal suo prezzo

//attributes
    public final String nome;
    public double prezzo;

//constructors
    public Prodotto(String nome, double prezzo) throws NullPointerException, IllegalArgumentException{
    //MODIFIES: this
    //EFFECTS: inizializza nome e prezzo del prodotto
    //         if nome == null lancia NullPointerException
    //         if nome == "" e prezzo <= 0 lancia IllegalArgumentException

        if(nome == null)
            throw new NullPointerException("Nome non può essere null");
        
        if(nome.equals(""))
            throw new IllegalArgumentException("Nome non può essere vuoto");
        
        if(prezzo <= 0)
            throw new IllegalArgumentException("Prezzo non può essere negativo");
        
        this.nome = nome;
        this.prezzo = prezzo;

        assert repOk();
    }

//methods

    public double getPrezzo() {
    //EFFECTS: restituisce il prezzo del prodotto
        return this.prezzo;
    }

    public void setPrezzo(double p) throws IllegalArgumentException{
    //MODIFIES: this
    //EFFECTS: modifica this.prezzo
    //         se p <= 0 lancia IllegalArgumentException
        if(p <= 0)
            throw new IllegalArgumentException("Prezzo non può essere negativo");
        
        this.prezzo = p;
    }

    @Override
    public int compareTo(Prodotto o) {
        return this.nome.compareTo(o.nome);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Prodotto))
			return false;

		return ((Prodotto) obj).nome.equals(this.nome);
    }

    @Override
    public int hashCode() {
        return this.nome.hashCode();
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    
    @Override
    public String toString() {
        return "Prodotto: " + this.nome + " prezzo: " + this.prezzo;
    }

    public boolean repOk() {
        if(nome ==  null)
            return false;
        
        if(nome.equals(""))
            return false;
        
        if(prezzo <= 0)
            return false;    
        
        return true;
    }
    

}