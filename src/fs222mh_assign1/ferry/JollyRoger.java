package fs222mh_assign1.ferry;

import java.util.ArrayList;
import java.util.Iterator;

public class JollyRoger implements IntFerry {
	
	int totalMoney = 0;
	
	//ArrayLists to keep track of all the vehicles and passengers
	ArrayList<Vehicle> pVehicle = new ArrayList<>();
	ArrayList<Passenger> pPass = new ArrayList<>();

	@Override
	public int countPassengers() {
		int pSum = 0;									// Total nbr of passengers
		
		for (int i = 0; i < pPass.size(); i += 1) {		// Loopt through passengers without vehicle
			pSum += pPass.get(i).getPass();
		}
		
		for (int i = 0; i < pVehicle.size(); i += 1) {	// Loop through vehicles and their passengers
			pSum += pVehicle.get(i).getPass();
		}
		return pSum;
	}

	@Override
	public int countVehicleSpace() {
		int sizeSum = 0;								// Size of vehicles on ferry
		
		for (int i = 0; i < pVehicle.size(); i += 1) {	// Loop through the embarked vehicles
			sizeSum += pVehicle.get(i).getSize();
		}		
		return sizeSum;
	}

	@Override
	public int countMoney() {
		int sum = 0;
		
		for (int i = 0; i < pVehicle.size(); i += 1) {	// Loop through vehicles
			sum += pVehicle.get(i).getPrize();
		}
		
		for (int i = 0; i < pPass.size(); i += 1){		// Loop through passengers
			sum += pPass.get(i).getPrize();
		}
		return sum;
	}

	@Override
	public Iterator<Vehicle> iterator() {
		return null;
	}

	@Override
	public void embark(Vehicle v) {
		
		if (hasSpaceFor(v)) {
			pVehicle.add(v);
		} else {
			System.err.println("No room for more vehicles on the pirateship, ho ho ho! and a bottle of rom matey!");
		}
		
	}

	@Override
	public void embark(Passenger p) { 
		if (hasRoomFor(p)){
			pPass.add(p);
		} else {
			System.err.println("No room for more passengers, get lost matey!");
		}
		
	}

	@Override
	public void disembark() {		// Clear pPass and pVehicle, save the money
		totalMoney += countMoney();
		pPass.clear();
		pVehicle.clear();
		
	}

	@Override
	public boolean hasSpaceFor(Vehicle v) {
		
		if (v.getSize() + countVehicleSpace() <= 40){	// Check vehicle size and if current total vehicle size is below 40	
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean hasRoomFor(Passenger p) {
		if (countPassengers() <= 200) {	// Check numbers of passengers and if current total is below 200
			return true;		
		} else {
			return false;
		}
	}
	

}
