package parking_system;

public class Main {

	public static void main(String[] args) {

		Vehicle car1 = new carVehicle("xx112");
		Vehicle car2 = new carVehicle("xx113");
		Vehicle bike1 = new BikeVehicle("bb111");
		Vehicle bike2 = new BikeVehicle("bb112");
		ParkingLot lot = new ParkingLot(1, 2);

		lot.parkVehicle(car1);		
		lot.parkVehicle(car2);	
		lot.unParkVehicle(car1);	
		lot.parkVehicle(car2);	
		lot.unParkVehicle(bike2);		
	}

}
