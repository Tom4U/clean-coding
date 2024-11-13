package cleancode.solid.ocp.richtig;

public class Rechteck implements Form {
    double laenge;
    double breite;

    public double flaecheBerechnen() {
        return laenge * breite;
    }
}
