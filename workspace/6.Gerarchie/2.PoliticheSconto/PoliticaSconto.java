public abstract class PoliticaSconto {
//OVERVIEW: PoliticaSconto è una classe astratta che restituirà lo sconto per l’acquisto
//          di un certo numero di articoli tutti dello stesso tipo, tramite il metodo calcolaSconto
    protected int numeroArticoli;
    protected double prezzoArticolo;

    public PoliticaSconto(int numeroArticoli, double prezzoArticolo) {
        this.numeroArticoli = numeroArticoli;
        this.prezzoArticolo = prezzoArticolo;
    }

    public abstract double calcolaSconto();
}