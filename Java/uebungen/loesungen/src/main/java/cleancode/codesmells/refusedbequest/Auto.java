package cleancode.codesmells.refusedbequest;

public class Auto extends Fahrzeug {
    private Double tankstand = 50.0;

    public void fahren() {
        if (tankstand.equals(0.00)) {
            tanken();
        }

        setzeGeschwindigkeit(30);
    }

    protected void tanken() {
        tankstand = 50.0;
    }
}
