package parking_system;

public class BikeParkingSpot implements ParkingSpot {

	private Vehicle parkedVehicle;

	BikeParkingSpot(Vehicle parkedVehicle) {
		this.parkedVehicle = parkedVehicle;
	}

	public BikeParkingSpot() {
		// TODO Auto-generated constructor stub
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
		this.parkedVehicle=null;
	}

}
