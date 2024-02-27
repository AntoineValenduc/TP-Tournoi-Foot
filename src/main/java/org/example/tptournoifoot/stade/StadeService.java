package org.example.tptournoifoot.stade;

import org.example.tptournoifoot.match.Match;
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
    public boolean gererFluxEntrants(Integer idStade, int nombrePersonnes) {
        Optional<Stade> optionalStade = stadeRepository.findById(idStade);
        if (optionalStade.isPresent()) {
            Stade stade = optionalStade.get();
            int capaciteRestante = stade.getCapacite() - nombrePersonnes;
            if (capaciteRestante >= 0 && capaciteRestante <= 50000) {
                stade.setCapacite(capaciteRestante);
                stadeRepository.save(stade);
                return true; // Flux géré avec succès
            }
        }
        return false; // Capacité insuffisante ou dépassement de la capacité maximale
    }
}

