public class Perfetti {
//OVERVIEW: legge da riga di comando un numero intero n e stampa se n è perfetto o no

    public static int sommaDivisoriPropri(int n) {
    //EFFECTS: restituisce la somma dei divisori propri di n
    //         se n non ha divisori propri restituisce 0
        int somma = 0;
        for(int i = 1; i < n; i++) {
            if(n % i == 0) {
                somma += i;
            }
        }
        return somma;
    }

    public  static boolean perfetto(int n) {
    //EFFECTS: restituisce true se n è perfetto, false altrimenti  
        if(sommaDivisoriPropri(n) != 0) {
            if(n == sommaDivisoriPropri(n))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        if(args.length != 1) {
            System.err.println("Devi inserire solo un numero intero");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        if((perfetto(n)))
            System.out.println(n + " è perfetto");
        else
            System.out.println(n + " non è perfetto");
    }
}
