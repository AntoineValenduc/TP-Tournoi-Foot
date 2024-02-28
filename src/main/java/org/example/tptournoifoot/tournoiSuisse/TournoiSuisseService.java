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

    private final SystemeSuisse systemeSuisse;

    public TournoiSuisseService(TournoiSuisseRepository tournoiSuisseRepository, SystemeSuisse systemeSuisse) {
        this.tournoiSuisseRepository = tournoiSuisseRepository;
        this.systemeSuisse = systemeSuisse;
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

    public void creationTournoi() throws BadRequestException {
        tournoiSuisseRepository.saveAndFlush(TournoiSuisseMapStruct.INSTANCE.toEntityComplet(systemeSuisse.creationTournoi()));
    }
}