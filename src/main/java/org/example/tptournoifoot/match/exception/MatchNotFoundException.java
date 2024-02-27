package org.example.tptournoifoot.match.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MatchNotFoundException extends NullPointerException{

    public MatchNotFoundException(Integer id){
        super("Le match n'existe pas en bdd pour l'id :" +id);
    }
}
