package com.lesnoy.infopet.breed;

import com.lesnoy.infopet.filter.Filter;
import com.lesnoy.infopet.filter.FilterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BreedService {

    private final BreedRepository breedRepository;
    private final FilterRepository filterRepository;

    @Transactional
    public Optional<Breed> findBreedById(Integer id) {
        return breedRepository.findById(id);
    }

    @Transactional
    public List<Breed> findBreedsWithName(String query) {
        return breedRepository.findAllByNameContains(query);
    }

    @Transactional
    public List<Breed> findBreedsWithFilters(
            int animalId,
            String filters) {

        List<Filter> filterList = filterRepository.findAllById(
                Arrays.stream(filters
                                .split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toSet()));
        return breedRepository.findBreedsByAnimalIdAndFiltersIsIn(animalId, filterList);

    }

    public Page<List<Breed>> findBreedsPageable(Integer animalId, Integer page, Integer size) {
        return breedRepository.findAllByAnimalId(animalId, PageRequest.of(page, size));
    }
}
