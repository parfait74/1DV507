package fs222mh_assign1.ferry;

public class Passenger {
	
	private int nPass = 0;
	private int nPrize = 0;
	
	public Passenger(int p) {
		setPass(p);
		setPrize(p);
	}
	
	public void setPass(int p) {
		nPass = p;
	}
	
	public void setPrize(int p) {
		nPrize = 20 * p;				// prize is 20 per passenger without vehicle
	}
	
	public int getPass() {
		return nPass;
	}
	
	public int getPrize() {
		return nPrize;
	}

}
