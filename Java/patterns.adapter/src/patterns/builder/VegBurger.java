package patterns.builder;

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
