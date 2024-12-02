package parking_system;

public class carVehicle implements Vehicle {

	private String vehicleNo;

	public carVehicle(String vehicleNo) {
		super();
		this.vehicleNo = vehicleNo;

	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	@Override
	public String getVehicleTYpe() {
		return "CAR";
	}

}
