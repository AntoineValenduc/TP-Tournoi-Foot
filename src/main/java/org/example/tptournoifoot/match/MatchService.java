package org.example.tptournoifoot.match;


import org.example.tptournoifoot.stade.Stade;
import org.example.tptournoifoot.stade.StadeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class MatchService {
    private final MatchRepository matchRepository;
    private final StadeRepository stadeRepository;

    public MatchService(MatchRepository matchRepository, StadeRepository stadeRepository) {
        this.matchRepository = matchRepository;
        this.stadeRepository = stadeRepository;
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
    public Match updateMatch(Match match,Integer id) {
        match.setId(id);
        this.findMatchById(id);
        return matchRepository.save(match);
    }
    public List<Match> MatchsByDate(LocalDate date) {
        return matchRepository.findByDate(date);
    }
    public Match creerMatch(LocalDate date, Integer id) {
        Stade stade = stadeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Stade non trouvé"));
        Match match = new Match();
        match.setDateHoraire(date);
        match.setStade(stade);
        return matchRepository.save(match);
    }
}
