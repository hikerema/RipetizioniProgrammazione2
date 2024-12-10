public class Lavatrice extends Macchina {
//OVERVIEW: Lavatrice che estende Macchina

//costructors
    public Lavatrice(double costo) {
        super(costo);
    }

    @Override
    public String toString() {
        return "Lavatrice: " + super.toString();
    }
}
