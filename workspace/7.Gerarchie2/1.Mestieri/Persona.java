public class Persona {
//OVERVIEW: classe che contiene un solo attributo nome,
//          un costruttore che inizializza una nuova persona col suo nome
//          e un getter per lo stesso attributo
    private final String nome;

    public Persona(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}