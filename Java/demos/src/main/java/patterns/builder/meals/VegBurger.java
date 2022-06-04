package patterns.builder.meals;

public class VegBurger extends Burger {
	@Override
	public float price() {
		return 5.5f;
	}
	
	@Override
	public String name() {
		return "Veggie Burger";
	}
}
