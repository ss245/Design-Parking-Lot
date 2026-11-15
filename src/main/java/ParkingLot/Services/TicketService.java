package ParkingLot.Services;

import ParkingLot.Exceptions.GateNotFoundException;
import ParkingLot.Factory.SpotAssignmentStrategyFactory;
import ParkingLot.Models.*;
import ParkingLot.Repositories.GateRepository;
import ParkingLot.Repositories.ParkingLotRepository;
import ParkingLot.Repositories.TicketRepository;
import ParkingLot.Repositories.VehicleRepository;
import ParkingLot.Strategies.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;
    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository){
        this.gateRepository=gateRepository;
        this.vehicleRepository=vehicleRepository;
        this.parkingLotRepository=parkingLotRepository;
        this.ticketRepository=ticketRepository;
    }
    public Ticket issueTicket(Long gateId,
                              String vehicleNo,
                              String vehicleOwner,
                              Operator operator) throws GateNotFoundException {
        Ticket ticket = new Ticket();
        // set the current time to the ticket
        ticket.setCreatedAt(new Date());
        // Get the Gate object from the memory or database using gateId
        Optional<Gate> Optionalgate = gateRepository.findGateById(gateId);
        if(Optionalgate.isEmpty()){
            throw new GateNotFoundException();
        }
        Gate gate = Optionalgate.get();
        ticket.setGeneratedAt(gate);
        ticket.setOperator(gate.getOperator());

        // Get the vehicle with the vehicleNo, if present else create the vehicle object
        Optional<Vehicle>  optionalVehicle = vehicleRepository.findVehicleByNo(vehicleNo);
        Vehicle savedVehicle;
        if(optionalVehicle.isEmpty()){
            // return vehicle not found exception
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNo(vehicleNo);
            vehicle.setOwnerName(vehicleOwner);
            vehicleRepository.save();
            savedVehicle=vehicle;
        }
        else{
            savedVehicle=optionalVehicle.get();
        }
        ticket.setVehicle(savedVehicle);
        ParkingLot parkingLot = parkingLotRepository.getParkingLot();
        SpotAssignmentStrategyType spotAssignmentStrategyType = parkingLot.getSpotAssignmentStrategy();

        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.getSpotAssignmentStrategy(spotAssignmentStrategyType);
        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(savedVehicle.getVehicleType(),gate);
        ticket.setParkingSpot(parkingSpot);
        ticket.setTicketNo("Ticket  "+gateId);
        ticketRepository.save(ticket);
        return ticket;
    }
}
