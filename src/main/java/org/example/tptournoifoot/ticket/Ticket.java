package org.example.tptournoifoot.ticket;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "numero_de_range")
    private Integer numeroRange;

    @Column(name = "prix")
    private double prix;
}
//ManyToOne Tickets  correspond a un supporter