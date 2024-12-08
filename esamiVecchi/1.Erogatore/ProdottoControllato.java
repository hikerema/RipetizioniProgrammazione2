public class ProdottoControllato extends Prodotto {
//OVERVIEW: un ProdottoControllato definisce un'età minima per vendere i prodotti

//attributes
    public final int etaMin;

//constuctors
    public ProdottoControllato(String nome, double prezzo, int etaMin) throws IllegalArgumentException{
    //MODIFIES: this
    //EFFECTS: inizializza this con anche eta
    //         se eta <= 0 lancia IllegalArgumentException
        super(nome, prezzo);
        
        if(etaMin <= 0)
            throw new IllegalArgumentException("Eta non può essere minore o uguale a 0");
        
        this.etaMin = etaMin;
    }

//methods
    @Override
    public String toString() {
        return super.toString() + " età minima: " + etaMin + " anni";
    }

}
