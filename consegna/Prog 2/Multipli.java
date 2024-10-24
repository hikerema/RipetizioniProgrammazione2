public class Multipli {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Errore");
            System.exit(1);
        }
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        if (Multiplo(num1, num2)) {
            System.out.println(num1 + " è multiplo di " + num2);
        } else {
            System.out.println(num1 + " non è multiplo di " + num2);
        }

    }
    public static boolean Multiplo(int num1, int num2) {
        if (num1 % num2 == 0)
            return true;
        return false;
    }
}