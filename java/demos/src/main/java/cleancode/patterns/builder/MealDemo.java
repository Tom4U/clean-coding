package cleancode.patterns.builder;

public class MealDemo {
    public static void main(String[] args) {

        MealBuilder.prepare().vegBurger().with().water().and().meatBurger().with().coke().and().showTotalCosts();

        /*
         * MealBuilder mb = new MealBuilder();
         *
         * Meal vegMeal = mb.prepareVegMeal();
         *
         * System.out.println("Veg Meal");
         * vegMeal.showItems();
         * System.out.println("Meal Total");
         * vegMeal.getCost();
         *
         * Meal meatMeal = mb.prepareMeatMeal();
         *
         * System.out.println("Meat Meal");
         * meatMeal.showItems();
         * System.out.println("Meal Total:" + meatMeal.getCost());
         *
         */

    }
}
