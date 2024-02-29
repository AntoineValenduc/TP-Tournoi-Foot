package org.example.tptournoifoot.match;

import lombok.Data;
import org.example.tptournoifoot.arbitre.ArbitreDto;
import org.example.tptournoifoot.equipe.EquipeDto;
import org.example.tptournoifoot.stade.StadeDto;
import org.example.tptournoifoot.ticket.TicketDto;
import org.example.tptournoifoot.tournoiSuisse.TournoiSuisseDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class MatchDto {

    private Integer id;
    private LocalDate date;
    private String resultat;
    private String duree;
    private ArbitreDto arbitreDto;
    private StadeDto stadeDto;
    private TournoiSuisseDto tournoiSuisseDto;
    private List<TicketDto> ticketsDto = new ArrayList<>();
    private List<EquipeDto> equipesDto = new ArrayList<>();
}
