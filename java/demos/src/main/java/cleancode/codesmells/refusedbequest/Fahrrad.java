package cleancode.codesmells.refusedbequest;

public class Fahrrad extends Auto {
    @Override
    public void fahren() {
        setzeGeschwindigkeit(10);
    }
}
