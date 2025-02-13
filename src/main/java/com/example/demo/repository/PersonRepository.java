package com.example.demo.repository;

import com.example.demo.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Dog, Long> {
    Optional<Dog> findByNameAndAge(String name, int age);

    Optional<Dog> findDogByAgeBetween(int ageAfter, int ageBefore);

    Optional<Dog> findDogById(long id);

    Optional<Dog> getDogById(Long id);
}