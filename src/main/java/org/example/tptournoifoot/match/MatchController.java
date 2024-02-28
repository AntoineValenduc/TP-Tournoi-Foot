package org.example.tptournoifoot.match;

import org.example.tptournoifoot.ticket.TicketMapStruct;
import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import java.time.LocalTime;
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
        matchDto.setDateHoraire(match.getDateHoraire());
        matchDto.setResultat(match.getResultat());
        matchDto.setDuree(match.getDuree());
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

    //DELETE by id un match
    @DeleteMapping("/{id}")
    public void deleMatchById(@PathVariable Integer id){
        matchService.deleteMatchById(id);
    }

    //PUT (update) match
    @PutMapping
    public Match updateMatch(@RequestBody Match match, @PathVariable Integer id){
        match.setId(id);
        return matchService.updateMatch(match,id);
    }

    //POST
    @PostMapping
    public Match saveMatch(@RequestBody Match match){
        return matchService.saveMatch(match);
    }
    @GetMapping
    public List<Match>MatchsByDate(@RequestParam("date") LocalDate date) {
        return matchService.MatchsByDate(date);
    }

    @PostMapping
    public Match creerMatch(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam("stade_id") Integer id) {
        return matchService.creerMatch(date, id);
    }
}
