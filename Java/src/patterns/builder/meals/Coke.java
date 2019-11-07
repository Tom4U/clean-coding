package patterns.builder.meals;

public class Coke extends ColdDrink {
	@Override
	public float price() {
		return 2.5f;
	}
	
	@Override
	public String name() {
		return "Coke";
	}
}
