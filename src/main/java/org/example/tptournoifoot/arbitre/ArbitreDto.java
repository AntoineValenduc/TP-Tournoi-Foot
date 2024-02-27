package org.example.tptournoifoot.arbitre;

import lombok.Data;
import org.example.tptournoifoot.match.Match;
import org.example.tptournoifoot.match.MatchDto;

@Data
public class ArbitreDto {

    private Integer id;
    private String nom;
    private String prenom;
    private MatchDto matchDto;
}
