package org.example.tptournoifoot.stade;

import org.example.tptournoifoot.match.MatchMapStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stades")
public class StadeController {

    @Autowired
    private StadeService stadeService;

    @GetMapping
    public List<Stade> getAllStades() {
        return stadeService.findAll();
    }

    @GetMapping("/{id}")
    public StadeDto findById(@PathVariable Integer id){
        Stade stade = stadeService.findById(id);

        StadeDto stadeDto = new StadeDto();

        stadeDto.setId(stade.getId());
        stadeDto.setNom(stade.getNom());
        stadeDto.setVille(stade.getVille());
        stadeDto.setCapacite(stade.getCapacite());
        stadeDto.setMatchsDto(
                stade.getMatchs().stream().map(
                        MatchMapStruct.INSTANCE::toDtoComplet
                ).toList()
        );

        return stadeDto;

    }

    @PostMapping
    public Stade saveStade(@RequestBody Stade stade) {
        return stadeService.save(stade);
    }

    @DeleteMapping("/{id}")
    public void deleteStade(@PathVariable Integer id) {
        stadeService.deleteById(id);
    }

    // Endpoint pour gérer les flux entrants
    @PostMapping("/{id}/flux-entrants")
    public boolean gererFluxEntrants(@PathVariable Integer id, @RequestParam int nombrePersonnes) {
        return stadeService.gererFluxEntrants(id, nombrePersonnes);
    }
}
