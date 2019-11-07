package uebungen.adapter.moveable.solution;

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
        return mph * 1.60934;
    }

}
