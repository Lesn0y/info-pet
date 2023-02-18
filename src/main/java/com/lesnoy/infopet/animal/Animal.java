package com.lesnoy.infopet.animal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lesnoy.infopet.filter.Filter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "animals", schema = "infopet")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("animal")
    @Column(name = "animal_name")
    private String animalName;
    @ManyToMany
    @JoinTable(name = "animal_filters", schema = "infopet",
    joinColumns = @JoinColumn(name = "animal_id"),
    inverseJoinColumns = @JoinColumn(name = "filters_id"))
    private List<Filter> filters;
}
