package demos.metrics.lcom;

public class LcomDemo {
	private int a;
	private int b;
	private int c;
	
	public void calc1() {
		c = a + 1;
	}
	
	public void calc2() {
		c = b + 5;
	}
	
	public void calc3() {
		a = 5;
	}
	
	public int getA() {
		return a;
	}
	
	public int getB() {
		return b;
	}
	
	public int getC() {
		return c;
	}
}
