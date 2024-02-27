package org.example.tptournoifoot.equipe;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EquipeMapStruct {

    public EquipeMapStruct INSTANCE = Mappers.getMapper(EquipeMapStruct.class);

    @Mapping(source = "id", target = "id")
    public EquipeDto toDtoComplet(Equipe equipe);

    @Mapping(source = "id", target = "id")
    public Equipe toEntityComplet(EquipeDto equipeDto);
}
