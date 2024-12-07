public final class Cilindro extends Contenitore{
//OVERVIEW: Un contenitore cilidro definito dal suo raggio r e altezza h
//          e che calcola il proprio volume massimo come h * PI * r^2
    public double raggio;
    public double altezza;

    public Cilindro(String nomeContenitore, double maxCapienza, double raggio, double altezza, String nomeLiquido, double volumeLiquido) throws CapacityException{
    //EFFECTS: if raggio <= 0 oppure altezza <= 0 throw new IllegalArgumentException
        super(nomeContenitore, maxCapienza, nomeLiquido, volumeLiquido);
        if(raggio <= 0 || altezza <= 0) {
            throw new IllegalArgumentException("Raggio e/o altezza <= 0");
        }
     
        volumeLiquido = altezza * Math.PI * Math.pow(raggio, 2);
        this.raggio = raggio;
        this.altezza = altezza;
        
    }


    @Override
    public String toString() {
        return String.format("Cilindro - altezza: %.2f, raggio: %.2f %s", altezza, raggio, super.toString());
    }

    @Override
    public int compareTo(Contenitore o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
