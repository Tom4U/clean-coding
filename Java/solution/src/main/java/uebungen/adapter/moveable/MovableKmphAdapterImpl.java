package uebungen.adapter.moveable;

public class MovableKmphAdapterImpl implements MovableKmphAdapter {
    private Movable car;

    public MovableKmphAdapterImpl(Movable car) {
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
