public class Cuboide extends Contenitore {
//OVERVIEW: Un contenitore cuboide, ossia un solido con 6 facce rettangolari,
//          ed è definito dai suoi tre lati a, b e c.
//          Il suo volume massimo è calcolato come a * b * c
    public double a;
    public double b;
    public double c;

    public Cuboide(String nomeContenitore, double maxCapienza, double a, double b, double c, String nomeLiquido, double volumeLiquido) throws CapacityException{
    //EFFECTS: if a <= 0 oppure b <= 0 oppure c <= 0 throw new IllegalArgumentException
        super(nomeContenitore, maxCapienza, nomeLiquido, volumeLiquido);
        if(a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Lato <= 0");
        }
 
        volumeLiquido = a * b * c;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return String.format("Cuboide - lati: %.2f, %.2f, %.2f %s", a, b, c, super.toString());
    }

    @Override
    public int compareTo(Contenitore o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
