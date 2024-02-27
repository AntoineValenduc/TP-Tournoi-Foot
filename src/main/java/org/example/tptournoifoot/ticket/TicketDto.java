package org.example.tptournoifoot.ticket;

import lombok.Data;
import org.example.tptournoifoot.match.MatchDto;
import org.example.tptournoifoot.supporter.SupporterDto;

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
