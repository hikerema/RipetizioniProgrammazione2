

public class Primi {
//OVERVIEW: legge da riga di comando un numero intero soglia
//          stampa tutti i numeri primi inferiori a soglia
//          if soglia <= 0 stampa che la soglia inserita non è positiva
    public static boolean primo(int n) {
    //EFFECTS: resituisce true se n è primo, altrimenti false
        for(int i = 2; i < n; i++) {
            if(n % i == 0) 
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        if(args.length != 1) {
            System.err.println("Devi inserire un solo numero intero");
            System.exit(1);
        }

        int s = Integer.parseInt(args[0]);
        if(s <= 0){
            System.out.println("La soglia inserita non è positiva");
        } else {
            System.out.println("Numeri primi inferiori a " + s + ": ");
            for(int i = 2; i < s; i++) {
                if(primo(i))
                    System.out.print(i + " ");
            }
        }

    }
}
