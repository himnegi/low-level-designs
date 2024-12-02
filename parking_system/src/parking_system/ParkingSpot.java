package parking_system;

public interface ParkingSpot {

	Vehicle getParkedVehicle();
	
	boolean isAvailable();
	
	void ParkVehicle(Vehicle parkedVehicle);

	void RemoveParkVehicle(Vehicle vehicle);
}
