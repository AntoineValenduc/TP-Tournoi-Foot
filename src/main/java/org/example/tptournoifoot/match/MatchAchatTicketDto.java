package org.example.tptournoifoot.match;


import lombok.Data;
import org.example.tptournoifoot.stade.StadeSimpleTicketDto;

@Data
public class MatchAchatTicketDto {
    private Integer id;
    private StadeSimpleTicketDto stadeSimpleDto;
}
