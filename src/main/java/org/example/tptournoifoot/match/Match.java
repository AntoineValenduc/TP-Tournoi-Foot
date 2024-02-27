package org.example.tptournoifoot.match;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;



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
}
