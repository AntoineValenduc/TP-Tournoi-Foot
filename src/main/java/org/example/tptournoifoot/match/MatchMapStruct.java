package org.example.tptournoifoot.match;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MatchMapStruct {
    public MatchMapStruct INSTANCE = Mappers.getMapper(MatchMapStruct.class);

    @Mapping(source = "id", target = "id")
    public MatchDto toDtoComplet(Match entity);

    @Mapping(source = "id", target = "id")
    public Match toEntityComplet(MatchDto dto);
}