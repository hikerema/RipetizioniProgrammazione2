public class Sfera extends Contenitore{
//OVERVIEW: Un contenitore sfera definita dal suo raggio
//          e che calcola il proprio volume massimo come PI * r^3 * 4/3
    public double raggio;

    public Sfera(String nomeContenitore, double maxCapienza, double raggio, String nomeLiquido, double volumeLiquido) throws CapacityException{
    //EFFECTS: if raggio <= 0 throw new IllegalArgumentException
        super(nomeContenitore, maxCapienza, nomeLiquido, volumeLiquido);
        if(raggio <= 0 ) {
            throw new IllegalArgumentException("Raggio <= 0");
        }
     
        volumeLiquido = Math.PI * Math.pow(raggio, 3) * 4/3;
        this.raggio = raggio;
        
    }

    @Override
    public String toString() {
        return String.format("Sfera - raggio: %.2f %s", raggio, super.toString());
    }

    @Override
    public int compareTo(Contenitore o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
