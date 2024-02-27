package org.example.tptournoifoot.arbitre;

import org.example.tptournoifoot.match.Match;
import org.example.tptournoifoot.match.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArbitreService {

    private final ArbitreRepository arbitreRepository;
    private final MatchRepository matchRepository;

    @Autowired
    public ArbitreService(ArbitreRepository arbitreRepository, MatchRepository matchRepository) {
        this.arbitreRepository = arbitreRepository;
        this.matchRepository = matchRepository;
    }

    public List<Arbitre> findAll() {
        return arbitreRepository.findAll();
    }

    public Optional<Arbitre> getArbitreById(Integer id) {
        return arbitreRepository.findById(id);
    }

    public Arbitre save(Arbitre arbitre) {
        return arbitreRepository.save(arbitre);
    }

    public void deleteById(Integer id) {
        arbitreRepository.deleteById(id);
    }

    // Méthode pour assigner un arbitre à un match avec deux équipes
    public boolean assignerArbitreAMatch(Integer idArbitre, Integer idMatch) {
        Optional<Arbitre> optionalArbitre = arbitreRepository.findById(idArbitre);
        Optional<Match> optionalMatch = matchRepository.findById(idMatch);

        if (optionalArbitre.isPresent() && optionalMatch.isPresent()) {
            Arbitre arbitre = optionalArbitre.get();
            Match match = optionalMatch.get();

            // Assigner l'arbitre au match
            arbitre.setMatch(match);
            match.setArbitre(arbitre);

            // Enregistrer les changements
            arbitreRepository.save(arbitre);
            matchRepository.save(match);

            return true; // Arbitre assigné avec succès au match
        }
        return false; // Arbitre ou match non trouvés
    }
}

