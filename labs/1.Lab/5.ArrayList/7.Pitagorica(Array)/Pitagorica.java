public class Pitagorica {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[][] tavola = creaTavolaPitagorica(n);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", tavola[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] creaRigaPitagorica(int m, int n) {
        int[] riga = new int[n];
        for (int i = 0; i < n; i++) {
            riga[i] = (m + 1) * (i + 1);
        }
        return riga;
    }

    public static int[][] creaTavolaPitagorica(int n) {
        int[][] tavola = new int[n][n];
        for (int i = 0; i < n; i++) {
            tavola[i] = creaRigaPitagorica(i, n);
        }
        return tavola;
    }
}