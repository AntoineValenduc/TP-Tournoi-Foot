package org.example.tptournoifoot.match;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Integer> {
    List<Match> findByDate(LocalDate date);
}
