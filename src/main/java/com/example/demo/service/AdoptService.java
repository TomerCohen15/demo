package com.example.demo.service;

import com.example.demo.entity.Animal;
import com.example.demo.entity.Cat;
import com.example.demo.entity.Dog;
import com.example.demo.entity.Person;
import com.example.demo.repository.CatRepository;
import com.example.demo.repository.DogRepository;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdoptService {

    private final CatRepository catRepository;
    private final DogRepository dogRepository;
    private final PersonRepository personRepository;

    @Autowired
    public AdoptService(CatRepository catRepository, DogRepository dogRepository, PersonRepository personRepository) {
        this.catRepository = catRepository;
        this.dogRepository = dogRepository;
        this.personRepository = personRepository;
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    // public Animal updateAnimalAdoptedBy(Long animalId, Person adopter, String desiredAnimal)
    public Animal updateAnimalAdoptedBy(Long animalId, Person adopter) {
        Optional<Dog> dogOptional = dogRepository.findById(animalId);
        if (dogOptional.isPresent()) {
            Dog dog = dogOptional.get();
            dog.setAdoptedBy(adopter);
            return dogRepository.save(dog);
        }

        Optional<Cat> catOptional = catRepository.findById(animalId);
        if (catOptional.isPresent()) {
            Cat cat = catOptional.get();
            cat.setAdoptedBy(adopter);
            return catRepository.save(cat);
        }

        throw new RuntimeException("Animal with ID " + animalId + " not found");
    }
}
