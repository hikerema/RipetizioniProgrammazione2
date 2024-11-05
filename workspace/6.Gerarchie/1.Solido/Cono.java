public class Cono extends Solido {
//OVERVIEW: classe che estende Solido implementando i metodi raggio e altezza,
//          e definendo una appropriata rappresentazione del tipo.
    private double raggio;
    private double altezza;

    public Cono(double raggio, double altezza) {
        this.raggio = raggio;
        this.altezza = altezza;
    }

    public double getRaggio() {
        return this.raggio;
    }
    public double getAltezza() {
        return this.altezza;
    }

    @Override
    public String tipo() {    //sovrascrivo tipo
        return "Cono";
    }
    @Override
    public double volume() {    //sovrascrivo volume
        double r = getRaggio();
        double a = getAltezza();
        return (Math.PI*Math.pow(r, 2)*a)/3;
    }
}