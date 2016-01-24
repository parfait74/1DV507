package fs222mh_assign1.ferry;

public class Bicycle extends Vehicle{
	
	private final int costPass = 0;		// Passenger included in cost for bicycle
	private final int costVehicle = 40;	// Cost for the bicycle to embark the ferry
	private final int pMax = 1;			// Max number of passengers
	private final int vSize = 1/5;		// Size of bicycle, 1/5 of a car
	
	public Bicycle(int p) {
		if (p > pMax) {
			System.err.println("Argh, a bicycle can only hold " + pMax + " passenger!");
		} else {
			setPass(p);
			setPrize(costVehicle + (costPass * p));
			setSize(vSize);
		}
	}

}
