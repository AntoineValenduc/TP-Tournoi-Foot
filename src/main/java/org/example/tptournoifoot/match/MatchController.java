package org.example.tptournoifoot.match;

import org.example.tptournoifoot.ticket.TicketMapStruct;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public MatchDto findMatchById(@PathVariable Integer id) {
        Match match = matchService.findMatchById(id);

        MatchDto matchDto = new MatchDto();

        matchDto.setId(match.getId());
        matchDto.setDate(match.getDate());
        matchDto.setResultat(match.getResultat());
        // besoin mapstruct de l'arbitre pour continuer :)
        // besoin mapstruct du stade pour continuer :)
        // besoin mapstruct de tournoiSuisse pour continuer :)

        matchDto.setTicketsDto(
                match.getTickets().stream().map(
                        TicketMapStruct.INSTANCE::toDtoComplet
                ).toList()
        );

        // besoin mapstruct de équipe pour continuer :)

        return matchDto;



    }

    //GET matchs by date
    @GetMapping("/byDate")
    public List<Match> matchsByDate(@RequestParam("date") LocalDate date) {
        return matchService.MatchsByDate(date);
    }

    //DELETE by id un match
    @DeleteMapping("/{id}")
    public void deleMatchById(@PathVariable Integer id){
        matchService.deleteMatchById(id);
    }

    //PUT (update) match
    @PutMapping
    public Match updateMatch(@RequestBody Match match, Integer id){
        return matchService.updateMatch(match,id);
    }

    //POST
    @PostMapping
    public Match saveMatch(@RequestBody Match match){
        return matchService.saveMatch(match);
    }
}
