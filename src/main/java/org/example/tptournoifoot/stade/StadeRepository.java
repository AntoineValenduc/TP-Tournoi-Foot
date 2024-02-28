package org.example.tptournoifoot.stade;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StadeRepository extends JpaRepository<Stade, Integer> {

    // Trouver le Stade avec son nom et sa ville
    Stade findByNomAndVille(String nom, String ville);
}



