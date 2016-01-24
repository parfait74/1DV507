package fs222mh_assign1.ferry;

public class Bus extends Vehicle{
	
	private final int costPassenger = 10;
	private final int costVehicle = 200;
	private final int pMax = 20;			// a buss are allowed a max of 20 passengers
	private final int vSize = 4;		// A bus takes up the space as 4 cars.

	
	public Bus(int p) {
		if (p > pMax){
			System.err.println("A bus are allowed " + pMax + " passengers!");
		} else {
			setPass(p);
			setPrize(costVehicle + (costPassenger * p));
			setSize(vSize);
		}
	}

}
