public class Asteroide {
//OVERVIEW:  classe che definisce oggetti in base alla loro massa (in kg) e distanza dalla terra (in km)

    private double massa;
    private double distanza;

    public Asteroide(double massa, double distanza) throws IllegalAsteroideException {
    //EFFECTS: throw IllegalAsteroideException quando massa <= 0
    //         throw IllegalAsteroideException quando distanza < 0
        if (this.massa <= 0) {
            System.out.println(this.massa);
            throw new IllegalAsteroideException("Errore nella massa");
        }
        if (this.distanza < 0) {
            
            throw new IllegalAsteroideException("Errore nella distanza");
        }
        this.massa = massa;
        this.distanza = distanza;
    }

    public double getMassa() {
        return this.massa;
    }
    public double getDistanza() {
        return this.distanza;
    }

    public double forzaGravitazionale() {
        return this.massa/Math.pow(this.distanza, 2);
    }
}