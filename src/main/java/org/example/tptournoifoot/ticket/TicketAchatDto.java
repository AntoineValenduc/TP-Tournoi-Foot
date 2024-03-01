package org.example.tptournoifoot.ticket;

import lombok.Data;
import org.example.tptournoifoot.match.MatchAchatTicketDto;
import org.example.tptournoifoot.stade.StadeSimpleTicketDto;
import org.example.tptournoifoot.supporter.SupporterAvecNomEtPrenomDto;


@Data
public class TicketAchatDto {
    private Integer id;
    private int numero;
    private int numeroRange;
    private int prix;
    private MatchAchatTicketDto matchAchatTicketDto;
    private SupporterAvecNomEtPrenomDto supporterAvecNomEtPrenomDto;
    private StadeSimpleTicketDto stadeSimpleTicketDto;
}
