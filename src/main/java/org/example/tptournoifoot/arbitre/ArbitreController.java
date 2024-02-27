package org.example.tptournoifoot.arbitre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/arbitres")
public class ArbitreController {

    private final ArbitreService arbitreService;

    @Autowired
    public ArbitreController(ArbitreService arbitreService) {
        this.arbitreService = arbitreService;
    }

    @GetMapping
    public ResponseEntity<List<Arbitre>> getAllArbitres() {
        List<Arbitre> arbitres = arbitreService.findAll();
        return new ResponseEntity<>(arbitres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arbitre> getArbitreById(@PathVariable Integer id) {
        Optional<Arbitre> arbitre = arbitreService.getArbitreById(id);
        return arbitre.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Arbitre> createArbitre(@RequestBody Arbitre arbitre) {
        Arbitre createdArbitre = arbitreService.save(arbitre);
        return new ResponseEntity<>(createdArbitre, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArbitre(@PathVariable Integer id) {
        arbitreService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/assigner-match")
    public ResponseEntity<Void> assignerArbitreAMatch(@RequestParam Integer idArbitre, @RequestParam Integer idMatch) {
        boolean assigned = arbitreService.assignerArbitreAMatch(idArbitre, idMatch);
        if (assigned) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
