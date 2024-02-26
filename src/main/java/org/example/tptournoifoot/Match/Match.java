package org.example.tptournoifoot.Match;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;



@Entity
@Getter
@Setter
@NoArgsConstructor

public class Match {
    @Id
    @GeneratedValue
    private LocalDate dateHoraire;
    private String resultat;
    private String duree;
}
