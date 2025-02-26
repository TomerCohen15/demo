package com.example.demo.repository;

import com.example.demo.dto.AnimalWithoutAdoptedByDTO;
import com.example.demo.entity.Animal;
import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AnimalRepository extends JpaRepository<Animal, UUID> {
    List<Animal> findAllByAdoptedByIsNotNull();

    List<AnimalWithoutAdoptedByDTO> findByAdoptedBy(Person adoptedBy);
}
