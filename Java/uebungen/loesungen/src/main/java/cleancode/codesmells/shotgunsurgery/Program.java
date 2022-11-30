package cleancode.codesmells.shotgunsurgery;

public class Program {
    public static void main(String[] args) throws Exception {
        Konto konto = new Konto("Personal", "KT123456", 1000);
        konto.abheben(500);
        konto.warnungSenden();
        konto.abheben(500);
    }
}
