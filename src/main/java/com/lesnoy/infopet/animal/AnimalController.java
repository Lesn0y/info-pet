package com.lesnoy.infopet.animal;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/animal")
public class AnimalController {

    private final AnimalRepository repository;

    @GetMapping("/{id}")
    @Operation(description = "Получить фильтры и название живлтного по ID")
    public ResponseEntity<Animal> getAnimal(
            @PathVariable("id") @Parameter(name = "ID животного") int id) {
        return ResponseEntity.ok(repository.findById(id)
                .orElseThrow(RuntimeException::new));
    }
}
