package cleancode.patterns.builder;

public class MealBuilder {

    private static MealBuilder instance;
    private Meal currentMeal;

    private MealBuilder() {
    }

    public static MealBuilder prepare() {
        instance = new MealBuilder();
        instance.currentMeal = new Meal();
        return instance;
    }

    public MealBuilder with() {
        return this;
    }

    public MealBuilder and() {
        return this;
    }

    public MealBuilder vegBurger() {
        currentMeal.addItem(new VegBurger());
        return this;
    }

    public MealBuilder meatBurger() {
        currentMeal.addItem(new ChickenBurger());
        return this;
    }

    public MealBuilder coke() {
        currentMeal.addItem(new Coke());
        return this;
    }

    public MealBuilder water() {
        currentMeal.addItem(new Water());
        return this;
    }

    public void showTotalCosts() {
        currentMeal.showItems();
        System.out.println("Total: " + currentMeal.getCost());
    }

    /*
     *
     * public Meal prepareVegMeal() {
     * Meal meal = new Meal();
     * meal.addItem(new VegBurger());
     * meal.addItem(new Water());
     *
     * return meal;
     * }
     *
     * public Meal prepareMeatMeal() {
     * Meal meal = new Meal();
     * meal.addItem(new ChickenBurger());
     * meal.addItem(new Coke());
     *
     * return meal;
     * }
     */
}
