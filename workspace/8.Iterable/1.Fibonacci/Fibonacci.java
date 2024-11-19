import java.util.Iterator;

public class Fibonacci implements Iterator<Integer> { //cos'è un Interator?
//OVERVIEW: Iterator che genera i numeri della sequenza di Fibonacci
//          un numero di Fibonacci è la somma dei due num procedenti della sequenza (parte da 0, 1)
    
    //in questo caso non ci serve un costruttore
    private int p1 = 0, p2 = 0; // 0,0 se primo elemento, 0, 1 se secondo e cosi via (fase iniziale)
    //assumiamo che sarà restituito p1, se p1 = 0, sarà restituito 0, e p1 sarà settato a 1
    //da li in poi si segue la sequenza

    
    @Override
    public boolean hasNext() { //restituisce true se c'è un prossimo numero nella sequenza
        return true;
    }

    @Override
    public Integer next() { //restituisce il prossimo numero nella sequenza oppure lancio un eccezione quando non ci sono nuovi elementi ma la sequenza è infinita
        if(p1 == 0)
            return ++p1;
        //se non volessi questo if posso inizializzare p2 direttamente a 1 e funziona uguale
        int sum = p1 + p2;

        this.p2 = this.p1;
        this.p1 = sum;

        return sum;
    }

    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]); //legge un numero da riga di comando

        Fibonacci f = new Fibonacci();  //nuovo Iteratore
        for (int i = 0; i < n; i++) {
            System.out.println(f.next());
        }
    }
}