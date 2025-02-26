package com.example.demo.dto;

import com.example.demo.entity.Animal;
import com.example.demo.entity.Person;

import java.util.List;

public class PersonWithAdoptedAnimalsDTO {

    private Person person;
    private List<AnimalWithoutAdoptedByDTO> adoptedAnimals;

    public PersonWithAdoptedAnimalsDTO(Person person, List<AnimalWithoutAdoptedByDTO> adoptedAnimals) {
        this.person = person;
        this.adoptedAnimals = adoptedAnimals;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<AnimalWithoutAdoptedByDTO> getAdoptedAnimals() {
        return adoptedAnimals;
    }

    public void setAdoptedAnimals(List<AnimalWithoutAdoptedByDTO> adoptedAnimals) {
        this.adoptedAnimals = adoptedAnimals;
    }
}
