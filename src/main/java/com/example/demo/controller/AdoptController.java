package com.example.demo.controller;

import com.example.demo.dto.PersonWithAdoptedAnimalsDTO;
import com.example.demo.entity.Animal;
import com.example.demo.entity.Person;
import com.example.demo.service.AdoptService;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/adopts")
public class AdoptController {
    private static final Logger logger = LoggerFactory.getLogger(AdoptController.class);
    private final AdoptService adoptService;
    private final PersonService personService;


    @Autowired
    public AdoptController(AdoptService adoptService, PersonService personService) {
        this.adoptService = adoptService;
        this.personService = personService;
    }

    @PostMapping("/adoptAnimalByNewPerson")
    public Person adoptByNewPerson(@RequestBody Person adopter, @RequestParam("animalId") UUID animalId) {
        Person newPerson = adoptService.savePerson(adopter);
        Animal animal = adoptService.updateAnimalAdoptedBy(animalId, newPerson);
        logger.info("Person {} adopted Animal {}", newPerson.getName(), animal.getId());
        return newPerson;
    }

    @PostMapping("/adoptAnimalByExistPerson")
    public Person adoptByExistPerson(@RequestParam("personId") UUID personID, @RequestParam("animalId") UUID animalId) {
        Person person = personService.getPersonById(personID);
        Animal animal = adoptService.updateAnimalAdoptedBy(animalId, person);
        logger.info("Person {} adopted Animal {}", person.getName(), animal.getId());
        return person;
    }


    @GetMapping("/getAllAdoptedAnimals")
    public List<Animal> getAllAdoptedAnimals() {
        return adoptService.getAllAdoptedAnimals();
    }

    @GetMapping("/getAdoptedAnimalsByPerson")
    public PersonWithAdoptedAnimalsDTO getAdoptedAnimalsByPerson(@RequestParam("personId") UUID personId) {
        return adoptService.getAdoptedAnimalsByPerson(personId);
    }
}
