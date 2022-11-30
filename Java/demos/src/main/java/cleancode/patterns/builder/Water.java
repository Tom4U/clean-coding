package cleancode.patterns.builder;

public class Water extends ColdDrink {

    @Override
    public String name() {
        return "Water";
    }

    @Override
    public float price() {
        return 2.5f;
    }

}
