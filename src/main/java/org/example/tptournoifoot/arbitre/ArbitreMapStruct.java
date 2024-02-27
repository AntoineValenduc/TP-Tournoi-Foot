package org.example.tptournoifoot.arbitre;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArbitreMapStruct {
    public ArbitreMapStruct INSTANCE = Mappers.getMapper(ArbitreMapStruct.class);

    @Mapping(source = "id", target = "id")
    public ArbitreDto toDtoComplet(Arbitre entity);

    @Mapping(source = "id", target = "id")
    public Arbitre toEntityComplet(ArbitreDto dto);
}