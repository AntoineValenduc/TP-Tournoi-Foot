package org.example.tptournoifoot.arbitre;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArbitreService {
    private final ArbitreRepository arbitreRepository;

    public ArbitreService(ArbitreRepository arbitreRepository) {

        this.arbitreRepository = arbitreRepository;
    }

    public List<Arbitre> findAll()
    {
        return arbitreRepository.findAll();
    }

    public Optional<Arbitre> getStadeById(Integer id)
    {
        return arbitreRepository.findById(id);
    }

    public Arbitre save (Arbitre arbitre)
    {
        return arbitreRepository.save(arbitre);
    }
    public void deleteById(Integer id)
    {
        arbitreRepository.deleteById(id);
    }
}
