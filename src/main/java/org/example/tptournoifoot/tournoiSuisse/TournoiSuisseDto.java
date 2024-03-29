package org.example.tptournoifoot.tournoiSuisse;

import lombok.Data;
import org.example.tptournoifoot.match.MatchDto;

import java.util.ArrayList;
import java.util.List;

@Data
public class TournoiSuisseDto {

    private Integer id;
    private String classement;
    private boolean equipeQualifier;
    private boolean equipeDisqualifier;
    private List<MatchDto> matchs = new ArrayList<>();
}
