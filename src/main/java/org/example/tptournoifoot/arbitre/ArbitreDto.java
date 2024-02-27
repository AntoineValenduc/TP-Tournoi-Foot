package org.example.tptournoifoot.arbitre;

import lombok.Data;
import org.example.tptournoifoot.match.Match;

@Data
public class ArbitreDto {

    private Integer id;
    private String nom;
    private String prenom;
    private Match match;
}
