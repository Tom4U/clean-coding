package cleancode.solid.isp.loesung2;

public class SegelbootAdapter implements Boot {
    Segelboot boot;

    public SegelbootAdapter(Segelboot boot) {
        this.boot = boot;
    }

    @Override
    public void rudern() {
        boot.segeln();
    }

}
