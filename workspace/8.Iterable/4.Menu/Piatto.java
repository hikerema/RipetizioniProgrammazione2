public class Piatto {
//OVERVIEW: classe che rappresenta un piatto di un menù con il suo nome, tipo (primo, secondo) e costo
    private String nome;
    private String tipo;
    private int costo;

    public Piatto() {
        this.nome = nome;
        this.tipo = tipo;
        this.costo = costo;
    }
    
    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCosto() {
        return costo;
    }

    public String setNome() {
        this.nome = nome;
    }

    public String setTipo() {
        this.tipo = tipo;
    }

    public int setCosto() {
        this.costo = costo;
    }
}