package fs222mh_assign1.ferry;

public class Vehicle {
	
	protected int prize = 0;	// prize to embark
	protected int size = 0;		// space for each vehicle
	protected int nPass = 0;	// nbr of passenger in vehicle
	
	protected void setPrize(int n) {
		prize = n;
	}
	
	protected void setPass(int n) {
		nPass = n;
	}
	
	protected void setSize(int n) {
		size = n;
	}
	
	protected int getPass() {
		return nPass;
	}
	
	protected int getPrize() {
		return prize;
	}
	
	protected int getSize() {
		return size;
	}

}
