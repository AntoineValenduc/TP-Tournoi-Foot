package org.example.tptournoifoot.stade;

import lombok.Data;
import org.example.tptournoifoot.match.MatchDto;

import java.util.ArrayList;
import java.util.List;

@Data
public class StadeDto {

    private Integer id ;
    private String nom;
    private String ville;
    private int capacite;
    private List<MatchDto> matchsDto = new ArrayList<>();
}
