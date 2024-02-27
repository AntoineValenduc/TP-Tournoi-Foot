package org.example.tptournoifoot.match;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.tptournoifoot.arbitre.Arbitre;
import org.example.tptournoifoot.equipe.Equipe;
import org.example.tptournoifoot.stade.Stade;
import org.example.tptournoifoot.ticket.Ticket;
import org.example.tptournoifoot.tournoiSuisse.TournoiSuisse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Match {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private LocalDate dateHoraire;

    @Column
    private String resultat;

    @Column
    private String duree;

    @OneToOne
    @JoinColumn(name = "arbitre_id")
    private Arbitre arbitre;

    @ManyToOne
    @JoinColumn(name = "stade_id")
    private Stade stade;

    @ManyToOne
    @JoinColumn(name = "tournoiSuisse_id")
    private TournoiSuisse tournoiSuisse;

    @OneToMany(mappedBy = "match")
    private List<Ticket> tickets = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "equipe_match",
            joinColumns = @JoinColumn(name = "match_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "equipe_id", referencedColumnName = "id")
    )
    private List<Equipe> equipes = new ArrayList<>();
}
