package patterns.adapter.demo2;

public class Driver {
	public static void main(String args[]) {
    	Movable astonMartin = new AstonMartin();
    	MovableAdapter astonMartinAdapter = new MovableAdapterImpl(astonMartin);
        System.out.println("Aston Martin top speed is " + astonMartinAdapter.getSpeed() + " Kmph.");
    }
}
