package cleancode.solid.ocp.richtig;

public class Kreis implements Form {
    double radius;

    public double flaecheBerechnen() {
        return (22 / 7) * radius * radius;
    }
}
