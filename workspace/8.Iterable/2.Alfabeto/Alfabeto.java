import java.util.Iterator;
import java.util.NoSuchElementException;

public class Alfabeto implements Iterator<Character> {
//OVERVIEW: Iteratore che restituisce una successiva lettera dell'alfabeto
//          la classe prevede un costruttore che accetta in ingresso la lettera iniziale e la lettera finale della sequenza
//          gestendo eventualmente le eccezioni

    private char current;
    private char end;

    public Alfabeto(char current, char end) {
    //MODIFIES: this
    //EFFECTS: se current > end lancia un IllegalArgumentException
    //         se current e end non sono lettere lancia un IllegalArgumentException
    //         altrimenti restituisce un alfabeto
        if (current > end)
            throw new IllegalArgumentException("la prima lettera è successiva alla seconda");
        if (!Character.isLetter(current) || !Character.isLetter(end))
            throw new IllegalArgumentException("oh ma si scemo... il valore non è valido");
        
        this.current = current;
        this.end = end;
    }

    @Override
    public boolean hasNext() {
    //EFFECTS: restituisce false se nCurrent > nEnd
    //         true altrimenti

        int nCurrent = current;
        int nEnd = end;

        if (nCurrent > nEnd)
            return false;
        return true;
    }

    @Override
    public Character next() {
    //EFFECTS: se !hasNext() lancia NoSuchElementException()
    //         altrimenti restituisce current

        if(!hasNext())
            throw new NoSuchElementException();
        int nCurrent = this.current;
        char c = (char)nCurrent;
        this.current = (char)++nCurrent;
        return c;
    }
    
    public static void main(String[] args) {
        char start = args[0].charAt(0);
        char end = args[1].charAt(0);
        try {
            Alfabeto Alfabeto = new Alfabeto(start, end);
            while(Alfabeto.hasNext()) {
                System.out.println(Alfabeto.next());
            }
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }

}