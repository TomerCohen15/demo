package com.example.demo.repository;

import com.example.demo.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CatRepository extends JpaRepository<Cat, UUID> {
    Optional<Cat> findByNameAndAge(String name, int age);

    Optional<Cat> findCatByAgeBetween(int ageAfter, int ageBefore);

    Optional<Cat> findCatById(UUID id);

    Optional<Cat> getCatById(UUID id);
}
