package com.example.demo.dto;

import com.example.demo.entity.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;
import java.util.UUID;

public class AnimalWithoutAdoptedByDTO {
    private UUID id;
    private String name;
    private String breed;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public AnimalWithoutAdoptedByDTO(UUID id, String name, String breed, int age, Gender gender, LocalDateTime adoptedDate, LocalDateTime timestamp) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
