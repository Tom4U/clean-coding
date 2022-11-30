package cleancode.solid.isp.problem;

public class Demo {
    public static void main(String[] args) {
        Steuermann steuermann = new Steuermann(new Ruderboot(), BootTyp.RuderBoot);

        steuermann.steuern();
    }
}
