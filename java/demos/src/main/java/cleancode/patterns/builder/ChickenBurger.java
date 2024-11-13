package cleancode.patterns.builder;

public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 6.5f;
    }

    @Override
    public String name() {
        return "ChickenBurger";
    }
}
