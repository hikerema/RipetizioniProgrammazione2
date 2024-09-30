public class Medie {
    public static void main(String[] args) {
        double somma = 0;
        int count = 0;

        for (String arg : args) {
            double numero = Double.parseDouble(arg);
            if (numero > 0) {
                somma += numero;
                count++;
            }
        }

        if (count > 0) {
            double media = somma / count;
            System.out.println("Media aritmetica: " + media);
        } else {
            System.out.println("Nessun numero positivo inserito.");
        }
    }
}