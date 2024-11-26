



public class Radice {
//OVERVIEW: la classe stampa il valore della radice quadrata di un numero n inserito da riga di comando
//          solo se n > 0, altrimenti stampa un messaggio di errore
    public static double radiceQuadrata(double n) {
        //EFFECTS: calcola e restituisce la radice quadrata di n
        //         solo se n > 0, altrimenti resituisce 0
        if(n>0)
            return Math.sqrt(n);
        return 0;
    }

    public static void main(String[] args) {
        if(args.length != 1) {
            System.err.println("Devi inserire un solo numero");
            System.exit(1);
        }

        double n = Double.parseDouble(args[0]);
        double radice = radiceQuadrata(n);
        if(radice != 0) {
            if(n == (int)n) {
                if(radice == (int)radice)
                    System.out.println("La radice quadrata di " + (int)n + " è: " + (int)radice);
                else
                    System.out.println("La radice quadrata di " + (int)n + " è: " + radice);
            } else if(radice == (int)radice) 
                System.out.println("La radice quadrata di " + n + " è: " + (int)radice);
            else
                System.out.println("La radice quadrata di " + n + " è: " + radiceQuadrata(n));

        } else
            System.out.println("Il valore inserito non appartiene al dominio della funzione");
    }

}
