package com.lesnoy.infopet.breed;

import com.lesnoy.infopet.filter.Filter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreedRepository extends JpaRepository<Breed, Integer> {

    List<Breed> findAllByNameContains(String query);

    Page<List<Breed>> findAllByAnimalId(Integer animalId, Pageable pageable);

    List<Breed> findBreedsByAnimalIdAndFiltersIsIn(int animalId, List<Filter> filters);

}
