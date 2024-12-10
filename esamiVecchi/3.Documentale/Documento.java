public class Documento extends Contenuto {
//OVERVIEW: modella Documento che estende Contenuto

//costructors
    public Documento(String name, int dimensione) {
        super(name, dimensione);
    }

//methods
    @Override
    public String toString() {
        return "\tdocumento: " + this.getName() + " dimensione: " + this.getDimensione();
    }
}
