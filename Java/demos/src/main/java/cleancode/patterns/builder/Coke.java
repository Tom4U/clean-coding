package cleancode.patterns.builder;

public class Coke extends ColdDrink {

    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 2.5f;
    }

}
