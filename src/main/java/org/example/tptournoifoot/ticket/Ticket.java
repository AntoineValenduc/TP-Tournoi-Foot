package org.example.tptournoifoot.ticket;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.tptournoifoot.match.Match;
import org.example.tptournoifoot.stade.Stade;
import org.example.tptournoifoot.supporter.Supporter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "numero_de_range")
    private Integer numeroRange;

    @Column(name = "prix")
    private double prix;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    private Stade stade;

    @ManyToOne
    @JoinColumn(name = "supporter_id")
    private Supporter supporter;
}
//ManyToOne Tickets  correspond a un supporter