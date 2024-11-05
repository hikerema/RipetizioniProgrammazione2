public abstract class Solido implements Comparable<Solido>{
//OVERVIEW: classe astratta che utilizza i metodi string tipo() per restituire il tipo del solido
//          e double volume() per restituire il volume del solido,
//          implementa l'interfaccia Comparable, in cui il metodo compareTo(Solido s)
//          restituirà -1 se this ha un volume minore di s, 0 se il volume dei due è uguale,
//          e 1 se this ha un volume maggiore.
    public abstract String tipo(); //metodo astratto
    public abstract double volume(); //metodo astratto

    @Override
    public int compareTo(Solido s) {    //sovrascrivo compareTo
        if (this.volume() < s.volume())
            return -1;
        if (this.volume() == s.volume())
            return 0;
        else
            return 1;
    }
}