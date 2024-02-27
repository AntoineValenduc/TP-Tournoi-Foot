package org.example.tptournoifoot.supporter.Dto;

import lombok.Data;
import org.example.tptournoifoot.ticket.Dto.TicketDto;

import java.util.ArrayList;
import java.util.List;

@Data
public class SupporterDto {

    private Integer id;
    private String nom;
    private String prenom;
    private List<TicketDto> ticketsDto = new ArrayList<>();
}
