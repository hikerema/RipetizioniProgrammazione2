import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Pretendenti implements Iterable<Integer>{
//OVERVIEW: modella il meccanismo di selezione dei pretendenti di Eva

    ArrayList<Integer> pretendenti = new ArrayList<>();

    public Pretendenti(int n) throws IllegalArgumentException{
    //MODIFIES: this
    //EFFECTS: inizializza this con n pretendenti
    //         if n <= 0 throw IllegalArgumentException
        if (n <= 0)
            throw new IllegalArgumentException("n <= 0");

        for (int i = 1; i <= n; i++) {
            pretendenti.add(i);
        }
        assert repOk();
    }

    private boolean repOk() {
        if (pretendenti.isEmpty())
            return false;
        
        for (Integer i : pretendenti)
            if (i == null || i <= 0 || pretendenti.indexOf(i) != pretendenti.lastIndexOf(i)) // l'ultimo controlla se ci sono due pretendenti con lo stesso numero
                return false;
            
            return true;

    }

    public int getVincitore() throws StillCountingException {
    //EFFECTS: restituisce il vincitore
    //         se pretendenti.size() != 1 lancia StillCountingException
        if (pretendenti.size() != 1)
            throw new StillCountingException("Ancora in corso");
        return pretendenti.get(0);
    }

    @Override
    public String toString() {
        String ret = "Pretendenti: ";
        for (Integer p : pretendenti) {
            ret += p + " ";
        }
        return ret;
    }

    @Override
    public Iterator<Integer> iterator() { //restituisco una nuova istanza di iterator integer che è definito li sul momento
    //MODIFIES: this.pretendenti
    //EFFECTS: restituisce un iteratore che seleziona un nuovo pretendente a distanza 3 dall'ultimo
    //         se si arriva in fondo si cambia direzione. L'iterazione procede finchè non ne rimane 1

        return new Iterator<Integer>() {

            int current = 0;
            boolean dir = true; // direzione -> true = verso coda, false = verso capo;
            boolean removed = true; //se true non posso chiamare remove

            @Override
            public boolean hasNext() {
                if (Pretendenti.this.pretendenti.size() > 1)
                    return true;
                
                return false;
            }

            @Override
            public Integer next() {
                if(!hasNext())
                    throw new NoSuchElementException("Finito pretendenti");
                
                if(dir)
                    current += 2;
                else
                    current -= 2;
                
                if(current > pretendenti.size()-1) {
                    dir = false;
                    current = 2*(pretendenti.size()-1) - current;
                }

                if (current <= 0) {
                    dir = true;
                    current = -this.current; //se mi trovo al -2 non è possibile, mi dovevo trovare al 2
                }

                removed = false;

                return pretendenti.get(current); //restituisce l'indice del pretendente
            }

            @Override
            public void remove() {
                if(removed)
                    throw new IllegalArgumentException("cannot call remove before next");
                
                removed = true;

                pretendenti.remove(current);

                if(!dir)
                    current--;

                if(current > pretendenti.size()-1) //se supera l'ultimo indice
                    current--;

                if(current == pretendenti.size()-1)
                    dir = false;

                if(current == 0)
                    dir = true;

                assert repOk();
            }

            @Override
            public String toString() {
                if(dir)
                    return "direzione: " + current + " (" + pretendenti.get(current) + ") direzione avanti";
                else
                    return "direzione: " + current + " (" + pretendenti.get(current) + ") direzione dietro";
            }
            
        };
    }
    public static void main(String[] args) {
        Pretendenti p = new Pretendenti(10);

        System.out.println(p);

        Iterator<Integer> i = p.iterator();

        while(i.hasNext()) {
            System.out.println(p);
            System.out.println(i);
            System.out.println(i.next());
            i.remove();
        }
    }
}