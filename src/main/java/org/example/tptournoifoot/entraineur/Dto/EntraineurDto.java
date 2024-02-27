package org.example.tptournoifoot.entraineur.Dto;

import lombok.Data;
import org.example.tptournoifoot.equipe.Dto.EquipeDto;

@Data
public class EntraineurDto {

    private Integer id;
    private String nom;
    private String prenom;
    private EquipeDto equipeDto;
}
