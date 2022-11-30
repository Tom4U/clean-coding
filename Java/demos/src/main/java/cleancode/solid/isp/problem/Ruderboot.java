package cleancode.solid.isp.problem;

public class Ruderboot implements Boot {
    @Override
    public void rudern() {
        System.out.println("Ahoi!");
    }

    @Override
    public void segeln() {
        rudern();
    }
}
