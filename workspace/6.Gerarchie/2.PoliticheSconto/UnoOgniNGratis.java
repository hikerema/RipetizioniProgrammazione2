public class UnoOgniNGratis extends PoliticaSconto {
    private int n;

    public UnoOgniNGratis(int numeroArticoli, double prezzoArticolo, int n) {
        super(numeroArticoli, prezzoArticolo);
        this.n = n;
    }

    @Override
    public double calcolaSconto() {
        return (numeroArticoli / n) * prezzoArticolo;
    }
}
