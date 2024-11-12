package cleancode.codesmells.refusedbequest;

public abstract class Fahrzeug {
    private Integer geschwindigkeit = 0;

    public abstract void fahren();

    protected void setzeGeschwindigkeit(Integer geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }
}
