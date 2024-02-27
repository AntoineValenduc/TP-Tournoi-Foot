package org.example.tptournoifoot.supporter;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SupporterService {

    private final SupporterRepository supporterRepository;

    public SupporterService(SupporterRepository supporterRepository) {
        this.supporterRepository = supporterRepository;
    }
    // tout les supporters
    public List<Supporter> findAllSupporter() {
        return supporterRepository.findAll();
    }

    // Sauvegarde
    public Supporter saveSupporter(Supporter supporter) {
        return supporterRepository.save(supporter);
    }

    //GET by id
    public Supporter findSupporterById(Integer id){
        return supporterRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Supporter non trouvée"
                )
        );
    }

    //DELETE supporter par l'ID
    public void deleteSupporterById(Integer id){
        Supporter supporter = this.findSupporterById(id);
        supporterRepository.delete(supporter);
    }

    // PUT (update) supporter
    public Supporter updateSupporter(Supporter supporter){
        return supporterRepository.save(supporter);
    }

    // GET Par nom du supporter
    public Supporter findByNomSupporter(String nom){
        return supporterRepository.findByNom(nom).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Aucuns supporter trouvé avec pour nom" + nom
                )
        );
    }
}
