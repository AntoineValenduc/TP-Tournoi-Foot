package org.example.tptournoifoot.stade;

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
    public Optional<Stade> getStadeById(@PathVariable Integer id) {
        return stadeService.getStadeById(id);
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
