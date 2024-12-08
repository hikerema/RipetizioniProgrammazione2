public class Lavatrice extends Macchina{
 //OVERVIEW: modella Lavatrice come macchina

    public Lavatrice(double costo) {
        super(costo);
    }

    @Override
    public String toString() {
        return "Lavatrice costo: " + costo;
    }
    
}
