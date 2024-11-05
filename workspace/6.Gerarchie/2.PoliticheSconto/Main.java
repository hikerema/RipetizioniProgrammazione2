public class Main {
    public static void main(String[] args) {
        PoliticaSconto sconto1 = new ScontoQuantita(10, 10, 5, 10);
        PoliticaSconto sconto2 = new UnoOgniNGratis(10, 10, 3);
        PoliticaSconto sconto3 = new ScontoCombinato(10, 10, sconto1, sconto2);
        System.out.println(sconto1.calcolaSconto());
        System.out.println(sconto2.calcolaSconto());
        System.out.println(sconto3.calcolaSconto());
    }
}
