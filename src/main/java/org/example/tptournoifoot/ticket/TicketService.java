package org.example.tptournoifoot.ticket;


import org.example.tptournoifoot.match.Match;
import org.example.tptournoifoot.match.MatchService;

import org.example.tptournoifoot.stade.Stade;
import org.example.tptournoifoot.stade.StadeService;
import org.example.tptournoifoot.supporter.Supporter;
import org.example.tptournoifoot.supporter.SupporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    private final MatchService matchService;
    private final StadeService stadeService;
    private final SupporterService supporterService;


    public TicketService(TicketRepository ticketRepository, StadeService stadeService, MatchService matchService, SupporterService supporterService) {
        this.ticketRepository = ticketRepository;
        this.matchService = matchService;
        this.stadeService = stadeService;
        this.supporterService = supporterService;
    }


    public Ticket acheterTickets(TicketAchatDto ticketAchatDto) {
        Ticket ticket = new Ticket();

        ticket.setNumero(ticketAchatDto.getNumero());
        ticket.setNumeroRange(ticketAchatDto.getNumeroRange());
        ticket.setPrix(ticketAchatDto.getPrix());


        Match match = matchService.findMatchById(ticketAchatDto.getMatchAchatTicketDto().getId());
        Supporter supporter = supporterService.findSupporterById(ticketAchatDto.getSupporterAvecNomEtPrenomDto().getId());
        Stade stade = stadeService.findById(ticketAchatDto.getStadeSimpleTicketDto().getId());

        ticket.setMatch(match);
        ticket.setSupporter(supporter);
        ticket.setStade(stade);

        return save(ticket);
    }

    public List<Ticket> findAllTicket() {
        return ticketRepository.findAll();
    }

    // Sauvegarde
    public Ticket save(Ticket ticket) {
        Match match = matchService.findMatchById(ticket.getMatch().getId());
        int placesDisponibles = match.getPlacesDisponible();
        match.setPlacesDisponible(placesDisponibles - 1);
        matchService.updateMatch(match,match.getId());
        ticket.setMatch(match);
        return ticketRepository.save(ticket);
    }


    // GET By id
    public Ticket findTicketById(Integer id) {
        return ticketRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Ticket non trouvé"
                )
        );
    }

    public void deleteTicketById(Integer id) {
        Ticket ticket = this.findTicketById(id);
        ticketRepository.delete(ticket);
    }

    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public void compareTicketsSold(int totalTicketsSoldVIP, int totalTicketsSoldA, int totalTicketsSoldB, int totalTicketsSoldC, int totalTicketsSoldPreviousYear) {
        int totalTicketsSoldCurrentYear = totalTicketsSoldVIP + totalTicketsSoldA + totalTicketsSoldB + totalTicketsSoldC;

        // Compare les résultats des ventes de l'année n-1 et n
        if (totalTicketsSoldCurrentYear > totalTicketsSoldPreviousYear) {
            System.out.println("Plus de tickets vendus comparés à l'année précédente.");
        } else if (totalTicketsSoldCurrentYear < totalTicketsSoldPreviousYear) {
            System.out.println("Moins de tickets vendus comparés à l'année précédente.");
        } else {
            System.out.println("Même nombre de tickets vendus comparés à l'année précédente.");
        }
    }
}