package org.example.tptournoifoot.stade;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StadeRepository extends JpaRepository<Stade, Integer> {
    @Query("SELECT s.capacite FROM Stade s WHERE s.id = :stadeId")
    Integer findCapaciteById(@Param("stadeId") Integer stadeId);
}
