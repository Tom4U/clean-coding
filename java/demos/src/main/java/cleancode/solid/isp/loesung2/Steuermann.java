package cleancode.solid.isp.loesung2;

public class Steuermann {
    private Boot boot;

    public Steuermann(Boot boot) {
        this.boot = boot;
    }

    public void steuern() {
        boot.rudern();
    }
}
