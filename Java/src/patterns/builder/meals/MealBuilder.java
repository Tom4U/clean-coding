package patterns.builder.meals;

public class MealBuilder {
	private static MealBuilder instance;
	private Meal currentMeal;
	
	private MealBuilder() {}
	
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
	
	public MealBuilder chickenBurger() {
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
		System.out.println("Total cost: " + currentMeal.getCost());
	}
	
}
