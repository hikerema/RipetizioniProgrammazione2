public class TernePitagoriche {
//OVERWIRE: legge da riga di comando un intero soglia > 0
//          stampa tutte le terne pitagoriche tali che a<soglia, b<soglia e c<soglia
    public static boolean ternaPitagorica(int a, int b, int c) {
    //EFFECTS: restituisce true se c^2 = a^2 + b^2, false altrimenti
        if(Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2)) 
            return true;
        return false;
    }

    public static void main(String[] args) {
        if(args.length != 1) {
            System.err.println("Ci deve essere un solo numero intero soglia");
            System.exit(1);
        }

        int soglia = Integer.parseInt(args[0]);

        System.out.println("Terne Pitagoriche: ");
        for(int i = 1; i < soglia; i++) {
            for(int j = i; j < soglia; j++) {
                for(int l = j; l < soglia; l++) {
                    if(ternaPitagorica(i, j, l)) {
                        System.out.println("(" + i + ", " + j + ", " + l + ")");
                    }
                }
            }
        }
    }
}
