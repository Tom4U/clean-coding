package cleancode.solid.isp.problem;

public class Segelboot implements Boot {

    @Override
    public void rudern() {
        segeln();
    }

    @Override
    public void segeln() {
        System.out.println("Segel setzen");
    }

}
