package org.example.tptournoifoot.stade;

import org.example.tptournoifoot.stade.Dto.StadeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StadeMapStruct {
    public StadeMapStruct INSTANCE = Mappers.getMapper(StadeMapStruct.class);

    @Mapping(source = "id", target = "id")
    public StadeDto toDtoComplet(Stade entity);

    @Mapping(source = "id", target = "id")
    public Stade toEntityComplet(StadeDto dto);
}
