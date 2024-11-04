
public class Punto {
//OVERVIEW: modella un punto immutabile con coordinate decimali x e y.
//          crea un nuovo punto con coordinate x e y date,
//          restituisce le proprie coordinate x e y,
//          calcola la distanza con un altro punto,
//          genera un nuovo punto con uno scostamento x e y dato.
    private double x, y;

    public Punto(double x, double y) { //costruttore
    //REQUIRES: x e y != null.
    //MODIFIES: this.
    //EFFECTS: crea un nuovo Punto con coordinate x e y.
        this.x = x;
        this.y = y;
    }

    public Punto Scostamento(double x, double y) { //metodo
    //REQUIRES: x e y != null.
    //EFFECTS: crea un nuovo Punto con coordinate scostate di x e y.
        x = this.x + x;
        y = this.y + y;
        return new Punto(x, y);
    }

    public double getX() {  //metodo getter
    //EFFECTS: restituisce la coordinata x.
        return this.x;
    }
    public double getY() {  //metodo getter
    //EFFECTS: restituisce la coordinata y.
        return this.y;
    }

    public double Distanza(Punto p) { //metodo
    //EFFECTS: calcola la distanza tra due punti.
        double d = Math.sqrt(Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y), 2));
        return d;
    }
    
    @Override
    public String toString() {
        return "Punto: x = " + this.x + " y = " + this.y;
    }
}