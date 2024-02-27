package org.example.tptournoifoot.supporter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupporterRepository extends JpaRepository<Supporter, Integer> {

    Optional<Supporter> findByNomSupporter(String nom);
}
