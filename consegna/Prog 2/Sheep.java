import java.util.ArrayList;
import javax.swing.OverlayLayout;

public class Sheep implements Cloneable {
//OVERVIEW: modella una pecora con nome e dna (serie di stringhe)

//attributes
    private String nome;
    private ArrayList<String> dna;

//costruttori
    public Sheep(String nome, ArrayList<String> dna) throws IllegalArgumentException {
    //MODIFIES: this
    //EFFECTS: inizializza in this con nome e dna
    //         se nome null o vuoto lancia IllegalArgumentException
    //         se dna null o vuoto lancia IllegalArgumnetException
    //         se dna contiene stringhe vuote o null lancia IllegalArgumentException
        if (nome == null || nome == "")
            throw new IllegalArgumentException("nome null o vuoto");
        
        if (dna == null || dna.isEmpty())
            throw new IllegalArgumentException("dna null o vuoto");
        
        for (String s : dna) {
            if (s == null || s.equals(""))
                throw new IllegalArgumentException("cromosoma null o vuoto");
        }

        this.nome = nome;
        //creo una nuova arrayList il cui contenuto sarà un clone di dna (non è un operazione insicura)
        this.dna = new ArrayList<String>(dna);
    }

//metodi
    public String getChromosome(int i) throws IllegalArgumentException {
    //EFFECTS: restituisce cromosoma all'indice i
    //         se i va fuori dal range di cromosomi lancia IllegalArgumentException
        if (i < 0 || i > this.size())
            throw new IllegalArgumentException("i < 0 o > size");

        return dna.get(i);
    }

    public void replaceChromosome(int i, String c) throws IllegalArgumentException {
    //MODIFIES: this.
    //EFFECTS: sostituisce cromosoma all'indice i con c
    //         se c è vuota o null lancia IllegalArgumentException
    //         se i va fuori dal range di cromosomi lancia IllegalArgumentException
        if (i < 0 || i > this.size())
            throw new IllegalArgumentException("i < 0 o > size");
        
        return dna.get(i);
    }

    public String getNome() {
    //EFFECTS: restituisce nome
        return nome;
    }

    public int size() {
    //EFFECTS: restituisce numero di cromosomi di this
        return dna.size();
    }

    //possiamo cambiare il tipo di ritorno solo se restituiamo una roba più specifica
    @Override
    protected Sheep clone() {
        Sheep s = new Sheep(this.nome, this.dna);
        return s;
    }
    
    @Override //Clonable è una classe che ha dei metodi base, che però devono essere ancora implementati, infatti: 'implements Clonable' con @override stai sovrascrivento implememtando il metodo di quella claasse  
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;
        
        //controllo se obj è un istanza di Sheep o di una sottoistanza di Sheep
        if (!(obj instanceof Sheep))
            return false;

        //creo una Sheep(?) termporanea
        Sheep tmp = (Sheep) obj;

        if (!(tmp.nome.equals(this.nome)))
            return false;
        
        if (!(tmp.dna.equals(this.dna)))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Sheep " + this.nome + "\n" + this.dna;
    }
}