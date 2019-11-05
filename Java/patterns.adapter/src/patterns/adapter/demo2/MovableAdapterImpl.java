package patterns.adapter.demo2;

public class MovableAdapterImpl implements MovableAdapter {
	private Movable car;
    
    public MovableAdapterImpl(Movable car) {
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
