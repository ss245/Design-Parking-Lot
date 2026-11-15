package ParkingLot.Strategies;

import ParkingLot.Models.Gate;
import ParkingLot.Models.ParkingSpot;
import ParkingLot.Models.Vehicle;
import ParkingLot.Models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(VehicleType vehicleType,
                           Gate gate);
}
