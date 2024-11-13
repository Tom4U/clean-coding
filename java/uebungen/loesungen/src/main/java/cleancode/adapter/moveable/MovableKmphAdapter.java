package cleancode.adapter.moveable;

public class MovableKmphAdapter implements Movable {
    private Movable car;

    public MovableKmphAdapter(Movable car) {
        this.car = car;
    }

    @Override
    public double getSpeed() {
        double mph = car.getSpeed();
        return convertMPHtoKMPH(mph);
    }

    private double convertMPHtoKMPH(double mph) {
        final double ratio = 1.60934;
        return mph * ratio;
    }

}
