package org.example.tptournoifoot.TournoiSuisse;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@Getter
@Setter
@NoArgsConstructor

public class TournoiSuisse {
    @Id
    @GeneratedValue
    private String classement;
    private boolean equipeQualifier;
    private boolean equipeDisqualifier;

}