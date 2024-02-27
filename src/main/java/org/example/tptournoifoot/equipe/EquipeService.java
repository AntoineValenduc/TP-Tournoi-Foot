package org.example.tptournoifoot.equipe;


import org.example.tptournoifoot.match.Match;
import org.example.tptournoifoot.match.MatchRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EquipeService {
    private final EquipeRepository equipeRepository;
    private final MatchRepository matchRepository;
    public EquipeService(EquipeRepository equipeRepository, MatchRepository matchRepository)
    {
        this.equipeRepository = equipeRepository;
        this.matchRepository = matchRepository;
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

    // ajouter une équipe à un match
    public boolean ajouterEquipeAMatch(Integer idEquipe, Integer idMatch) {
        Optional<Equipe> optionalEquipe = equipeRepository.findById(idEquipe);
        Optional<Match> optionalMatch = matchRepository.findById(idMatch);

        if (optionalEquipe.isPresent() && optionalMatch.isPresent()) {
            Equipe equipe = optionalEquipe.get();
            Match match = optionalMatch.get();

            // Vérifier si l'équipe peut être ajoutée au match
            if (peutAjouterEquipeAMatch(equipe, match)) {
                // Ajouter l'équipe au match
                match.getEquipes().add(equipe);
                equipe.getMatchs().add(match);

                // Mettre à jour la base de données
                equipeRepository.save(equipe);
                matchRepository.save(match);

                return true; // Équipe ajoutée avec succès au match
            }
        }
        return false; // Équipe non trouvée ou ne peut pas être ajoutée au match
    }

    // vérifier si l'équipe peut être ajoutée à un match
    private boolean peutAjouterEquipeAMatch(Equipe equipe, Match match) {
        // Vérifier si l'équipe est déjà dans un match pour le même round
        if (equipeDejaDansMatch(equipe, match)) {
            return false;
        }

        return true;
    }

    // vérifier si l'équipe est déjà dans un match pour le même round
    private boolean equipeDejaDansMatch(Equipe equipe, Match match) {
        for (Equipe equipeDuMatch : match.getEquipes()) {
            if (equipeDuMatch.getId().equals(equipe.getId())) {
                return true;
            }
        }
        return false;
    }
}



