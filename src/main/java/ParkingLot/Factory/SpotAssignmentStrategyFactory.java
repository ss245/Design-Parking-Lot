package ParkingLot.Factory;

import ParkingLot.Models.SpotAssignmentStrategyType;
import ParkingLot.Strategies.CheapestSpotAssignmentStrategy;
import ParkingLot.Strategies.NearestSpotAssignmentStrategy;
import ParkingLot.Strategies.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {
    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SpotAssignmentStrategyType spotAssignmentStrategyType){
        if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.Cheapest)){
            return new CheapestSpotAssignmentStrategy();
        }
        else if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.Nearest)){
            return new NearestSpotAssignmentStrategy();
        }
        else
            return null;
    }

}
