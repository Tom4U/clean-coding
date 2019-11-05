package patterns.builder;

public class MealDemo {
	public static void main(String[] args) {
		MealBuilder.prepare().chickenBurger().with().water().and().coke().and().showTotalCosts();
	}
}
