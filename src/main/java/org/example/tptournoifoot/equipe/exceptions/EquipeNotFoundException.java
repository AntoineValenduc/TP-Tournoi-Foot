package org.example.tptournoifoot.equipe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EquipeNotFoundException extends NullPointerException{

    public EquipeNotFoundException(Integer id){
        super("L'équipe n'existe pas en bdd pour l'id : " +id);
    }
}
