package org.example.tptournoifoot.joueur;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.BadRequestException;
import org.example.tptournoifoot.entraineur.Entraineur;
import org.example.tptournoifoot.match.MatchDto;
import org.example.tptournoifoot.tournoiSuisse.TournoiSuisse;
import org.example.tptournoifoot.tournoiSuisse.TournoiSuisseDto;
import org.example.tptournoifoot.tournoiSuisse.TournoiSuisseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joueurs")
public class JoueurController {
    private final JoueurService joueurService;
    private final ObjectMapper objectMapper;

    public JoueurController(JoueurService joueurService, ObjectMapper objectMapper) {
        this.joueurService = joueurService;
        this.objectMapper = objectMapper;
    }


    @PostMapping
    public Joueur save(@RequestBody Joueur joueur) throws BadRequestException {
        return joueurService.save(joueur);
    }
    @GetMapping("/{id}")
    public JoueurDto findById(@PathVariable Integer id){
        Joueur joueur = joueurService.findById(id);
        JoueurDto joueurDto = new JoueurDto();

        joueurDto.setId(joueurDto.getId());
        joueurDto.setNom(joueurDto.getNom());
        joueurDto.setPrenom(joueurDto.getPrenom());
        joueurDto.setNumero(joueurDto.getNumero());
        joueurDto.setEquipeDto(joueurDto.getEquipeDto());


        return joueurDto;
    }
    @DeleteMapping
    public void delete(@RequestBody Joueur joueur){
        joueurService.delete(joueur);
    }
    @GetMapping
    public List<Joueur> findAll(){
        return joueurService.findAll();
    }
}