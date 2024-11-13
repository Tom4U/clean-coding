package cleancode.solid.ocp.falsch;

public class Flaechenberechung {
    public double rechteckFlaecheBerechnen(Rechteck rechteck) {
        return rechteck.laenge * rechteck.breite;
    }

    public double kreisFlaecheBerechnen(Kreis kreis) {
        return (22 / 7) * kreis.radius * kreis.radius;
    }
}
