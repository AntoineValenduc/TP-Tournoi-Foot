package org.example.tptournoifoot.match;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MatchService {
    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    // GET tout les matchs
    public List<Match> findAllMatch() {
        return matchRepository.findAll();
    }

    // Sauvegarde
    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    //GET by ID
    public Match findMatchById(Integer id) {
        return matchRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Match non trouvé"
                )
        );
    }

    // DELETE match by ID
    public void deleteMatchById(Integer id) {
        Match match = this.findMatchById(id);
        matchRepository.delete(match);
    }

    // PUT (update) le match
    public Match updateMatch(Match match) {
        return matchRepository.save(match);
    }

}
