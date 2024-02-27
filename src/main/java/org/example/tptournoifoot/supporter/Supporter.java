package org.example.tptournoifoot.supporter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Supporter {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;
}
//OneToMany supporter peut avoir plusieurs tickets