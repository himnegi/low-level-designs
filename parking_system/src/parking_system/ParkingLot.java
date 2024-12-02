package parking_system;

import java.util.*;

public class ParkingLot {

	private int carParkingSlots;
	private int bikeParkingSlots;
	List<ParkingSpot> carParkingSpots;
	List<ParkingSpot> bikeParkingSpots;

	public ParkingLot(int carParkingSlots, int bikeParkingSlots) {
		super();
		carParkingSpots = new ArrayList<>();
		bikeParkingSpots = new ArrayList<>();
		for (int i = 0; i < carParkingSlots; i++) {
			carParkingSpots.add(new CarParkingSpot());
		}
		for (int i = 0; i < bikeParkingSlots; i++) {
			bikeParkingSpots.add(new BikeParkingSpot());
		}
	}

	public int getCarParkinglotS() {
		return carParkingSlots;
	}

	public int getbarParkinglotS() {
		return bikeParkingSlots;
	}

	public void parkVehicle(Vehicle vehicle) {
		List<ParkingSpot> spots = getParkingSpotsByVehicleType(vehicle);
		for (ParkingSpot spot : spots) {
			if (spot.isAvailable()) {
				spot.ParkVehicle(vehicle);
				System.out.println("vehicle parked successfully  vehicle type " + vehicle.getVehicleTYpe()
						+ " and vehicle no " + vehicle.getVehicleNo());
				return;
			}
		}
		System.out.println("No space available to park " + vehicle.getVehicleTYpe() + " with vehicle no "
				+ vehicle.getVehicleNo());
	}

	public void unParkVehicle(Vehicle vehicle) {
		List<ParkingSpot> spots = getParkingSpotsByVehicleType(vehicle);
		for (ParkingSpot spot : spots) {
			if (spot != null && spot.getParkedVehicle() != null
					&& vehicle.getVehicleNo().equals(spot.getParkedVehicle().getVehicleNo())) {
				spot.RemoveParkVehicle(vehicle);
				System.out.println("vehicle removed successfully  vehicle type " + vehicle.getVehicleTYpe()
						+ " and vehicle no " + vehicle.getVehicleNo());
				return;
			}
		}
		System.out.println("No vehicle is available to remove ");
	}

	private List<ParkingSpot> getParkingSpotsByVehicleType(Vehicle vehicleType) {
		return "CAR".equals(vehicleType.getVehicleTYpe()) ? carParkingSpots : bikeParkingSpots;
	}
}
