package org.example.tptournoifoot.tournoiSuisse;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.BadRequestException;
import org.example.tptournoifoot.match.MatchDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournoiSuisse")
public class TournoiSuisseController {
    private final TournoiSuisseService tournoiSuisseService;
    private final ObjectMapper objectMapper;
    public TournoiSuisseController(TournoiSuisseService tournoiSuisseService, ObjectMapper objectMapper) {
        this.tournoiSuisseService = tournoiSuisseService;
        this.objectMapper = objectMapper;
    }


    @PostMapping
    public TournoiSuisse save(@RequestBody TournoiSuisse tournoiSuisse) throws BadRequestException {
        return tournoiSuisseService.save(tournoiSuisse);
    }
    @GetMapping("/{id}")
    public TournoiSuisseDto findById(@PathVariable Integer id){
        TournoiSuisse tournoiSuisse = tournoiSuisseService.findById(id);
        TournoiSuisseDto tournoiSuisseDto = new TournoiSuisseDto();

        tournoiSuisseDto.setId(tournoiSuisse.getId());
        tournoiSuisseDto.setClassement(tournoiSuisse.getClassement());
        tournoiSuisseDto.setEquipeQualifier(tournoiSuisse.isEquipeQualifier());
        tournoiSuisseDto.setEquipeDisqualifier(tournoiSuisse.isEquipeDisqualifier());
        tournoiSuisseDto.setMatchs(
                tournoiSuisse.getMatchs().stream().map(
                        match -> objectMapper.convertValue(tournoiSuisse, MatchDto.class)
                ).toList()
        );

        return tournoiSuisseDto;
    }
    @DeleteMapping("/{id}")
    public void deleteById(@RequestBody TournoiSuisse tournoiSuisse){
        tournoiSuisseService.delete(tournoiSuisse);
    }

    @GetMapping
    public List<TournoiSuisse> findAll(){
        return tournoiSuisseService.findAll();
    }

    @PostMapping("/creationTournoi")
    public void creationTournoi() throws BadRequestException {
        tournoiSuisseService.creationTournoi();
    }
}
