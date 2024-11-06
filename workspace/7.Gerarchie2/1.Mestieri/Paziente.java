public class Paziente extends Persona {
//OVERVIEW: classe che estende Persona e i cui oggetti rappresentano i pazienti della clinica.
//          Oltre alle caratteristiche di Persona, un Paziente ha un codice identificativo (String)
    private String codice;

    public Paziente(String nome, String codice) {
        super(nome);
        this.codice = codice;
    }
}