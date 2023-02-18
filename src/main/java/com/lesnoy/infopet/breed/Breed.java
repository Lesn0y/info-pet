package com.lesnoy.infopet.breed;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lesnoy.infopet.animal.Animal;
import com.lesnoy.infopet.filter.Filter;
import com.lesnoy.infopet.entity.Parameters;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(using = BreedSerializer.class)
@Entity
@Table(name = "breeds", schema = "infopet")
public class Breed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
    @Column(name = "img_url")
    private String imgUrl;
    @Column(name = "breed_name")
    private String name;
    @OneToMany
    @JoinColumn(name = "breed_id")
    private Set<Parameters> parameters;
    @ManyToMany
    @JoinTable(name = "breed_filters", schema = "infopet",
    joinColumns = @JoinColumn(name = "breed_id"),
    inverseJoinColumns = @JoinColumn(name = "filters_id"))
    private Set<Filter> filters;
    @Column(name = "subtitle")
    private String subtitle;
    @Column(name = "character")
    private String character;
    @Column(name = "training")
    private String training;
    @Column(name = "diet")
    private String diet;
    @Column(name = "care")
    private String care;
    @Column(name = "gallery_url")
    private String packageUrl;
}
