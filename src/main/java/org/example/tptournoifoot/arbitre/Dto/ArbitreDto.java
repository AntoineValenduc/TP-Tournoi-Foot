package org.example.tptournoifoot.arbitre.Dto;

import lombok.Data;
import org.example.tptournoifoot.match.Dto.MatchDto;

@Data
public class ArbitreDto {

    private Integer id;
    private String nom;
    private String prenom;
    private MatchDto matchDto;
}
