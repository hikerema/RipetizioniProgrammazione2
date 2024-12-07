public abstract class Prodotto implements Comparable<Prodotto>{
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
    }

//methods
    public String getNome() {
    //EFFECTS: restituisce il nome del prodotto
        return this.nome;
    }

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
    public String toString() {
        return "Prodotto: " + this.nome + " prezzo: " + this.prezzo;
    }

    
    

}