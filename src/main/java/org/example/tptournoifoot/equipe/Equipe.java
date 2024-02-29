package org.example.tptournoifoot.equipe;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.example.tptournoifoot.entraineur.Entraineur;
import org.example.tptournoifoot.joueur.Joueur;
import org.example.tptournoifoot.match.Match;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name ="equipe")
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "totalTournoiGagne")
    private String totalTournoiGagne;

    @Column(name = "classementGeneral")
    private String classementGeneral;

    @OneToOne
    @JoinColumn(name = "entraineur_id")
    private Entraineur entraineur;

    @OneToMany(mappedBy = "equipe")
    private List<Joueur> joueurs = new ArrayList<>();

    @ManyToMany(mappedBy = "equipes")
    private List<Match> matchs = new ArrayList<>();

}
