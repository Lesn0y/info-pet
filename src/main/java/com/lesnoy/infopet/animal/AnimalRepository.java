package com.lesnoy.infopet.animal;

import com.lesnoy.infopet.animal.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
