package org.example.tptournoifoot.ticket;

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
    public Ticket findTicketById(@PathVariable Integer id) {
        return ticketService.findTicketById(id);
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
