package org.example.tptournoifoot.ticket.Dto;

import lombok.Data;
import org.example.tptournoifoot.match.Dto.MatchDto;
import org.example.tptournoifoot.supporter.Dto.SupporterDto;

@Data
public class TicketDto {

    private Integer id;
    private String type;
    private Integer numero;
    private Integer numeroRange;
    private double prix;
    private MatchDto matchDto;
    private SupporterDto supporterDto;
}
