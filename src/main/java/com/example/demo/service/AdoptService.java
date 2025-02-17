package com.example.demo.service;

import com.example.demo.entity.Animal;
import com.example.demo.entity.Person;
import com.example.demo.repository.AnimalRepository;
import com.example.demo.repository.CatRepository;
import com.example.demo.repository.DogRepository;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdoptService {

    private final AnimalRepository animalRepository;
    private final PersonRepository personRepository;

    @Autowired
    public AdoptService(AnimalRepository animalRepository, CatRepository catRepository, DogRepository dogRepository, PersonRepository personRepository) {
        this.animalRepository = animalRepository;
        this.personRepository = personRepository;
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Animal updateAnimalAdoptedBy(UUID animalId, Person adopter) {
        Optional<Animal> animalOptional = animalRepository.findById(animalId);
        if (animalOptional.isPresent()) {
            Animal animal = animalOptional.get();
            animal.setAdoptedBy(adopter);
            animal.setAdoptedDate(LocalDateTime.now());
            animalRepository.save(animal);
            return animal;
        }
        throw new RuntimeException("Animal with ID " + animalId + " not found");
    }

    public List<Animal> getAllAdoptedAnimals() { return animalRepository.findAllByAdoptedByIsNotNull(); }
}
