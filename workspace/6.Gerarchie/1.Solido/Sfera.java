public class Sfera extends Solido {
//OVERVIEW: classe che estende Solido implementando i metodi raggio e circonferenza,
//          e definendo una appropriata rappresentazione del tipo.
    private double raggio;  //struttura dati della sfera

    public Sfera(double raggio) {   //costruttore
        this.raggio = raggio;
    }

    public double getRaggio() {    //metodo restituisce raggio
        return this.raggio;
    }

    public double circonferenza() {
        double r = getRaggio();
        return 2*r*Math.PI;
    } 

    @Override
    public String tipo() {    //sovrascrivo tipo
        return "Sfera";
    }
    @Override
    public double volume() {    //sovrascrivo volume
        double r = getRaggio();
        return (4/3)*Math.pow(r, 3)*Math.PI;
    }

    
}