package cleancode.codesmells.refusedbequest;

public class Auto {
    private Double tankstand = 50.0;
    private Integer geschwindigkeit = 0;

    public void fahren() {
        if (tankstand.equals(0.00)) {
            tanken();
        }

        setzeGeschwindigkeit(30);
    }

    protected void setzeGeschwindigkeit(Integer geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }
    
    protected void tanken() {
        tankstand = 50.0;
    }
}
