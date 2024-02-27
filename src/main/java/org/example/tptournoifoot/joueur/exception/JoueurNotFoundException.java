package org.example.tptournoifoot.joueur.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JoueurNotFoundException extends RuntimeException{
    public JoueurNotFoundException(){
        super("Joueur non trouvé");
    }

}