package cleancode.solid.isp.problem;

public class Steuermann {
    private Boot boot;
    private BootTyp bootTyp;

    public Steuermann(Boot boot, BootTyp bootTyp) {
        this.boot = boot;
        this.bootTyp = bootTyp;
    }

    public void steuern() {
        switch (bootTyp) {
            case Segelboot:
                boot.segeln();
                break;
            case RuderBoot:
                boot.rudern();
                break;
            default:
                break;
        }
    }
}
