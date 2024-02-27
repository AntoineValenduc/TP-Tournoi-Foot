package org.example.tptournoifoot.tournoiSuisse;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class TournoiSuisse {
    @Id
    @GeneratedValue
    private Integer id;
    private String classement;
    private boolean equipeQualifier;
    private boolean equipeDisqualifier;

}