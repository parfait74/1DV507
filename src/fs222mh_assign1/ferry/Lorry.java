package fs222mh_assign1.ferry;

public class Lorry extends Vehicle {
	
	private final int costPassenger = 15;
	private final int costVehicle = 300;
	private final int pMax = 2;			// a lorry are allowed a max of 2 passengers
	private final int vSize = 40;		// A lorry takes up the space as 8 cars or 40 bicycles.

	
	public Lorry(int p) {
		if (p > pMax){
			System.err.println("A car are allowed " + pMax + " passengers!");
		} else {
			setPass(p);
			setPrize(costVehicle + (costPassenger * p));
			setSize(vSize);
		}
	}

}
