import java.util.Date;

public class Evento {
//OVERVIEWS: modelli un evento di un calendario, 
//           definito da una data specificata e dal suo nome (Evento(Date data, String nome)).
    private Date data;
    private String nome;

    public Evento(Date data, String nome) {
        this.data = data;
        this.nome = nome; 
    }

    public Date getData() {
        return data;
    }

    public String getNome() {
        return nome;
    }

    public Evento copiaEvento(int n) {
        data = getData();
        
    }
}