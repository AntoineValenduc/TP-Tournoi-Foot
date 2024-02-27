package org.example.tptournoifoot.supporter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SupporterMapStruct {
    public SupporterMapStruct INSTANCE = Mappers.getMapper(SupporterMapStruct.class);

    @Mapping(source = "id", target = "id")
    public SupporterDto toDtoComplet(Supporter entity);

    @Mapping(source = "id", target = "id")
    public Supporter toEntityComplet(SupporterDto dto);
}