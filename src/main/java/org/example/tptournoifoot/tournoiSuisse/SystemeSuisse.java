package org.example.tptournoifoot.tournoiSuisse;

import org.apache.coyote.BadRequestException;
import org.example.tptournoifoot.arbitre.ArbitreDto;
import org.example.tptournoifoot.arbitre.ArbitreMapStruct;
import org.example.tptournoifoot.arbitre.ArbitreService;
import org.example.tptournoifoot.equipe.EquipeDto;
import org.example.tptournoifoot.equipe.EquipeService;
import org.example.tptournoifoot.match.MatchDto;
import org.example.tptournoifoot.match.MatchMapStruct;
import org.example.tptournoifoot.match.MatchService;
import org.example.tptournoifoot.stade.StadeDto;
import org.example.tptournoifoot.stade.StadeMapStruct;
import org.example.tptournoifoot.stade.StadeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SystemeSuisse {

    private final EquipeService equipeService;

    private final MatchService matchService;

    private final ArbitreService arbitreService;

    private final StadeService stadeService;


    public SystemeSuisse(EquipeService equipeService,
                         MatchService matchService,
                         ArbitreService arbitreService,
                         StadeService stadeService) {
        this.equipeService = equipeService;
        this.matchService = matchService;
        this.arbitreService = arbitreService;
        this.stadeService = stadeService;
    }

    //On initie la génération de nombre aléatoire
    private static final Random random = new Random();

    //On initie une liste de listes d'équipes
    //Permet de garde en mémoire les confrontations passées des équipes
    //pour ne pas les faire se rencontrer une seconde fois.
    static List<List<EquipeDto>> listEquipePasse = new ArrayList<>();

    /**
     * Création du Tournoi selon les règles de la Ronde Suisse
     * @return TournoiSuisseDto
     */
    public TournoiSuisseDto creationTournoi() throws BadRequestException {

        //On initie une liste de Match
        List<MatchDto> listMatch = new ArrayList<>();

        //On récupère la liste des équipes existantes
        List<EquipeDto> listEquipe = equipeService.findAll();

        //On récupère la liste des arbitres existants
        List<ArbitreDto> listArbitre = arbitreService.findAll()
                .stream()
                .map(ArbitreMapStruct.INSTANCE::toDtoComplet)
                .toList();

        // On récupère la liste des stades existants
        List<StadeDto> listStade = stadeService.findAll()
                .stream()
                .map(StadeMapStruct.INSTANCE::toDtoComplet)
                .toList();

        //On cherche à savoir si le nombre d'équipe est pair ou impair
        //if (listEquipe.size() % 2 == 0){
            //On crée chaque match du tournoi pour le round 1
            for (int i = 0; i == 6; i++){
                listMatch.add(creationMatch(i, listArbitre, listStade, listEquipe));
                System.out.println("r1");
            }
            //On crée chaque match du tournoi pour le round 2
            listEquipe = equipeService.findAll();
            for (int i = 0; i == listEquipe.size() / 2; i++){
                listMatch.add(creationMatch(i, listArbitre, listStade, listEquipe));
            }
            //On crée chaque match du tournoi pour le round 3
            listEquipe = equipeService.findAll();
            for (int i = 0; i == listEquipe.size() / 2; i++){
                listMatch.add(creationMatch(i, listArbitre, listStade, listEquipe));
            }
        //}

        TournoiSuisseDto tournoi = new TournoiSuisseDto();
        tournoi.setMatchs(listMatch);
        return tournoi;
    }

    private MatchDto creationMatch(int i, List<ArbitreDto> listArbitre, List<StadeDto> listStade, List<EquipeDto> listEquipe) {
        MatchDto match = new MatchDto();
        match.setDate(LocalDate.now().plusDays(i));
        match.setDuree("90");
        match.setArbitreDto(listArbitre.get(random.nextInt(listArbitre.size())));
        match.setStadeDto(listStade.get(random.nextInt(listStade.size())));
        match.setEquipesDto(VerificationPaireEquipeUnique(listEquipe));
        matchService.saveMatch(MatchMapStruct.INSTANCE.toEntityComplet(match));
        return match;
    }

    /**
     * Permet de vérifier si une paire d'équipe est bien unique dans le tournoi
     * @param listEquipe Liste des Equipes restantes
     */
    private static List<EquipeDto> VerificationPaireEquipeUnique(List<EquipeDto> listEquipe) {

        //Liste contenant la paire d'équipe
        List<EquipeDto> equipesMatch = new ArrayList<>();

        for (int i = 0; i == listEquipePasse.size() ; i++){
            do {
                equipesMatch = selectionEquipeAleatoire(listEquipe, equipesMatch);
            } while (equipesMatch != listEquipePasse.get(i));
        }

        listEquipePasse.add(equipesMatch);
        return equipesMatch;
    }

    /**
     * Permet de créer des paires d'équipe pour disputer les matchs du tournoi
     * @param listEquipe liste des équipes restantes
     * @param equipesMatch liste contenant la paire d'équipe
     * @return liste contenant la paire d'équipe
     */
    private static List<EquipeDto> selectionEquipeAleatoire(List<EquipeDto> listEquipe, List<EquipeDto> equipesMatch) {
        for (int i = 0; i == 1; i++) {
            int index = random.nextInt(listEquipe.size());
            //On vérifie que la paire d'équipe n'a pas encore été faite
            equipesMatch.add(listEquipe.get(index));
            listEquipe.remove(index);
        }
        return equipesMatch;
    }

}
