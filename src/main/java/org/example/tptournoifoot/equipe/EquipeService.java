package org.example.tptournoifoot.equipe;


import org.example.tptournoifoot.equipe.exceptions.EquipeCantBeNullException;
import org.example.tptournoifoot.equipe.exceptions.EquipeNotFoundException;
import org.example.tptournoifoot.match.Match;
import org.example.tptournoifoot.match.MatchDto;
import org.example.tptournoifoot.match.MatchMapStruct;
import org.example.tptournoifoot.match.MatchRepository;
import org.example.tptournoifoot.match.exception.MatchNotFoundException;
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

    /**
     * Retourne la liste des Equipes
     * @return Liste EquipeDto
     */
    public List<EquipeDto> findAll(){
        return equipeRepository.findAll()
                .stream()
                .map(EquipeMapStruct.INSTANCE::toDtoComplet)
                .toList();
    }


    public Optional<EquipeDto> getEquipeById(Integer id)
    {
        return Optional.ofNullable(EquipeMapStruct.INSTANCE.toDtoComplet(equipeRepository.findById(id)
                .orElseThrow(() -> new EquipeNotFoundException(id))));
    }

    public void save (EquipeDto equipe){
        if (equipe == null){
            throw new EquipeCantBeNullException();
        } else {
            equipeRepository.saveAndFlush(EquipeMapStruct.INSTANCE.toEntityComplet(equipe));
        }

    }
    public void deleteById(Integer id){
        equipeRepository.deleteById(id);
    }

    // ajouter une équipe à un match
    public boolean ajouterEquipeAMatch(Integer idEquipe, Integer idMatch) {
        Optional<EquipeDto> optionalEquipe = Optional.ofNullable(EquipeMapStruct.INSTANCE.toDtoComplet(equipeRepository.findById(idEquipe)
                .orElseThrow(() -> new EquipeNotFoundException(idEquipe))));
        Optional<MatchDto> optionalMatch = Optional.ofNullable(MatchMapStruct.INSTANCE.toDtoComplet(matchRepository.findById(idMatch)
                .orElseThrow(() -> new MatchNotFoundException(idMatch))));

        if (optionalEquipe.isPresent() && optionalMatch.isPresent()) {
            EquipeDto equipe = optionalEquipe.get();
            MatchDto match = optionalMatch.get();

            // Vérifier si l'équipe peut être ajoutée au match
            if (peutAjouterEquipeAMatch(equipe, match)) {
                // Ajouter l'équipe au match
                match.getEquipesDto().add(equipe);
                equipe.getMatchsDto().add(match);

                // Mettre à jour la base de données
                equipeRepository.save(EquipeMapStruct.INSTANCE.toEntityComplet(equipe));
                matchRepository.save(MatchMapStruct.INSTANCE.toEntityComplet(match));

                return true; // Équipe ajoutée avec succès au match
            }
        }
        return false; // Équipe non trouvée ou ne peut pas être ajoutée au match
    }

    // vérifier si l'équipe peut être ajoutée à un match
    private boolean peutAjouterEquipeAMatch(EquipeDto equipe, MatchDto match) {
        // Vérifier si l'équipe est déjà dans un match pour le même round
        if (equipeDejaDansMatch(equipe, match)) {
            return false;
        }

        return true;
    }

    // vérifier si l'équipe est déjà dans un match pour le même round
    private boolean equipeDejaDansMatch(EquipeDto equipe, MatchDto match) {
        for (EquipeDto equipeDuMatch : match.getEquipesDto()) {
            if (equipeDuMatch.getId().equals(equipe.getId())) {
                return true;
            }
        }
        return false;
    }
}



