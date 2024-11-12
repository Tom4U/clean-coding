package cleancode.solid.isp.loesung1;

public class Steuermann {
    private RuderndesBoot boot;

    public Steuermann(RuderndesBoot boot) {
        this.boot = boot;
    }

    public void rudern() {
        boot.rudern();
    }
}
