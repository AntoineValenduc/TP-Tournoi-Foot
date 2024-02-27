package org.example.tptournoifoot.equipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

    @Autowired
    private EquipeService equipeService;

    @GetMapping
    public List<EquipeDto> getAllEquipes() {
        return equipeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<EquipeDto> getEquipeById(@PathVariable Integer id) {
        return equipeService.getEquipeById(id);
    }

    @PostMapping
    public void saveEquipe(@RequestBody EquipeDto equipe) {
        equipeService.save(equipe);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipe(@PathVariable Integer id) {
        equipeService.deleteById(id);
    }

    // Endpoint pour ajouter une équipe à un match
    @PostMapping("/{idEquipe}/ajouter-au-match/{idMatch}")
    public boolean ajouterEquipeAMatch(@PathVariable Integer idEquipe, @PathVariable Integer idMatch) {
        return equipeService.ajouterEquipeAMatch(idEquipe, idMatch);
    }
}

