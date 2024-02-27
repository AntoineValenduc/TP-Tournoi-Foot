package org.example.tptournoifoot.tournoiSuisse.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TournoiSuisseNotFoundException extends RuntimeException{
    public TournoiSuisseNotFoundException(){
        super("TournoiSuisse non trouvé");
    }

}