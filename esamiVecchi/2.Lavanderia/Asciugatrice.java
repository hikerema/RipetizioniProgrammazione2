public class Asciugatrice extends Macchina{
    
    public Asciugatrice(double costo) {
        super(costo);
    }

    @Override
    public String toString() {
        return "Asciugatrice costo: " + costo;
    }

}
