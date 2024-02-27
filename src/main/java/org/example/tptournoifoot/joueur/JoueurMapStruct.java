package org.example.tptournoifoot.joueur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface JoueurMapStruct {
    public JoueurMapStruct INSTANCE = Mappers.getMapper(JoueurMapStruct.class);

    @Mapping(source = "id", target = "id")
    public JoueurDto toDtoComplet(Joueur joueur);

    @Mapping(source = "id", target = "id")
    public Joueur toEntityComplet(JoueurDto dto);
}