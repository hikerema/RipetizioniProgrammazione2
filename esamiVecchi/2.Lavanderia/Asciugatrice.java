public class Asciugatrice extends Macchina {
        //OVERVIEW: Asciugatrice che estende Macchina
        
        //costructors
            public Asciugatrice(double costo) {
                super(costo);
            }
        
            @Override
            public String toString() {
                return "Asciugatrice: " + super.toString();
            }
}
