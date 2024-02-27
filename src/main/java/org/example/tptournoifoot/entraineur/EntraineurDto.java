package org.example.tptournoifoot.entraineur;

import lombok.Data;
import org.example.tptournoifoot.equipe.Equipe;
import org.example.tptournoifoot.equipe.EquipeDto;

@Data
public class EntraineurDto {

    private Integer id;
    private String nom;
    private String prenom;
    private EquipeDto equipeDto;
}
