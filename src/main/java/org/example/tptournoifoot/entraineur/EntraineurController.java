package org.example.tptournoifoot.entraineur;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.BadRequestException;
import org.example.tptournoifoot.tournoiSuisse.TournoiSuisse;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.List;

@RestController
@RequestMapping("/entraineurs")
public class EntraineurController {
    private final EntraineurService entraineurService;
    private final ObjectMapper objectMapper;
    public EntraineurController(EntraineurService entraineurService, ObjectMapper objectMapper) {
        this.entraineurService = entraineurService;
        this.objectMapper = objectMapper;
    }
    @PostMapping
    public Entraineur save(@RequestBody Entraineur entraineur) throws BadRequestException {
        return entraineurService.save(entraineur);
    }
    @GetMapping("/{id}")
    public EntraineurDto findById(@PathVariable Integer id){
        Entraineur entraineur = entraineurService.findById(id);
        EntraineurDto entraineurDto = new EntraineurDto();
        entraineurDto.setId(entraineur.getId());
        entraineurDto.setNom(entraineur.getNom());
        entraineurDto.setPrenom(entraineurDto.getPrenom());
        entraineurDto.setEquipeDto(entraineurDto.getEquipeDto());
        return entraineurDto;
    }
    @DeleteMapping("/{id}")
    public void delete(@RequestBody Entraineur entraineur){
        entraineurService.delete(entraineur);
    }
    @GetMapping
    public List<Entraineur> findAll(){
        return entraineurService.findAll();
    }
}
