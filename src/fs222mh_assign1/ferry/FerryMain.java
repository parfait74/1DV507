package fs222mh_assign1.ferry;

import java.util.Scanner;

public class FerryMain {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		JollyRoger ferry = new JollyRoger();
		
		// setup to make it easier to add different items (vehicles and passengers)
		int val = 0;
		int pVal = 0;
		
		boolean loop = true;					// set to true initially to start the loop, not 100% sure it's the best way
		while (loop == true) {
			System.out.println("Choose what you want to do: \n1: Embark Vehicle \n2: Embark passenger only \n3: Disembark \n4: Show me the money! \n5: abort");
			System.out.print("Your Choice: ");
			val = input.nextInt();
			switch (val) {
			case 1:
				System.out.println("Choose your vehicle: \n1: Car \n2: Lorry \n3: Bus \n4: Bicycle");
				System.out.print("Your Choice: ");
				val = input.nextInt();
				switch (val){
				case 1:
					System.out.println("How many passenger in the car?");
					System.out.print("Your answer: ");
					pVal = input.nextInt();
					Car volvo = new Car(pVal);
					ferry.embark(volvo);
					System.out.println("Number of passengers on ferry: " + ferry.countPassengers());
					System.out.println("Space occupied by vehicles: " + ferry.countVehicleSpace() +"\n");
					break;
					
				case 2:
					System.out.println("How many passenger in the Lorry?");
					System.out.print("Your answer: ");
					pVal = input.nextInt();
					Lorry scania = new Lorry(pVal);
					ferry.embark(scania);
					System.out.println("Number of passengers on ferry: " + ferry.countPassengers());
					System.out.println("Space occupied by vehicles: " + ferry.countVehicleSpace() + "\n");
					break;
					
				case 3:
					System.out.println("How many passenger in the bus?");
					System.out.print("Your answer: ");
					pVal = input.nextInt();
					Bus sl = new Bus(pVal);
					ferry.embark(sl);
					System.out.println("Number of passengers on ferry: " + ferry.countPassengers());
					System.out.println("Space occupied by vehicles: " + ferry.countVehicleSpace() + "\n");
					break;
					
				case 4:
					System.out.println("How many passenger on the bicycle?");
					System.out.print("Your answer: ");
					pVal = input.nextInt();
					Bicycle rex = new Bicycle(pVal);
					ferry.embark(rex);
					System.out.println("Number of passengers on ferry: " + ferry.countPassengers());
					System.out.println("Space occupied by vehicles: " + ferry.countVehicleSpace() + "\n");
					break;
					
				default:
					System.err.println("You have chosen wrong, please choose accordingly!");
					break;						
				}
				break;
			case 2:
				System.out.println("How many passenger do you wish to embark?");
				System.out.print("Your choice: ");
				pVal = input.nextInt();
				Passenger pass = new Passenger(pVal);
				ferry.embark(pass);
				System.out.println("Number of passengers on ferry: " + ferry.countPassengers() + "\n");
				break;
			
			case 3:
				ferry.disembark();
				System.out.println("Number of passengers on ferry: " + ferry.countPassengers());
				System.out.println("Space occupied by vehicles: " + ferry.countVehicleSpace() + "\n");
				break;
				
			case 4: // Splitting so you can get the total money earned and the money for the trip in progress
				System.out.println("Choose : \n1: Money for this trip \n2: Total money after completed disembarkments");
				System.out.print("Your Choice: ");
				val = input.nextInt();
				switch (val){
				case 1:
					System.out.println("Money earned this ferry: " + ferry.countMoney() + "\n");
					break;
					
				case 2:
					System.out.println("Money earned in total after completed disembarkments: " + ferry.totalMoney + "\n");
					break;
				}
				break;
								
			case 5: // Need to have a way to break the loop manually
				loop = false;
				System.out.print("Program has been aborted by user!");
				

			}
		}
		

		input.close();
	}	

}
