package org.example.tptournoifoot.entraineur;

import org.apache.coyote.BadRequestException;
import org.example.tptournoifoot.entraineur.exception.EntraineurNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntraineurService {

    private final EntraineurRepository entraineurRepository;

    public EntraineurService(EntraineurRepository entraineurRepository) {
        this.entraineurRepository = entraineurRepository;
    }
    public Entraineur save(Entraineur entraineur) throws BadRequestException {
        verifyEntraineur(entraineur);
        return entraineurRepository.save(entraineur);
    }

    private static void verifyEntraineur(Entraineur entraineur) throws BadRequestException {
        List<String> erreurs = new ArrayList<>();
        if(entraineur.getNom() == null){
            erreurs.add("Le nom est obligatoire");
        }
        if(entraineur.getPrenom() == null){
            erreurs.add("Le prénom est obligatoire");
        }
        if(!erreurs.isEmpty()){
            throw new BadRequestException(String.valueOf(erreurs));
        }
    }
    public Entraineur findById(Integer id){
        return entraineurRepository.findById(id).orElseThrow(EntraineurNotFoundException::new);
    }
    public void deleteById(Integer id) {
        Entraineur entraineur = this.findById(id);
        entraineurRepository.delete(entraineur);
    }

    public Entraineur update(Entraineur entraineur) {
        return entraineurRepository.save(entraineur);
    }
}
