package org.example.tptournoifoot.arbitre;

import org.springframework.stereotype.Service;

@Service
public class ArbitreService {
    private final ArbitreRepository arbitreRepository;

    public ArbitreService(ArbitreRepository arbitreRepository) {
        this.arbitreRepository = arbitreRepository;
    }
}
