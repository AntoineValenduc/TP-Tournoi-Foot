package org.example.tptournoifoot.ticket;

import org.example.tptournoifoot.match.Match;
import org.example.tptournoifoot.match.MatchService;
import org.example.tptournoifoot.stade.Stade;
import org.example.tptournoifoot.stade.StadeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final MatchService matchService;

    // constructor
    public TicketService(TicketRepository ticketRepository, MatchService matchService) {
        this.ticketRepository = ticketRepository;
        this.matchService = matchService;
    }

    //GET tout les tickets
    public List<Ticket> findAllTicket() {
        return ticketRepository.findAll();
    }

    // Sauvegarde
    public Ticket save(Ticket ticket) {
        Match match = matchService.findMatchById(ticket.getMatch().getId());
        int placesDisponibles = match.getStade().getPlacesDispo();
        match.setPlacesDisponibles(placesDisponibles - ticket.getStade().getCapacite());
        matchService.updateMatch(match,match.getId());
        ticket.setMatch(match);
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
