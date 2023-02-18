package com.lesnoy.infopet.breed;

import com.lesnoy.infopet.filter.Filter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreedRepository extends JpaRepository<Breed, Integer> {

    Page<List<Breed>> findBreedsByAnimalId(int animalId, Pageable pageable);

    Page<List<Breed>> findBreedsByAnimalIdAndFiltersIsIn(int animalId,
                                                        List<Filter> filters,
                                                        Pageable pageable);
}
