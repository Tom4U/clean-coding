package cleancode.solid.isp.loesung1;

public class Demo {
    public static void main(String[] args) {
        Steuermann steuermann = new Steuermann(new Ruderboot());

        steuermann.rudern();
    }
}
