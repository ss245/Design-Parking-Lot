package ParkingLot;

import ParkingLot.Controllers.TicketController;
import ParkingLot.Dtos.IssueTicketRequestDto;
import ParkingLot.Dtos.IssueTicketResponseDto;
import ParkingLot.Dtos.ResponseStatus;
import ParkingLot.Models.Ticket;
import ParkingLot.Repositories.GateRepository;
import ParkingLot.Repositories.ParkingLotRepository;
import ParkingLot.Repositories.TicketRepository;
import ParkingLot.Repositories.VehicleRepository;
import ParkingLot.Services.TicketService;

public class Client {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();

        TicketService ticketService = new TicketService(gateRepository,
                vehicleRepository,
                parkingLotRepository,
                ticketRepository);

        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequestDto issueTicketRequestDto = new IssueTicketRequestDto();
        IssueTicketResponseDto issueTicketResponseDto = ticketController.issueTicket(issueTicketRequestDto);

        if(issueTicketResponseDto.getResponseStatus().equals(ResponseStatus.Success)){
            Ticket ticket = issueTicketResponseDto.getTicket();
        }
        else{
            // throw an exception
        }
    }
}
