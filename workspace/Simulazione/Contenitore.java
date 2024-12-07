

public abstract class Contenitore implements Comparable<Contenitore>{
//OVERVIEW: Un Contenitore può contenere una certa quantità di liquido,
//          fino alla sua massima capienza, pari al proprio volume.
//          Il liquido contenuto (se presente) è memorizzato con il suo nome
    public String nomeContenitore;
    public double maxCapienza;

    public String nomeLiquido;
    public double volumeLiquido;

    public Contenitore(String nomeContenitore, double maxCapienza, String nomeLiquido, double volumeLiquido) throws CapacityException {
        //EFFECTS: if maxCapienza <= 0 throw new IllegalArgumentiException
        //         if volumeLiquido > maxCapienza throw new CapacityException
        if(maxCapienza <= 0) {
            throw new IllegalArgumentException("La capienza del contenitore dev'essere > 0 ");
        }
        
        if(volumeLiquido > maxCapienza) {
            throw new CapacityException("Il volume del liquido è maggiore della capienza del contenitore");
        }
        this.nomeContenitore = nomeContenitore;
        this.maxCapienza = maxCapienza;

        this.nomeLiquido = nomeLiquido;
        this.volumeLiquido = volumeLiquido;
    }

    public String getNomeContenitore() {
        return nomeContenitore;
    }

    public double getMaxCapienza() {
        return maxCapienza;
    }

    public String getNomeLiquido() {
        return nomeLiquido;
    }

    public double getVolumeLiquido() {
        return volumeLiquido;
    }

    public void setVolumeLiquido(double volumeLiquido) {
        this.volumeLiquido = volumeLiquido;
    }

    public void versa(Contenitore c) {
    //MODIFIES: this, c
    //EFFECTS: versa il liquido nel contenitore più capiente
        double x = this.maxCapienza - this.volumeLiquido;
        double y = c.getVolumeLiquido();
        double r = x-y;
        if(r >= 0) {
            c.setVolumeLiquido(0);
            this.volumeLiquido = this.volumeLiquido + r;
        } else {
            this.volumeLiquido = this.maxCapienza;
            c.setVolumeLiquido(-r);
        }
    }

    @Override
    public int compareTo(Contenitore c) {
        if(this.getMaxCapienza() < c.getMaxCapienza()) 
            return 1;
        else if(this.getMaxCapienza() > c.getMaxCapienza())
            return -1;
        return 0;
    }
    
}