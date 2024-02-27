package org.example.tptournoifoot.joueur;

import lombok.Data;
import org.example.tptournoifoot.equipe.EquipeDto;

@Data
public class JoueurDto {

    private Integer id;
    private String nom;
    private String prenom;
    private int numero;
    private EquipeDto equipeDto;
}
