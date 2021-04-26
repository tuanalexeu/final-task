package com.alekseytyan.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "MAP")
@Getter @Setter @NoArgsConstructor
@EqualsAndHashCode
public class Map {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "FROM_CITY")
    private City cityFrom;

    @ManyToOne(optional = false)
    @JoinColumn(name = "TO_CITY")
    private City cityTo;

    @Column(name = "DISTANCE")
    @Min(0)
    private int distance;

}
