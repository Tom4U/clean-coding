package cleancode.solid.isp.loesung2;

public class Demo {
    public static void main(String[] args) {
        Steuermann steuermann = new Steuermann(new SegelbootAdapter(new Segelboot()));

        steuermann.steuern();
    }
}
