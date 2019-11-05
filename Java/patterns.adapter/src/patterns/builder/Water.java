package patterns.builder;

public class Water extends ColdDrink {
	@Override
	public float price() {
		return 2.5f;
	}
	
	@Override
	public String name() {
		return "Water";
	}
}
