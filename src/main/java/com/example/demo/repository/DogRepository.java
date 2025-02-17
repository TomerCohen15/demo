package com.example.demo.repository;

import com.example.demo.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DogRepository extends JpaRepository<Dog, UUID> {
    Optional<Dog> findByNameAndAge(String name, int age);

    Optional<Dog> findDogByAgeBetween(int ageAfter, int ageBefore);

    Optional<Dog> findDogById(UUID id);

    Optional<Dog> getDogById(UUID id);

}
