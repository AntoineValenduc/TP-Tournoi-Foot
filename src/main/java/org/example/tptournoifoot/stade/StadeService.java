package org.example.tptournoifoot.stade;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StadeService {
    private final StadeRepository stadeRepository;
    public StadeService(StadeRepository stadeRepository)
    {
    this.stadeRepository = stadeRepository;
    }

    public List<Stade>findAll()
    {
        return stadeRepository.findAll();
    }

    public Optional<Stade>getStadeById(Integer id)
    {
        return stadeRepository.findById(id);
    }

    public Stade save (Stade stade)
    {
        return stadeRepository.save(stade);
    }
    public void deleteById(Integer id)
    {
        stadeRepository.deleteById(id);
    }
}
