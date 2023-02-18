package com.lesnoy.infopet.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "breeds_parameters", schema = "infopet")
public class Parameters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "parameter")
    private String parameter;
    @Column(name = "value")
    private String value;
}
