package org.example.tptournoifoot.equipe.Dto;

import lombok.Data;
import org.example.tptournoifoot.entraineur.Dto.EntraineurDto;
import org.example.tptournoifoot.joueur.Dto.JoueurDto;
import org.example.tptournoifoot.match.Dto.MatchDto;

import java.util.ArrayList;
import java.util.List;

@Data
public class EquipeDto {

    private Integer id;
    private String nom;
    private String totalTournoiGagne;
    private String classementGeneral;
    private EntraineurDto entraineurDto;
    private List<JoueurDto> joueursDto = new ArrayList<>();
    private List<MatchDto> matchsDto = new ArrayList<>();

}
