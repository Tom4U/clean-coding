package cleancode.adapter.moveable;

public class AstonMartin implements Movable {
    @Override
    public double getSpeed() {
        final int speed = 220;

        return speed;
    }
}
