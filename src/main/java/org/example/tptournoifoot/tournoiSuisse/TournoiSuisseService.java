package org.example.tptournoifoot.tournoiSuisse;
import org.apache.coyote.BadRequestException;
import org.example.tptournoifoot.entraineur.exception.EntraineurNotFoundException;
import org.example.tptournoifoot.joueur.Joueur;
import org.example.tptournoifoot.joueur.JoueurRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public void deleteById(Integer id) {
        TournoiSuisse tournoiSuisse = this.findById(id);
        tournoiSuisseRepository.delete(tournoiSuisse);
    }

    public TournoiSuisse update(TournoiSuisse tournoiSuisse) {
        return tournoiSuisseRepository.save(tournoiSuisse);
    }
}