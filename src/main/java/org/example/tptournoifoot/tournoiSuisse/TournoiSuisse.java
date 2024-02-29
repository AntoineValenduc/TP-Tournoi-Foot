package org.example.tptournoifoot.tournoiSuisse;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.tptournoifoot.match.Match;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TournoiSuisse {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String classement;

    @Column
    private boolean equipeQualifier;

    @Column
    private boolean equipeDisqualifier;

    @OneToMany(mappedBy = "tournoiSuisse")
    private List<Match> matchs = new ArrayList<>();
}