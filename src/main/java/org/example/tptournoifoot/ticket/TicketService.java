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
    private final StadeService stadeService;

    public TicketService(TicketRepository ticketRepository, StadeService stadeService, MatchService matchService) {
        this.ticketRepository = ticketRepository;
        this.matchService = matchService;
        this.stadeService = stadeService;
    }

    public Ticket acheterTickets(Integer nombreTickets, String categorie) {
        Stade stade = stadeService.findByNomAndVille("Arena", "Paris");

        if (stade != null) {
            int capaciteRestante = stade.getCapaciteTotal()- stadeService.getCapaciteUtilisee();
            int capaciteMaxParCategorie = determineCapaciteMaxParCategorie(categorie);

            if (nombreTickets <= capaciteRestante && nombreTickets <= 50000 && nombreTickets <= capaciteMaxParCategorie) {
                Ticket ticket = new Ticket();
                ticket.setNombreTickets(nombreTickets);
                ticket.setCategorie(categorie);

                double prix = determinePriceByCategory(categorie);
                ticket.setPrix(prix);
                Ticket ticketAchete = ticketRepository.save(ticket);
                stadeService.updateCapaciteUtilisee();

                return ticketAchete;
            } else {
                throw new IllegalArgumentException("Nombre de tickets demandés supérieur à la capacité disponible du stade, dépassement de la capacité maximale, ou dépassement du nombre maximal de tickets par catégorie.");
            }
        } else {
            throw new RuntimeException("Stade non trouvé.");
        }
    }
    public double determinePriceByCategory(String categorie) {
        switch (categorie) {
            case "VIP":
                return 200.0;
            case "A":
                return 100.0;
            case "B":
                return 80.0;
            case "C":
                return 60.0;
            default:
                throw new IllegalArgumentException("Invalid ticket category.");
        }
    }
    private int determineCapaciteMaxParCategorie(String categorie) {
        switch (categorie) {
            case "VIP":
                return 5000; // maximum de 5000 tickets VIP
            case "A":
                return 10000; // maximum de 10000 tickets de catégorie A
            case "B":
                return 20000; // maximum de 15000 tickets de catégorie B
            case "C":
                return 15000; // maximum de 20000 tickets de catégorie C
            default:
                throw new IllegalArgumentException("Catégorie de ticket invalide.");
        }
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