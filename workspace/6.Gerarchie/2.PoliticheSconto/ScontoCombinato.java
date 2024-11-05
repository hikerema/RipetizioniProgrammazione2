public class ScontoCombinato extends PoliticaSconto {
    private PoliticaSconto sconto1;
    private PoliticaSconto sconto2;

    public ScontoCombinato(int numeroArticoli, double prezzoArticolo, PoliticaSconto sconto1, PoliticaSconto sconto2) {
        super(numeroArticoli, prezzoArticolo);
        this.sconto1 = sconto1;
        this.sconto2 = sconto2;
    }

    @Override
    public double calcolaSconto() {
        return sconto1.calcolaSconto() + sconto2.calcolaSconto();
    }
    
}
