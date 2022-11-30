package cleancode.adapter.moveable;

public class Driver {
    public static void main(String args[]) {
        Movable astonMartin = new AstonMartin();
        System.out.println("Aston Martin top speed is " + astonMartin.getSpeed() + " Mph.");
    }

}
