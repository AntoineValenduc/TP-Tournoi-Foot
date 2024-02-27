package org.example.tptournoifoot.ticket;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TicketMapStruct {
    public TicketMapStruct INSTANCE = Mappers.getMapper(TicketMapStruct.class);

    @Mapping(source = "id", target = "id")
    public TicketDto toDtoComplet(Ticket entity);

    @Mapping(source = "id", target = "id")
    public Ticket toEntityComplet(TicketDto dto);
}
