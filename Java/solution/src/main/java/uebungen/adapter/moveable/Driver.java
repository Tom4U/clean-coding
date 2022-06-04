package uebungen.adapter.moveable;

public final class Driver {
    private Driver() {}

    public static void main(String[] args) {
        Movable astonMartin = new AstonMartin();
        MovableKmphAdapter astonMartinKmphAdapter = new MovableKmphAdapterImpl(astonMartin);

        System.out.println("Aston Martin top speed is " + astonMartinKmphAdapter.getSpeed() + " Kmph.");
        // System.out.println("Aston Martin top speed is " + astonMartin.getSpeed() + " Kmph.");
    }
}
