package parking_system;

public class CarParkingSpot implements ParkingSpot {

	private Vehicle parkedVehicle;

	CarParkingSpot() {
	}

	CarParkingSpot(Vehicle parkedVehicle) {
		this.parkedVehicle = parkedVehicle;
	}

	@Override
	public Vehicle getParkedVehicle() {
		return parkedVehicle;
	}

	@Override
	public boolean isAvailable() {
		if (this.parkedVehicle == null)
			return true;

		return false;
	}

	@Override
	public void ParkVehicle(Vehicle parkedVehicle) {
		this.parkedVehicle=parkedVehicle;
		
	}

	@Override
	public void RemoveParkVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		
	}

}
