package org.example.tptournoifoot.tournoiSuisse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TournoiSuisseMapStruct {
    public TournoiSuisseMapStruct INSTANCE = Mappers.getMapper(TournoiSuisseMapStruct.class);

    @Mapping(source = "id", target = "id")
    public TournoiSuisseDto toDtoComplet(TournoiSuisse tournoiSuisse);

    @Mapping(source = "id", target = "id")
    public TournoiSuisse toEntityComplet(TournoiSuisseDto dto);
}