package org.example.tptournoifoot.ticket;

import org.example.tptournoifoot.match.MatchMapStruct;
import org.example.tptournoifoot.supporter.SupporterMapStruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> findAllTicket() {
        return ticketService.findAllTicket();
    }

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

    // DELETE ticket by ID
    @DeleteMapping("/{id}")
    public void deleteTicketById(@PathVariable Integer id) {
        ticketService.deleteTicketById(id);
    }

    @PutMapping
    public Ticket updateTicket(@RequestBody Ticket ticket) {
        return ticketService.updateTicket(ticket);
    }

    @PostMapping
    public Ticket saveTicket(@RequestBody Ticket ticket) {
        return ticketService.saveTicket(ticket);
    }

    @PostMapping("/purchase")
    public ResponseEntity<Ticket> acheterTickets(@RequestParam Integer nombreTickets,
                                                 @RequestParam String categorie) {
        Ticket ticketAchete = ticketService.acheterTickets(nombreTickets, categorie);

        setCategorieAndPrice(ticketAchete, nombreTickets);

        return new ResponseEntity<>(ticketAchete, HttpStatus.CREATED);
    }

    private void setCategorieAndPrice(Ticket ticket, int nombreTickets) {
        if (nombreTickets <= 0) {
            throw new IllegalArgumentException("Nombre de tickets invalide");
        } else if (nombreTickets <= 5000) {
            ticket.setCategorie("VIP");
            ticket.setPrix(200.0);
        } else if (nombreTickets <= 10000) {
            ticket.setCategorie("A");
            ticket.setPrix(100.0);
        } else if (nombreTickets <= 20000) {
            ticket.setCategorie("B");
            ticket.setPrix(80.0);
        } else {
            ticket.setCategorie("C");
            ticket.setPrix(60.0);
        }
    }
    @GetMapping("/compare-tickets")
    public void compareTicketsSold() {
        int totalTicketsSoldVIP = 1000;
        int totalTicketsSoldA = 10000;
        int totalTicketsSoldB = 20000;
        int totalTicketsSoldC = 15000;
        int totalTicketsSoldPreviousYear = 33000;

        ticketService.compareTicketsSold(totalTicketsSoldVIP, totalTicketsSoldA, totalTicketsSoldB, totalTicketsSoldC, totalTicketsSoldPreviousYear);
    }

}
