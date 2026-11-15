package ParkingLot.Controllers;

import ParkingLot.Dtos.IssueTicketRequestDto;
import ParkingLot.Dtos.IssueTicketResponseDto;
import ParkingLot.Dtos.ResponseStatus;
import ParkingLot.Models.Ticket;
import ParkingLot.Services.TicketService;

public class TicketController {

    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }
    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto){
        IssueTicketResponseDto issueTicketResponseDto = new IssueTicketResponseDto();
        try {
            Ticket ticket = ticketService.issueTicket(issueTicketRequestDto.getGateId(),
                    issueTicketRequestDto.getVehicleNo(),
                    issueTicketRequestDto.getVehicleOwner(),
                    issueTicketRequestDto.getOperator());

            issueTicketResponseDto.setTicket(ticket);
            issueTicketResponseDto.setResponseStatus(ResponseStatus.Success);
        }
        catch(Exception ex){
            ex.getMessage();
            issueTicketResponseDto.setResponseStatus(ResponseStatus.Failed);
        }
        return issueTicketResponseDto;
    }
}
