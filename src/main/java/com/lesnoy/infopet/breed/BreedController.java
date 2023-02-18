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
@RequestMapping("/api/v1/breeds")
@RequiredArgsConstructor
public class BreedController {

    private final BreedRepository repository;
    private final BreedService service;

    @GetMapping
    @Operation(description = "Получить животных по id и фильтрам")
    public ResponseEntity<Page<List<Breed>>> findWithFilters(
            @RequestParam(value = "animal", required = false) @Parameter(description = "ID животного") int id,
            @RequestParam(value = "q", required = false) @Parameter(description = "Поисковой запрос") String query,
            @RequestParam(value = "filters", required = false) @Parameter(description = "Список фильров разделяемых заяптой, если параметр отсуствует, вернуться все") String filters,
            @RequestParam(value = "page", required = false, defaultValue = "0") @Parameter(description = "Номер страницы пагинации, начиная с 0") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "12")  @Parameter(description = "Количество элементов на странице, дефолтное значение 12")Integer size) {
        return ResponseEntity.ok(
                service.getBreedsWithFilters(id, filters, page, size));
    }

    @GetMapping("/{id}")
    @Operation(description = "Получить конкретную пароду по id")
    public ResponseEntity<Optional<Breed>> getBreedById(
            @PathVariable("id") @Parameter(description = "ID пароды") int id) {
        return ResponseEntity.ok(repository.findById(id));
    }
}