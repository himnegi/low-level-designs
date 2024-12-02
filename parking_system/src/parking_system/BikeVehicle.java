package parking_system;

public class BikeVehicle implements Vehicle {

	private String vehicleNo;

	public BikeVehicle(String vehicleNo) {
		super();
		this.vehicleNo = vehicleNo;

	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	@Override
	public String getVehicleTYpe() {
		return "BIKE";
	}

}
