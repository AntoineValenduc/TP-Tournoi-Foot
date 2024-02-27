package org.example.tptournoifoot.match.Dto;

import lombok.Data;
import org.example.tptournoifoot.arbitre.Dto.ArbitreDto;
import org.example.tptournoifoot.equipe.Dto.EquipeDto;
import org.example.tptournoifoot.stade.Dto.StadeDto;
import org.example.tptournoifoot.ticket.Dto.TicketDto;
import org.example.tptournoifoot.tournoiSuisse.Dto.TournoiSuisseDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class MatchDto {

    private Integer id;
    private LocalDate dateHoraire;
    private String resultat;
    private String duree;
    private ArbitreDto arbitreDto;
    private StadeDto stadeDto;
    private TournoiSuisseDto tournoiSuisseDto;
    private List<TicketDto> ticketsDto = new ArrayList<>();
    private List<EquipeDto> equipesDto = new ArrayList<>();
}
