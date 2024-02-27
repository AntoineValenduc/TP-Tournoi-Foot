package org.example.tptournoifoot.joueur;
import org.apache.coyote.BadRequestException;
import org.example.tptournoifoot.entraineur.Entraineur;
import org.example.tptournoifoot.entraineur.exception.EntraineurNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JoueurService {

    private final JoueurRepository joueurRepository;

    public JoueurService(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }


    public Joueur save(Joueur joueur) throws BadRequestException {
        verifyJoueur(joueur);

        return joueurRepository.save(joueur);
    }

    private static void verifyJoueur(Joueur joueur) throws BadRequestException {
        List<String> erreurs = new ArrayList<>();
        if(joueur.getNom() == null){
            erreurs.add("Le nom est obligatoire");
        }
        if(joueur.getPrenom() == null){
            erreurs.add("Le prénom est obligatoire");
        }
        //    if(joueur.getNumero() <= 0){
         //   erreurs.add("Le bon numéro est obligatoire");
        //    }
        if(!erreurs.isEmpty()){
            throw new BadRequestException(String.valueOf(erreurs));
        }
    }

    public Joueur findById(Integer id){
        return joueurRepository.findById(id)
                .orElseThrow(
                        EntraineurNotFoundException::new
                );


    }

    public void delete(Joueur joueur) {
        this.findById(joueur.getId());
        joueurRepository.delete(joueur);
    }

    public Joueur update(Joueur joueur) {
        return joueurRepository.save(joueur);
    }
    public List<Joueur> findAll() {
        return joueurRepository.findAll();
    }
}
