package com.example.demo.repository;

import com.example.demo.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
    Optional<Cat> findByNameAndAge(String name, int age);

    Optional<Cat> findCatByAgeBetween(int ageAfter, int ageBefore);

    Optional<Cat> findCatById(long id);

    Optional<Cat> getCatById(Long id);
}
