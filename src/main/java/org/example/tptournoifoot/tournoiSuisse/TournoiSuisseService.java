package org.example.tptournoifoot.tournoiSuisse;
import org.apache.coyote.BadRequestException;
import org.example.tptournoifoot.entraineur.exception.EntraineurNotFoundException;
import org.example.tptournoifoot.equipe.Equipe;
import org.example.tptournoifoot.joueur.Joueur;
import org.example.tptournoifoot.joueur.JoueurRepository;
import org.example.tptournoifoot.match.Match;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TournoiSuisseService {

    private final TournoiSuisseRepository tournoiSuisseRepository;

    public TournoiSuisseService(TournoiSuisseRepository tournoiSuisseRepository) {
        this.tournoiSuisseRepository = tournoiSuisseRepository;
    }


    public TournoiSuisse save(TournoiSuisse tournoiSuisse) throws BadRequestException {
        verifyTournoiSuisse(tournoiSuisse);

        return tournoiSuisseRepository.save(tournoiSuisse);
    }

    private static void verifyTournoiSuisse(TournoiSuisse tournoiSuisse) throws BadRequestException {
        List<String> erreurs = new ArrayList<>();
        if(tournoiSuisse.getClassement() == null){
            erreurs.add("Le Classement est obligatoire");
        }
        if(!erreurs.isEmpty()){
            throw new BadRequestException(String.valueOf(erreurs));
        }
    }


    public TournoiSuisse findById(Integer id){
        return tournoiSuisseRepository.findById(id)
                .orElseThrow(
                        EntraineurNotFoundException::new
                );


    }
    public void delete(TournoiSuisse tournoiSuisse) {
        this.findById(tournoiSuisse.getId());
        tournoiSuisseRepository.delete(tournoiSuisse);
    }

    public TournoiSuisse update(TournoiSuisse tournoiSuisse) {
        return tournoiSuisseRepository.save(tournoiSuisse);
    }
    public List<TournoiSuisse> findAll() {
        return tournoiSuisseRepository.findAll();
    }

    public Map<Equipe, Integer> calculerClassement(Integer id) {
        TournoiSuisse tournoi = tournoiSuisseRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Classement non trouvé"
                ));
        List<Match> matchs = tournoi.getMatchs();

        Map<Equipe, Integer> classement = new HashMap<>();

        // itére sur chaque match dans la liste des matchs
        for (Match match : matchs) {
            // prend le résultat du match, qui est une chaîne de caractères
            // (par exemple, "2-1"), et le divise en deux à l'aide du tiret ("-") comme séparateur.
            // Cela produit un tableau de deux chaînes, où scores[0] contient le score de la première équipe et scores[1]
            // le score de la deuxième équipe.
            String[] scores = match.getResultat().split("-");

            // convertissent les scores de chaînes de caractères en entiers
            // pour permettre des comparaisons numériques
            int scoreEquipe1 = Integer.parseInt(scores[0]);
            int scoreEquipe2 = Integer.parseInt(scores[1]);

            //Initialisation des deux équipes
            Equipe equipe1 = match.getEquipes().get(0);
            Equipe equipe2 = match.getEquipes().get(1);

            // a partir de là on compare le score des deux équipes
            // on suppose qu'un match fini/gagné correspond a 3 points
            if (scoreEquipe1 > scoreEquipe2) {
                classement.put(equipe1, classement.getOrDefault(equipe1, 0) + 3);
            } else if (scoreEquipe1 < scoreEquipe2) {
                classement.put(equipe2, classement.getOrDefault(equipe2, 0) + 3);
            }
        }
        return classement;
    }
}