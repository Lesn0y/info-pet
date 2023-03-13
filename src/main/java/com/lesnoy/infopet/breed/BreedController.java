package com.lesnoy.infopet.breed;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://127.0.0.1:4200")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BreedController {

    private final BreedService service;

    @GetMapping("/breeds")
    @Operation(description = "Get all breeds with name = 'q'")
    public ResponseEntity<List<Breed>> findAllBreedsByName(
            @RequestParam(value = "q")
            @Parameter(description = "Query with breed name") String query) {
        return ResponseEntity.ok(service.findBreedsWithName(query));
    }

    @GetMapping("/breeds/{id}")
    @Operation(description = "Get breed by id")
    public ResponseEntity<?> getBreedById(
            @PathVariable("id") Integer breedId) {
        Optional<Breed> breed = service.findBreedById(breedId);
        return breed.isPresent() ? ResponseEntity.ok(breed.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{animal_id}/breeds")
    @Operation(description = "Get breed by animal id with filters(optional)")
    public ResponseEntity<?> findBreeds(
            @PathVariable("animal_id") Integer animalId,
            @RequestParam(value = "filters", required = false) String filters,
            @RequestParam(value = "page", required = false) @Parameter(description = "OPTIONAL, zero-based page index") Integer page,
            @RequestParam(value = "size", required = false) @Parameter(description = "OPTIONAL, the size of the page to be returned") Integer size) {
        if (filters != null) {
            return ResponseEntity.ok(service.findBreedsWithFilters(animalId, filters));
        }
        return ResponseEntity.ok(service.findBreedsPageable(animalId, page, size));
    }

}