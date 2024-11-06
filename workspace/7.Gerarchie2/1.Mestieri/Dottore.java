public class Dottore extends Persona {
//OVERVIEW: classe che estende Persona e i cui oggetti rappresentano i medici di una clinica
//          un Dottore ha una Specializzazione (String) e una parcella per le visite (double)
    private String specializzazione;
    private double parcella;

    public Dottore(String nome, String specializzazione, double parcella) {
        super(nome); //chiama il costruttore della classe superiore
        this.specializzazione = specializzazione;
        this.parcella = parcella;
    }

    public double getParcella() {
        return this.parcella;
    }
}









