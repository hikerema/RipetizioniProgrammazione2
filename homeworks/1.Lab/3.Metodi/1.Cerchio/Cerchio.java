
public class Cerchio {
//OVERVIEW: legge da riga di comando un numero reale raggio
//          e stampa i valori di circonferenza e area di un cerchio di raggio r
    public static void main(String[] args) {
        if(args.length != 1) {
            System.err.println("Inserisci un solo valore");
            System.exit(1);;
        }
        double r = Double.parseDouble(args[0]);
        System.out.println("L'area del cerchio di raggio " + r + " è: " + CalcolaArea(r));
        System.out.println("La circonferenza del cerchio di raggio " + r + " è: " + CalcolaCirconferenza(r));

    }
    
    public static double CalcolaArea(double r) { //pi greco * r^2
        //EFFECTS: calcola resituisce l'area del cerchio di raggio r
            return Math.PI * Math.pow(r, 2);
        }
        
        public static double CalcolaCirconferenza(double r) { //2 pi greco *r
            //EFFECTS: calcola resituisce la circonferenza del cerchio di raggio r
            return 2 * Math.PI * r;
        }
}


