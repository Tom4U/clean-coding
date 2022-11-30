package cleancode.codesmells.refusedbequest;

public class Fahrrad extends Fahrzeug{
    @Override
    public void fahren() {
        setzeGeschwindigkeit(10);
    }
}
