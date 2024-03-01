package org.example.tptournoifoot.ticket;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
    @Setter
    @Getter
    @Id
    @GeneratedValue
    private Integer id;

    @Setter
    @Getter
    @Column
    private int nombreTickets;

    @Column(name = "type")
    private String type;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "numero_de_range")
    private Integer numeroRange;

    @Column(name = "prix")
    private double prix;

    @Column(name = "categorie")
    private String categorie;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @ManyToOne
    @JoinColumn(name = "supporter_id")
    private Supporter supporter;

    @ManyToOne
    @JoinColumn(name = "stade_id")
    private Stade stade;
}