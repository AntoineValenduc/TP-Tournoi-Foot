package org.example.tptournoifoot.entraineur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EntraineurMapStruct {
    public EntraineurMapStruct INSTANCE = Mappers.getMapper(EntraineurMapStruct.class);

    @Mapping(source = "id", target = "id")
    public EntraineurDto toDtoComplet(Entraineur entraineur);

    @Mapping(source = "id", target = "id")
    public Entraineur toEntityComplet(EntraineurDto dto);
}