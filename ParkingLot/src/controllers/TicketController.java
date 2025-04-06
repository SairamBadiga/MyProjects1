package controllers;

import dtos.IssueTicketRequestDTO;
import dtos.IssueTicketResponseDTO;
import dtos.ResponseStatus;
import models.Ticket;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;

    }
    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO requestDTO) {
        IssueTicketResponseDTO responseDTO = new IssueTicketResponseDTO();

        try{
            Ticket ticket = ticketService.issueToken(requestDTO.getGateId(),
                                                    requestDTO.getVehicleNumber(),
                                                    requestDTO.getVehicleOwner(),
                                                    requestDTO.getVehicleType());
            responseDTO.setTicket(ticket);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);

        }

        catch(Exception ex){
            ex.getMessage();
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);

        }
        return responseDTO;



    }
}
