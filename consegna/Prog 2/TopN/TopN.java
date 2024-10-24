import java.util.Scanner;

public class TopN {
//OVERVIEW: trova N numeri più grandi
    
    public static int[] readIntArray() {
    //EFFECTS: legge una serie di num di almeno n int diversi tra loro e termina con CTRL + D
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci almeno 2 numeri interi diversi tra loro");
    }

    public static int[] highest(int[] numbers, int n) {
    //EFFECT: calcola e restituisce un array con gli n int più alti
        int max = 0;
        for (int i : numbers) {
            if (i > max)
                max = i;
        }
    }

    private static void printArray(int[] numbers) {
    //EFFECTS: stampa l'array ottenuto in highest
        
    }
    public static void main(String[] args) {
        
        System.out.println("Inserisci almeno 2 numeri interi diversi tra loro");
    }
}