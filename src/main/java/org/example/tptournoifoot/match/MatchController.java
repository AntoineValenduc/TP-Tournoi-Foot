package org.example.tptournoifoot.match;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matchs")
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    //GET tout les matchs
    @GetMapping
    public List<Match> findAllMatch(){
        return matchService.findAllMatch();
    }

    //GET by Id un match
    @GetMapping("/{id}")
    public Match findMatchById(@PathVariable Integer id) {
        return matchService.findMatchById(id);
    }

    //DELETE by id un match
    @DeleteMapping("/{id}")
    public void deleMatchById(@PathVariable Integer id){
        matchService.deleteMatchById(id);
    }

    //PUT (update) match
    @PutMapping
    public Match updateMatch(@RequestBody Match match){
        return matchService.updateMatch(match);
    }

    //POST
    @PostMapping
    public Match saveMatch(@RequestBody Match match){
        return matchService.saveMatch(match);
    }
}
