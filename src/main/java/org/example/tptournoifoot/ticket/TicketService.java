package org.example.tptournoifoot.ticket;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    // constructor
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    //GET tout les tickets
    public List<Ticket> findAllMatch() {
        return ticketRepository.findAll();
    }

    // Sauvegarde
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // GET By id
    public Ticket findTicketById(Integer id){
        return ticketRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Ticket non trouvé"
                )
        );
    }

    //DELETE ticket By Id
    public void deleteTicketById(Integer id){
        Ticket ticket = this.findTicketById(id);
        ticketRepository.delete(ticket);
    }

    //PUT (update) ticket
    public Ticket updateTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

}
