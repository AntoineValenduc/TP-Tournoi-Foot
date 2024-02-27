package org.example.tptournoifoot.equipe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EquipeCantBeNullException extends IllegalArgumentException {

    public EquipeCantBeNullException(){
        super("L'Acteur ne peux pas être null");
    }

}
