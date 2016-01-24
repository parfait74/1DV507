package fs222mh_assign1.ferry;

public class Car extends Vehicle{
	
	private final int costPassenger = 15;
	private final int costVehicle = 100;
	private final int pMax = 4;			// a car are allowed a max of 4 passengers
	private final int vSize = 1;		// A car takes up the space as 1 car.

	
	public Car(int p) {
		if (p > pMax){
			System.err.println("A car are allowed " + pMax + " passengers!");
		} else {
			setPass(p);
			setPrize(costVehicle + (costPassenger * p));
			setSize(vSize);
		}
	}
}
