package org.example.tptournoifoot.ticket;

import org.example.tptournoifoot.match.MatchMapStruct;
import org.example.tptournoifoot.supporter.SupporterMapStruct;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    //GET tout les tickets
    @GetMapping
    public List<Ticket> findAllTicket(){
        return ticketService.findAllTicket();
    }

    //GET by id un ticket
    @GetMapping("/{id}")
    public TicketDto findTicketById(@PathVariable Integer id) {
        Ticket ticket = ticketService.findTicketById(id);

        TicketDto ticketDto = new TicketDto();

        ticketDto.setId(ticket.getId());
        ticketDto.setType(ticket.getType());
        ticketDto.setNumero(ticket.getNumero());
        ticketDto.setNumeroRange(ticket.getNumeroRange());
        ticketDto.setPrix(ticket.getPrix());

        ticketDto.setMatchDto(MatchMapStruct.INSTANCE.toDtoComplet(ticket.getMatch()));
        ticketDto.setSupporterDto(SupporterMapStruct.INSTANCE.toDtoComplet(ticket.getSupporter()));

        return ticketDto;
    }

    //DELETE ticket by ID
    @DeleteMapping("/{id}")
    public void deleteTicketById(@PathVariable Integer id){
        ticketService.deleteTicketById(id);
    }

    // PUT ticket
    @PutMapping
    public Ticket updateTicket(@RequestBody Ticket ticket){
        return ticketService.updateTicket(ticket);
    }

    // POST ticket
    @PostMapping
    public Ticket saveTicket(@RequestBody Ticket ticket){
        return ticketService.saveTicket(ticket);
    }
}
