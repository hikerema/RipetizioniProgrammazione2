public class ScontoQuantita extends PoliticaSconto {
//OVERVIEW: ScontoQuantita è una classe che estende PolitioSconto e restituirà uno sconto se superato un determinato minimo

    private int minimo;
    private double percentuale;

    public ScontoQuantita(int numeroArticoli, double prezzoArticolo, int minimo, double percentuale) {
        super(numeroArticoli, prezzoArticolo);
        this.minimo = minimo;
        this.percentuale = percentuale;
    }

    @Override
    public double calcolaSconto() {
        if (numeroArticoli >= minimo) {
            return this.prezzoArticolo * percentuale / 100;
        } else {
            return 0;
        }
    }
}
