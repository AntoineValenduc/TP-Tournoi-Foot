package org.example.tptournoifoot.equipe;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeService {
    private final EquipeRepository equipeRepository;
    public EquipeService(EquipeRepository equipeRepository)
    {
        this.equipeRepository = equipeRepository;
    }

    public List<Equipe> findAll()
    {
        return equipeRepository.findAll();
    }

    public Optional<Equipe> getEquipeById(Integer id)
    {
        return equipeRepository.findById(id);
    }

    public Equipe save (Equipe equipe)
    {
        return equipeRepository.save(equipe);
    }
    public void deleteById(Integer id)
    {
        equipeRepository.deleteById(id);
    }
}
