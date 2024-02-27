package org.example.tptournoifoot.entraineur.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntraineurNotFoundException extends RuntimeException{
    public EntraineurNotFoundException(){
        super("Entraineur non trouvé");
    }

}