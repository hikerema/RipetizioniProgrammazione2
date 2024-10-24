
public class Ricevimento {
    //la classe Ricevimento permette ai studenti di prenotare un appuntamento inserendo il proprio nome e scegliendo un orario compreso tra le 13 e le 18
    public static void prenota(String[] agenda, int ora, String nome) throws NullPointerException, AlreadyBookedException, TimeBusyException, IllegalArgumentException {
        //MODIFIES: agenda.
        //EFFECTS: se agenda = NULL lancia NullPointerException;
        //         se agenda.lenght != 6 lancia IllegalArgumentException;
        //         se nome = NULL || nome = "" lancia IllegalArgumentException, il programma non termina;
        //         se ora non valido lancia IllegalArgumentException, il programma non termina;
        //         se ora è già prenotato lancia TimeBusyException (eccezione Unchecked), il programma richiede l'appuntamento;
        //         se nome ha già prenotato un orario diverso lancia AlreadyBookException (eccezione Checked), il programma richiede l'appuntamento;
        //         modifica agenda assegnando orario a nome.
        if (agenda == null)
            throw new NullPointerException("L'agenda è nulla");
       
        if (agenda.length != 6) 
            throw new IllegalArgumentException("L'agenda non ha 6 elementi");
        System.out.println("arrivo3");
        if (nome == null || nome.equals(""))
            throw new IllegalArgumentException();
        
        if (ora < 13 || ora > 18)
            throw new IllegalArgumentException("Orario non valido");
        System.out.println("arrivo2");
        int[] orariDisp = orariDisponibili(agenda);
        boolean disponibile = false;
        for (int i = 0; i < orariDisp.length; i++) {
            if (orariDisp[i] == ora) {
                disponibile = true;
            }
            if (!disponibile)
                throw new TimeBusyException();
        }
        System.out.println("arrivo");

        for (String studente : agenda) {
            /*if (studente.equals(nome))
                throw new AlreadyBookedException();*/
        }
        System.out.println("pollo");

        agenda[ora-13] = nome;
    }
    public static int[] orariDisponibili(String[] agenda) throws NullPointerException, IllegalArgumentException {
        //EFFECTS: se agenda = NULL lancia NullPointerException;
        //         se agenda.lenght != 6 lancia IllegalArgumentException;
        //         restituisce gli orari disponibili.
        if (agenda == null)
            throw new NullPointerException("L'agenda è nulla");
        
        if (agenda.length != 6) 
            throw new IllegalArgumentException("L'agenda non ha 6 elementi");

        int count = 0;
        for (int i = 0; i < agenda.length; i++) {
            if(agenda[i] == null){
                count++;
            }
        }
        int[] orariDisp = new int[count];
        
        for (int i = 0, j = 0; i < orariDisp.length; i++) {
            if(agenda[i] == null)
                orariDisp[j++] = i+13;
        }
        return orariDisp;
    }
    
}